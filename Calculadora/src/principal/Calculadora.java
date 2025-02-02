package principal;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import apuntes.FormatoHTML;
import menu.Menu;
import operaciones.Operaciones;

public class Calculadora{
	
	
	private static final Logger LOGGER = Logger.getLogger("Logger Calculadora");
	
	
	
	/**
	 * 
	 * @param args
	 */
	
    public static void main(String[] args) {
    	
    	LOGGER.setLevel(Level.ALL); 
    	LOGGER.setUseParentHandlers(false);
    	
    	Handler consoleHandler = new ConsoleHandler();
    	Handler fileHandler = null;
    	
    	try {
			fileHandler = new FileHandler("src/principal/Logs.html");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	LOGGER.addHandler(consoleHandler);
    	LOGGER.addHandler(fileHandler);
    	consoleHandler.setLevel(Level.WARNING);
    	fileHandler.setLevel(Level.ALL);
    	fileHandler.setFormatter(new FormatoHTML());
    	
    	
        int resultado = 0;
        String operacion = "";
        int[] operandos = new int [2];
        
        Menu menu = new Menu();
        Operaciones operaciones = new Operaciones();
        
        do{
            operandos = menu.pedirNumeros();
            operacion = menu.menuOpciones();
            
            
            if (operacion.equalsIgnoreCase("+")){
                resultado = operaciones.sumar(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
                LOGGER.log(Level.FINE, "+," + operandos[0] + "," + operandos[1] + "," + resultado);
                
            } else if (operacion.equalsIgnoreCase("-")){
                resultado = operaciones.restar(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
                LOGGER.log(Level.FINE,"-," + operandos[0] + "," + operandos[1] + "," + resultado);
                
            } else if (operacion.equalsIgnoreCase("*")){
                resultado = operaciones.multiplicar(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
                LOGGER.log(Level.FINE,"*," + operandos[0] + "," + operandos[1] + "," + resultado);
                
            } else if (operacion.equalsIgnoreCase("/")){
            	 try {
                     resultado = operaciones.dividir(operandos[0], operandos[1]);
                     System.out.println("Resultado: " + resultado);
                     LOGGER.log(Level.FINE, "/," + operandos[0] + "," + operandos[1] + "," + resultado);
                 } catch (ArithmeticException e) {
                     resultado = 0;
                     LOGGER.log(Level.WARNING, "/," + operandos[0] + "," + operandos[1] + "," + resultado);
                 }
                
                
            } else if (operacion.equalsIgnoreCase("%")){
                resultado = operaciones.resto(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
                LOGGER.log(Level.FINE,"%," + operandos[0] + "," + operandos[1] + "," + resultado);
                
            } else {
                System.out.println ("Operaci�n no v�lida");
                LOGGER.log(Level.WARNING,"Operacion no válida");
                
            }
            
           
            
        }   while (menu.repetir());
    }
}