/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackboardish;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Bruno
 */
public class Controller {
    
    public Blackboard pizarra;
    public ArrayList<knowledgeSource> Fuentes;
    
    public void init(){
        this.Fuentes=new ArrayList<knowledgeSource>();
        this.pizarra=new Blackboard();
        Fuentes.add(new eager("Nobru", pizarra));
        Fuentes.add(new eager("Drope",pizarra));
        Fuentes.add(new Methodic("Perfecto", pizarra));
        Fuentes.add(new breaktrought("Secus", pizarra));
        Fuentes.add(new Proff("Mastah", pizarra));
        loop();
        show();
 
        
        
    }
    public void loop(){
        while(pizarra.Progreso<100){
            selectKS();
            System.out.println(pizarra.listaCont.get(pizarra.listaCont.size()-1).nombre+" Contribuyó!---NUEVA TAREA: "+pizarra.Tarea);
            System.out.println("PROGRESO:  "+pizarra.Progreso+"%");
        }
        
    }
    
    public void show(){
        
    }
    public void selectKS(){
        Random rnd=new Random();
        boolean empty=true;
        int pick; //a cual se escoge
        while(empty){
            pick=rnd.nextInt(Fuentes.size());
            //Mostrar a quien va Eligiendo
            //Posible siguiente paso: Elegir solo a quienes si pueden contribuir? Suena interesante
            
            System.out.println("Viendo si "+Fuentes.get(pick).nombre+" Puede Contribuir");
            if(Fuentes.get(pick).vaContribuir()){
                Fuentes.get(pick).contribuir();
                empty=false;
                pizarra.listaCont.add(Fuentes.get(pick));
            }       
        }
        
    }
    
}
