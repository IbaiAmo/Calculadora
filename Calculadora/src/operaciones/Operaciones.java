package operaciones;
public class Operaciones{
	
	/**
	 * 
	 * @param valor1
	 * @param valor2
	 * @return
	 */
    public int sumar (int valor1, int valor2){
        int numero;
        numero = valor1 + valor2;
        return numero;
    }
    
    /**
     * 
     * @param valor1
     * @param valor2
     * @return
     */
    public int restar (int valor1, int valor2){
        int numero;
        numero = valor1 - valor2;
        return numero;
    }
    
    /**
     * 
     * @param valor1
     * @param valor2
     * @return
     */
    public int multiplicar (int valor1, int valor2){
        int numero;
        numero = valor1 * valor2;
        return numero;
    }
    
    /**
     * 
     * @param valor1
     * @param valor2
     * @return
     */
    public int dividir (int valor1, int valor2){
        int numero;
        numero = valor1 / valor2;
        return numero;
    }
    
    /**
     * 
     * @param valor1
     * @param valor2
     * @return
     */
    public int resto (int valor1, int valor2){
        int numero;
        numero = valor1 % valor2;
        return numero;
    }
}