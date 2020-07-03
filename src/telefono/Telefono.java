/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telefono;

import Utiles.TecladoIn;

/**
 *
 * @author alumi
 */
public class Telefono {

    /**
     * Mostrará el menú reiteradas veces hasta que el usuario ingrese la opción
     * finalizar
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // do while condicion opcion == 10
        // validar que la opcion ingresada pertenezca al menu y sea numerica
        int opcion;
        String telefono;
        String error;
        String segundoTelefono;
        String errorOtro;
        String respuesta;
        do {
            mostrarMenu();
            System.out.println("Elija una opción");
            opcion = TecladoIn.readLineInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el número de teléfono a validar");
                    telefono = TecladoIn.readLine();
                    if (validarTelefono(telefono)) {
                        respuesta = "El número de teléfono es válido";
                    } else {
                        respuesta = "El número de teléfono no es válido";
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el número de teléfono a validar");
                    telefono = TecladoIn.readLine();
                    if (validarTelefono(telefono)) {
                        respuesta = "El número de teléfono es válido";
                    } else {
                        error = errorTelefono(telefono);
                        respuesta = "El número de teléfono no es válido: " + error;
                    }
                    break;
                case 3:
                    System.out.println("Ingrese un número de teléfono");
                    telefono = TecladoIn.readLine();
                    if (validarTelefono(telefono)) {
                        System.out.println("Ingrese otro número de teléfono");
                        segundoTelefono = TecladoIn.readLine();
                        if (validarTelefono(segundoTelefono)) {
                            if (!verificarEsMenor(telefono, segundoTelefono)) {
                                if (!verificarSonIguales(telefono, segundoTelefono)) {
                                    respuesta = "El primer teléfono es mayor al segundo";
                                } else {
                                    respuesta = "El primer teléfono es igual al segundo";
                                }
                            } else {
                                respuesta = "El primer teléfono es menor al segundo";
                            }
                        } else {
                            errorOtro = errorTelefono(segundoTelefono);
                            respuesta = "El segundo número de teléfono no es válido: " + errorOtro;
                        }
                    } else {
                        error = errorTelefono(telefono);
                        respuesta = "El primer número de teléfono no es válido: " + error;
                    }
                    System.out.println(respuesta);
                    break;
                case 4:
                    System.out.println("Ingrese un número de teléfono");
                    telefono = TecladoIn.readLine();
                    if (validarTelefono(telefono)) {
                        System.out.println("Ingrese otro número de teléfono");
                        segundoTelefono = TecladoIn.readLine();
                        if (validarTelefono(segundoTelefono)) {
                            if (verificarSonIguales(telefono, segundoTelefono)) {
                                respuesta = "El primer teléfono es igual al segundo";
                            } else {
                                if (verificarEsMenor(telefono, segundoTelefono)) {
                                    respuesta = "El primer teléfono es menor al segundo";
                                } else {
                                    respuesta = "El primer teléfono es mayor al segundo";
                                }
                            }
                        } else {
                            errorOtro = errorTelefono(segundoTelefono);
                            respuesta = "El segundo número de teléfono no es válido: " + errorOtro;
                        }
                    } else {
                        error = errorTelefono(telefono);
                        respuesta = "El primer número de teléfono no es válido: " + error;
                    }
                    System.out.println(respuesta);
                    break;
                case 5:
                    respuesta = mostrarMayor();
                    break;
                case 6:
                    respuesta = obtenerOcurrencias();
                    break;
                case 7:
                    System.out.println("Ingrese el número de teléfono a incrementar");
                    telefono = TecladoIn.readLine();
                    respuesta = incrementarTelefono(telefono);
                    break;
                case 8:
                    respuesta = mostrarMayor();
                    break;
                case 9:
                    respuesta = obtenerOcurrencias();
                    break;
                case 10:
                    respuesta = "Se ha finalizado el programa";
                    break;
                default:
                    respuesta = "La opción ingresada no corresponde a una opción válida, por favor intentelo nuevamente";
                    break;
            }
            System.out.println(respuesta);
        } while (opcion != 10);
    }

    /**
     * Modulo 10 Muestra las opciones de un Menú
     */
    public static void mostrarMenu() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("MENÚ");
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("1-Veriﬁcar si un número de teléfono es válido");
        System.out.println("2-Determinar porque un número de teléfono no es válido");
        System.out.println("3-Veriﬁcar si un número de teléfono es mayor que otro ");
        System.out.println("4-Veriﬁcar si un número de teléfono es igual a otro");
        System.out.println("5-Ingresar una secuencia de números de teléfonos y obtener aquel número más grande");
        System.out.println("6-Ingresar una secuencia de números de teléfonos y un número de teléfono determinado A, y hallar cantidad de ocurrencias de A.");
        System.out.println("7-Incrementar un número de teléfono en una unidad ");
        System.out.println("8-Dada una secuencia de números de teléfonos (recibido por parámetro en un String) obtener aquel número más grande");
        System.out.println("9-Dada una secuencia de números de teléfonos (recibido por parámetro en un String) y un número de teléfono determinado A, hallar cantidad de ocurrencias de A en la secuencia");
        System.out.println("10-Terminar ");
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
    }

    /**
     * Modulo 1 Verifica si un telefono tiene una estructura válida Estructura
     * válida: CCCC-NNNNNNNNN
     * 
     * @param telefono
     * @return boolean
     */
    public static boolean validarTelefono(String telefono) {
        boolean valido = false;
        String caracteristica, numero;
        if(telefono.length() == 14){
            if(telefono.charAt(4)== '-'){
                caracteristica = cortarCaracteristica(telefono);
                numero = cortarTelefono(telefono);
                if (isNumeric(caracteristica) && isNumeric(numero)){
                    valido = true;
                }
            }
        }
        return valido;
    }

    /**
     * Modulo 2 Determina por qué un telefono no es válido
     * 
     * @param telefono
     */
    public static String errorTelefono(String telefono) {
        String caracteristica, numero;
        String error = "";
        if(telefono.length() == 14){
            if(telefono.charAt(4)== '-'){
                caracteristica = cortarCaracteristica(telefono);
                numero = cortarTelefono(telefono);
                if (!isNumeric(caracteristica)){
                    error += "La caracteristica ingresada no es un número \n";
                }
                if(!isNumeric(numero)){
                    error += "El teléfono ingresado no es un número \n";
                }
            } else {
                error += "El formato es incorrecto \n";
            }
        } else {
            error += "La cantidad de digitos es incorrecta \n";
        }
        return error;
    }

    /**
     * Modulo 3 Verifica si el primer número sin considerar la característica es
     * menor que el segundo número
     * 
     * @param telefonoUno
     * @param telefonoDos
     * @return boolean
     */
    public static boolean verificarEsMenor(String telefonoUno, String telefonoDos) {
        boolean esMenor = true;
        return esMenor;
    }

    /**
     * Modulo 4 Verifica si ambos números son iguales
     * 
     * @param telefonoUno
     * @param telefonoDos
     * @return boolean
     */
    public static boolean verificarSonIguales(String telefonoUno, String telefonoDos) {
        boolean sonIguales = true;
        return sonIguales;
    }

    /**
     * Modulo 7 Se incrementa el número telefónico en 1 unidad
     * 
     * @param telefono
     */
    public static String incrementarTelefono(String telefono) {
        // System.out.println del telefonoIncrementado
        String telefonoIncrementado = "telefono incrementado";
        return telefonoIncrementado;
    }

    /**
     * Modulo 5 Solicita al usuario una secuencia de números de teléfono mientras
     * este lo desee y finalmente muestra el mayor
     */
    public static String mostrarMayor() {
        // do while condicion seguir == no
        // validar que la opcion ingresada pertenezca a un numero valido
        // invocacion a validarTelefono() == false -> errorTelefono()
        // verificarEsMenor() || verificarSonIguales()
        String mayor = "mayor";
        return mayor;
    }

    /**
     * Modulo 6 Solicita al usuario un teléfono y luego solicita otros hasta que el
     * usuario desee Finalmente indica si el primer teléfono ingresado está
     * duplicado y de ser así, cuantas veces
     */
    public static String obtenerOcurrencias() {
        // pide telefono e inicia do while condicion seguir == no
        String resultadoOcurrencias = "hay ocurrencias";
        return resultadoOcurrencias;
    }

    public static String mostrarMenor() {
        String menor = "el menor";
        return menor;
    }

    /**
     * Modulo adicional
     * 
     * @return String
     */
    public static String cortarTelefono(String telefono) {
        String numTelefono;
        numTelefono = telefono.substring(5,13);
        return numTelefono;
    }

    /**
     * Modulo adicional
     * 
     * @return String
     */
    public static String cortarCaracteristica(String telefono) {
        String caracteristica;
        caracteristica = telefono.substring(0,3);
        return caracteristica;
    }


    public static boolean isNumeric(String cadena){
        boolean isNumeric;
        try {
            Integer.parseInt(cadena);
            isNumeric = true;
        } catch (NumberFormatException nfe){
            isNumeric = false;
        }
        return isNumeric;
    }
}
