/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackboardish;

/**
 *
 * @author Bruno
 * Segun lo entendido, las diferentes fuentes de conocimeinto interactuan
 * con la Base de Datos (O Similar) de la Pizarra
 * El molde segun el que todas las Fuentes de Conocimiento, o Contribuidores
 * colaborarán es dando un numero al azar para sumar, e interacturan segun el
 * estado en que la pizarra este y un valor aleatorio.
 * 
 */
public class knowledgeSource {
    
    public Blackboard pizarra;
    public String nombre;
    
    public knowledgeSource(Blackboard Piz){
        this.pizarra=Piz;
        
    }
    
    public boolean vaContribuir(){
        return true;
    }
    
    public void contribuir (){
   
    }
    
}


