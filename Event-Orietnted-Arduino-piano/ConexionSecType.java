package piano;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier; 
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent; 
import gnu.io.SerialPortEventListener; 
import java.util.Enumeration;

//Sacado de http://stackoverflow.com/questions/15996345/java-arduino-read-data-from-the-serial-port

//DATO IMPORTANTE: AL SER UNA CONEXION 2 WAY NECESITO COMUNICARLA CON LA CLASE PRINCIPAL
public class ConexionSecType implements SerialPortEventListener {
SerialPort serialPort;
    /** The port we're normally going to use. */
private static final String PORT_NAMES[] = {                
        "COM3", // Por Defecto
};

private VentanaPianoSec piano;
private BufferedReader input;
private OutputStream output;
private static final int TIME_OUT = 2000;
private static final int DATA_RATE = 9600;


// Importante: Pasarle como parametro a QUE se conecta
public ConexionSecType(VentanaPianoSec vent){
	this.piano=vent;
}
public void initialize() {
    CommPortIdentifier portId = null;
    Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

    //First, Find an instance of serial port as set in PORT_NAMES. 
    //TRAD: Encontrar una instancia de Serialport, Segun los PORT_NAMES. Como estamos en windows, solo buscamos COM3
    while (portEnum.hasMoreElements()) {
        CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
        for (String portName : PORT_NAMES) {
            if (currPortId.getName().equals(portName)) {
                portId = currPortId;
                break;
            }
        }
    }
    if (portId == null) {
        System.out.println("Could not find COM port.");
        return;
    }

    try {
        serialPort = (SerialPort) portId.open(this.getClass().getName(),
                TIME_OUT);
        serialPort.setSerialPortParams(DATA_RATE,
                SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE);
        //intentamos conectar

        // open the streams
        input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
        output = serialPort.getOutputStream();
        //Y conectamos
        serialPort.addEventListener(this);
        serialPort.notifyOnDataAvailable(true);
    } catch (Exception e) {
        System.err.println(e.toString());
    }
}


public synchronized void close() {  //segun tengo entendido, esto lo cierra cada vez que no hay Data
    if (serialPort != null) {
        serialPort.removeEventListener();
        serialPort.close();
    }
}


public synchronized void enviarDatos(int b){ //esta funcion no cambia
    try{
        output.write(b);
    }
    catch (Exception e) {
        System.err.println(e.toString());
    }
}
public synchronized void serialEvent(SerialPortEvent oEvent) {  //y esto lo abre cada vez que hay data
    if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
        try {
            String inputLine=null;
            if (input.ready()) {
                inputLine = input.readLine();
               piano.read(inputLine); //con este Metodo enviamos la lectura
            }

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    // Ignore all the other eventTypes, but you should consider the other ones.
}


}