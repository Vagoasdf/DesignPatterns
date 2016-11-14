/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackboardish;

import java.util.ArrayList;

/**
 *
 * @author Bruno
 * Estoy dejando el Controlador dentro de la Blackboard
 * Como en este ejemplo la blackboard es tan sencilla y simple
 *  prefiero hacerlo asi para ahorrar codigo.
 * La comunicacion es la misma, los metodos de controlador se comunican con los
 * diferentes KS dependiendo del estado de la Tarea sigueinte
 * Hasya que llega al 100% de progreso
 * Los KS solo se comunican para subir el progreso y dejar
 * una nueva Tarea
 *
 */
public class Blackboard {
    public int Tarea; //puede ser del 1 al 10, si es que la tarea es una que los demas puedan hacer, la hacen
    public ArrayList<knowledgeSource> listaCont; //quienes han contribuido
    public int Progreso; //cuando llegue a 100, tamos  
    
   public Blackboard(){
       listaCont=new ArrayList<knowledgeSource>();
       
   }
    
    
}
