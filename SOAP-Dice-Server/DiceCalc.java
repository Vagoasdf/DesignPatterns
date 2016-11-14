/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiceCalculator;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.Random;
import java.util.ArrayList;
/**
 *
 * @author Bruno
 */
@WebService(serviceName = "DiceCalc")
public class DiceCalc {

    private Random roll=new Random();
    
    /**
     * This is a sample web service operation
     */
    

    public ArrayList<Integer> calcularRoll(ArrayList<Integer> listaDados){
        
        int d;
        for(int i=0;i<listaDados.size();i++){
            
            d=listaDados.get(i);
            if(d!=-1 && d!=0){ //0 y -1 son resta/Suma
              if(d==4) d=D4();
              else if(d==6) d=D6();
              else if(d==8) d=D8();
              else if(d==10) d=D10();
              else if(d==12) d=D12();
              else if(d==20) d=D20();
            }
            listaDados.set(i,d);
        } 
        return listaDados;
    }
    
    
    public int sumarTirada(ArrayList<Integer> listaTirada){
        int sum=listaTirada.get(0);
        boolean operation=true; //t = +  f = -
        for(int i=1;i<listaTirada.size();i++){
            if(listaTirada.get(i)==0){
                operation=false;
            }else if(listaTirada.get(i)==-1){
                operation=true;
            }else{
                if(operation){
                    sum=sum+listaTirada.get(i);
                }else{
                    sum=sum-listaTirada.get(i);
                }
            }
        }
        return sum;
    }
    @WebMethod(operationName="CalculateRoll")
    public String escribirRoll(ArrayList<Integer> listaTirada){
        String txtTirada="";
        
        listaTirada=calcularRoll(listaTirada);
        
        for(int i=0;i<listaTirada.size();i++){
            if(listaTirada.get(i)==0){
                txtTirada=txtTirada+" - ";
            }else if(listaTirada.get(i)==-1){
                txtTirada=txtTirada+" + ";
            }else{
                txtTirada=txtTirada+" "+listaTirada.get(i)+" ";
            }
        }
        
        txtTirada=txtTirada+" ==>"+sumarTirada(listaTirada);
        
        return txtTirada;    
    }
     
    @WebMethod(operationName="d4")
    public int D4 (){
        return roll.nextInt(4)+1;
    }
    
    @WebMethod(operationName="d6")
    public int D6 (){
        return roll.nextInt(6)+1;
    }
    
     
    @WebMethod(operationName="d8")
    public int D8 (){
        return roll.nextInt(8)+1;
    }
     
    @WebMethod(operationName="d10")
    public int D10 (){
        return roll.nextInt(10)+1;
    }
     
    @WebMethod(operationName="d12")
    public int D12 (){
        return roll.nextInt(12)+1;
    }
     
    @WebMethod(operationName="d20")
    public int D20 (){
        return roll.nextInt(20)+1;
    }
    
    //los añadi al principio, no estoy seguro si usarlos
    @WebMethod(operationName="sum")
    public int Sum(int D1, int D2){
        return D1+D2;
    }
     //los añadi al principio, no estoy seguro si usarlos;
    @WebMethod(operationName="sub")
    public int Sub(int D1, int D2){
        return D1-D2;
    }
    
    @WebMethod(operationName="dropLow")
    public ArrayList<Integer> dropLow(ArrayList<Integer> tiradas,int cant){
        int dropped[]=new int[cant];
        boolean removed;
        for(int i=0;i<tiradas.size();){
            removed=false;
            for(int d=0;d<cant;d++){
                if(dropped[d]==0||
                        dropped[d]>tiradas.get(i)){
                    dropped[d]=tiradas.get(i);
                    tiradas.remove(i);
                    removed=true;
                    break;
                }
            }
            if (removed==false) i++;
        }
        return tiradas;
    }
    
    
    
    
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
}
