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
import java.io.*;
public class Agrupadores {
    
  Pila miPila;
  Integer tamaño;
  
  /**Este metodo "leerArchivo()" lee un archivo que es la entrada de datos para nuestro algoritmo
   * ya que contiene las Cadenas que van a ser analizadas para saber si se encuentran balanceadas,llama al
   * metodo "balanceada()" que es el que se encarga de este proceso.
   * Variables:
   * file=es el archivo que leemos para la entrada de datos,se encuentra en la raiz del proyecto con los datos
   * entrada= variable que almacena cada linea Strings que lee el BufferedReader
   * tamaño=es la primer linea del archivo, lo convertimos a entero para poder definir el tamaño de nuestra pila
   */
    public void leerArchivo()throws FileNotFoundException,IOException{ 
        File file=new File("Archivo.txt");  
        FileReader archivo =new FileReader(file);
        BufferedReader input=new BufferedReader(archivo);
        String entrada="";
        tamaño=Integer.parseInt(input.readLine());
       
        while((entrada=input.readLine())!=null){
        this.balanceada(entrada);
        }
    }
    /**Este metodo "balanceada()" tiene como parametro una cadena de Strings la cual va ser analizada para saber si
     * se encuentra balanceada.
     * El algoritmo basicamente toma el primer caracter de la cadena parametro y hace una serie de comparaciones
     * para saber si es un agrupador que abre, si es asi lo inserta a nuestra pila.Si el caracter no es un agrupador que abre 
     * verifica si la pila se encuentra vacia, de ser asi finaiza ya que no se encuentra balanceada, de lo contrario toma el 
     * ultimo elemento de la pila y verifica si es el par de nuestro caracter, si es su par vuelve a repetir el proceso hacta que
     * la longitud de la cadena parametro sea igual a 0,utiliza una bandera boleana para saber cuando repetir el proceso.
     * Variables:
     * flag= bandera boleana que nos sirve para saber si repetir el algoritmo o concluirlo
     * caracter=es un sub string de la cadena parametro, contiene el primer caracter
     */
    public void balanceada(String cadena){
        boolean flag=true;
        String caracter;
        miPila=new Pila(tamaño*100);
        while(cadena.length()!=0&& flag){
           caracter=cadena.substring(0, 1);
             cadena=cadena.substring(1, cadena.length());
           
           if(caracter.equals("{")||caracter.equals("[")||caracter.equals("(")){ 
                 miPila.push(caracter);
           }else{
            if(miPila.isEmpty()){
                 flag=false;
           }else{
            String aux=miPila.pop();
               
            if(aux.equals("(")&& caracter.equals(")")){  
                  flag=true;
           }else{
            if(aux.equals("[")&& caracter.equals("]")){  
                  flag=true;
           }else{
            if(aux.equals("{")&& caracter.equals("}")){  
                  flag=true;
           }else{
                  flag=false;
             }
            }
           }
          }
         }
        }
        
        if(flag){
            System.out.println("SI");
        }else{
            System.out.println("NO");
        }
}
    
    
    
    public static void main(String[]args)throws FileNotFoundException,IOException{
      Agrupadores agru=new Agrupadores();
      agru.leerArchivo();
    }
}
