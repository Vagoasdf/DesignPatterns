package piano;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class VentanaPianoSec extends Frame implements WindowListener{
	private TeclaPiano[] piano;
	private ConexionSecType conexion;
	
	public VentanaPianoSec() {
		super("Piano Arduino");
		this.setLayout(new FlowLayout());
		piano= new TeclaPiano[9];
		for(int i=0;i<9;i++){
			piano[i]=new TeclaPiano(i,this);
			this.add(piano[i]);
		}
		this.setSize(300, 100);
		this.addWindowListener(this);
		this.setVisible(true);
	    this.conexion = new ConexionSecType(this); //conectando
	    conexion.initialize();
	    Thread t=new Thread() {
	        public void run() {
	            //the following line will keep this app alive for 1000    seconds,
	            //waiting for events to occur and responding to them    (printing incoming messages to console).
	            try {Thread.sleep(1000000);} catch (InterruptedException    ie) {}
	            //entonces... si no enviamos nada en 1000 Segundos, la conexion muere. Interesante...
	        }
	    };
	    t.start();
	    System.out.println("Started");
	
	}
	
	
	public void tocarPiano(char nota){  //envia los datos al Arduino, por medio de la conexión
		if (nota=='c')conexion.enviarDatos(0);
		if (nota=='d')conexion.enviarDatos(1);
		if (nota=='e')conexion.enviarDatos(2);
		if (nota=='f')conexion.enviarDatos(3);
		if (nota=='g')conexion.enviarDatos(4);
		if (nota=='a')conexion.enviarDatos(5);
		if (nota=='b')conexion.enviarDatos(6);
		if (nota=='C')conexion.enviarDatos(7);
		if (nota=='O')conexion.enviarDatos(8);
	}
	
	
	
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void read(String inputLine) {
		int lectura= Integer.parseInt(inputLine);
		System.out.println(inputLine);
		if(lectura==1){
			conexion.enviarDatos(8);
			JOptionPane.showMessageDialog(null,"Piano Pausado ");
		}
		
	}

}

