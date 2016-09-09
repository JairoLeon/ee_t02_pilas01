/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

/**
 *
 * @author Jairo
 */
public class Pila{
   private String [] pila;
   private Integer tamaño,tope;
  
public Pila(Integer tamaño){
   pila=new String[tamaño];
   tope=-1;
   this.tamaño=tamaño;

}   

public void push(String dato){
   if(tope<tamaño-1){
     tope=tope+1;
     pila[tope]=dato;
   }else{
       System.out.println("Pila Llena");
           
   }
}

public String pop(){
   String resultado=null;
   if(tope>-1){
   resultado=pila[tope];
   tope=tope-1;
   }else{
       System.out.println("Pila Vacia");
   } 
   return resultado;
   
}

public String peek(){
   String resultado=null;
   if(tope>-1){
   resultado=pila[tope];
   }else{
       System.out.println("Pila vacia");
   }
   return resultado;

}

public boolean isEmpty(){
    boolean flag=false;
    if(tope==-1)
     flag=true;
    else
       flag=false;
    
    return flag;
    

}

}
