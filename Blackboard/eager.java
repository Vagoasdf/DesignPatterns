/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackboardish;
import java.util.Random;
/**
 *
 * @author Bruno
 * Eager estara dispuesto a trabajar a menos que la Pizarra
 * tenga un 2 como ultima contribuicion, De tal manera, se espera que actue 
 * de manera frecuente
 */
public class eager extends knowledgeSource{
  
    private Random azar=new Random();
    public eager(String nombre, Blackboard blckBoard){
        super(blckBoard);
        this.nombre=nombre;
    }   
    @Override
    public boolean vaContribuir(){
        if (this.pizarra.Tarea!=2){
            return true;
        }else return false;
    }
    @Override
    public void  contribuir(){
            pizarra.Progreso+=azar.nextInt(5); //eager no ayuda mucho, pero ayuda casi siempre
            pizarra.Tarea=azar.nextInt(9)+1; //eager lo puede dejar en cualquier punto
        
        
    }
    

}
