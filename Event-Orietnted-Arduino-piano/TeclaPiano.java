package piano;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeclaPiano extends Button implements ActionListener {
	private char nota;
	private VentanaPiano laVentana;
	private VentanaPianoSec laOtVentana;
	
	public TeclaPiano(int iNota, VentanaPiano vent){
		if (iNota==0) nota='c';
		if (iNota==1) nota='d';
		if (iNota==2) nota='e';
		if (iNota==3) nota='f';
		if (iNota==4) nota='g';
		if (iNota==5) nota='a';
		if (iNota==6) nota='b';
		if (iNota==7) nota='C';
		if(iNota==8) nota='O';
		this.laVentana=vent;
		this.setLabel(nota+"");
		this.addActionListener(this);
	}

	public TeclaPiano(int iNota, VentanaPianoSec vent) {
		if (iNota==0) nota='c';
		if (iNota==1) nota='d';
		if (iNota==2) nota='e';
		if (iNota==3) nota='f';
		if (iNota==4) nota='g';
		if (iNota==5) nota='a';
		if (iNota==6) nota='b';
		if (iNota==7) nota='C';
		if(iNota==8) nota='O';
		this.laOtVentana=vent;
		this.setLabel(nota+"");
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(laVentana!=null){
			laVentana.tocarPiano(this.nota);
		}
		if(laOtVentana!=null){
			laOtVentana.tocarPiano(this.nota);
		}
	}
}
