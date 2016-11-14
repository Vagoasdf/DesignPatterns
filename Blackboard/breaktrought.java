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
 * breaktrought avanza mucho pero en condiciones especificas, necesita exactamente un 2 o un 5 para avanzar.
 * Siempre deja una tarea tipo 4 o mayor
 */
public class breaktrought extends knowledgeSource {
 
    
    private Random azar=new Random();
    public breaktrought(String nombre, Blackboard blckBoard){
        super(blckBoard);
        this.nombre=nombre;
    }   
    @Override
    public boolean vaContribuir(){
        if (this.pizarra.Tarea==2||this.pizarra.Tarea==5){
            return true;
        }else return false;
    }
    @Override
    public void  contribuir(){
    
            pizarra.Progreso+=(azar.nextInt(5)+5); //eager no ayuda mucho, pero ayuda casi siempre
            pizarra.Tarea=azar.nextInt(5)+5; //eager lo puede dejar en cualquier punto
        
        
    }
}
