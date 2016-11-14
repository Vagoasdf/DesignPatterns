package piano;

//Fijense la version del  RXTXcomm. La version 32x no funciona con 64x. 
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.OutputStream;
import java.util.Enumeration;

/**
 *
 * @author Adrian.  Modificado levemente por Bruno
 */
public class Conexion {
    
    private OutputStream salida=null;
    private SerialPort serialPort;
    private String puerto = "";//tu usb 
    private int tiempoEspera = 2000;
    private int dataRate = 9600;//baudios
    
    
    public Conexion(String puerto){
        this.puerto = puerto;
        inicializarConexion();

        
    }
    
    public void inicializarConexion(){
        CommPortIdentifier iDPuerto = null;//identificador del puerto
        Enumeration enumeracoinPuertos = CommPortIdentifier.getPortIdentifiers();//enumeracion de los puertos creados
        
        while   (enumeracoinPuertos.hasMoreElements()   ){//mientras existan puertos
            CommPortIdentifier iDpuertoActual = (CommPortIdentifier) enumeracoinPuertos.nextElement(); //para buscar puertos
        
            if(puerto.equals(iDpuertoActual.getName())){//para ver si coincide la enumeracion de nuestro puerto con la del puertoactual
                iDPuerto = iDpuertoActual;
                break;
            }
        }
        
        if (iDPuerto == null) {
           
            System.out.println("error");
        }
        
        abrirPuertoSerie(iDPuerto);
        
    }
    
    private void abrirPuertoSerie(CommPortIdentifier iDPuerto ){
        try {
            this.serialPort= (SerialPort) iDPuerto.open(this.getClass().getName(),this.tiempoEspera);//abrimos el puerto
            //configuramos los parametros del puerto abierto
            this.serialPort.setSerialPortParams(dataRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);//(,,,paridad)
            // abrir flujo de datos
            this.salida = serialPort.getOutputStream();
        } catch (Exception e) {
            
            System.out.println("error");
        }
    }
    
    public void enviarDatos(int datos){
        
        try{
            salida.write(datos);
        }catch (Exception e){
            System.out.println("error");
        }
    }
}
    