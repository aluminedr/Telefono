/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telefono;

/**
 *
 * @author alumi
 */
public class Telefono {

    /**
     * Mostrará el menú reiteradas veces hasta que el usuario 
     * ingrese la opción finalizar
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // do while condicion opcion == 10 
        // validar que la opcion ingresada pertenezca al menu y sea numerica
        //invocacion a mostrarMenu()
    }
    
    /**
     * Modulo 10
     * Muestra las opciones de un Menú
     * @param opcion 
     */
    public static void mostrarMenu(int opcion) {
        
    }
    
    /**
     * Modulo 1
     * Verifica si un telefono tiene una estructura válida
     * Estructura válida: CCCC-NNNNNNNNN
     * @param telefono
     * @return boolean
     */
    public static boolean validarTelefono(String telefono) {
        boolean valido = true;
        return valido;
    }
    
    /**
     * Modulo 2
     * Determina por qué un telefono no es válido
     * @param telefono 
     */
    public static void errorTelefono(String telefono) {
        //System.out.println del error
        String error;   
    } 
    
    /**
     * Modulo 3
     * Verifica si el primer número sin considerar
     * la característica es menor que el segundo número
     * @param telefonoUno
     * @param telefonoDos
     * @return boolean
     */
    public static boolean verificarEsMenor(String telefonoUno, String telefonoDos) {
        boolean esMenor = true;
        return esMenor;
    }
    
    /**
     * Modulo 4
     * Verifica si ambos números son iguales
     * @param telefonoUno
     * @param telefonoDos
     * @return boolean
     */
    public static boolean verificarSonIguales(String telefonoUno, String telefonoDos) {
        boolean sonIguales = true;
        return sonIguales;
    }
    
    /**
     * Modulo 7 
     * Se incrementa el número telefónico en 1 unidad
     * @param telefono 
     */
    public static void incrementarTelefono (String telefono){
        //System.out.println del telefonoIncrementado
        String telefonoIncrementado; 
    }
    
    /**
     * Modulo 5
     * Solicita al usuario una secuencia de números de teléfono
     * mientras este lo desee y finalmente muestra el mayor
     */
    public static void mostrarMayor() {
        // do while condicion seguir == no 
        // validar que la opcion ingresada pertenezca a un numero valido
        // invocacion a validarTelefono() == false -> errorTelefono()
        // verificarEsMenor() || verificarSonIguales()
    }
    
    /**
     * Modulo 6
     * Solicita al usuario un teléfono y luego solicita otros hasta que 
     * el usuario desee
     * Finalmente indica si el primer teléfono ingresado está duplicado
     * y de ser así, cuantas veces
     */
    public static void obtenerOcurrencias() {
        // pide telefono e inicia do while condicion seguir == no 
    }
    
    public static void mostrarMenor() {
        
    }
    
    /**
     * Modulo adicional
     * @return int
     */
    public static int cortarTelefono() {
        int telefono;
        telefono = 132367;
        return telefono;
    }
    
    /**
     * Modulo adicional
     * @return int
     */
    public static int cortarCaracteristica() {
        int caracteristica;
        caracteristica = 132367;
        return caracteristica;
    }
}
