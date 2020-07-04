/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telefono;

import Utiles.TecladoIn;

/**
 *
 * @author de Rosa, Maria Aluminé y Montes, Diego Nicolás
 */
public class Telefono {

    /**
     * Mostrará el menú reiteradas veces hasta que el usuario ingrese la opción
     * finalizar y por cada una de las opciones ingresadas devuelve una respuesta acorde
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion;
        String telefono, error, segundoTelefono, respuesta, cadenaNumeros;
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
                            error = errorTelefono(segundoTelefono);
                            respuesta = "El segundo número de teléfono no es válido: " + error;
                        }
                    } else {
                        error = errorTelefono(telefono);
                        respuesta = "El primer número de teléfono no es válido: " + error;
                    }
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
                            error = errorTelefono(segundoTelefono);
                            respuesta = "El segundo número de teléfono no es válido: " + error;
                        }
                    } else {
                        error = errorTelefono(telefono);
                        respuesta = "El primer número de teléfono no es válido: " + error;
                    }
                    break;
                case 5:
                    respuesta = devolverMayor();
                    break;
                case 6:
                    System.out.println("Ingrese un número de teléfono");
                    telefono = TecladoIn.readLine();
                    if (validarTelefono(telefono)) {
                        respuesta = obtenerOcurrencias(telefono);
                    } else {
                        respuesta = "El número ingresado no es válido. Por favor intente nuevamente.";
                    }
                    break;
                case 7:
                    System.out.println("Ingrese el número de teléfono a incrementar");
                    telefono = TecladoIn.readLine();
                    if (validarTelefono(telefono)) {
                        respuesta = "El número de teléfono incrementado es: " + incrementarTelefono(telefono);
                    } else {
                        respuesta = "El número ingresado no es válido. Por favor intente nuevamente.";
                    }
                    break;
                case 8:
                    System.out.println("Ingrese una cadena de números");
                    cadenaNumeros = TecladoIn.readLine();
                    if (validarCadena(cadenaNumeros)){
                        respuesta = "El número menor es: " + devolverMenor(cadenaNumeros);
                    } else {
                        respuesta = "La cadena ingresada no es válida. Por favor intente nuevamente.";
                    }
                    break;
                case 9:
                    System.out.println("Ingrese un número de teléfono");
                    telefono = TecladoIn.readLine();
                    if (validarTelefono(telefono)) {
                        System.out.println("Ingrese una cadena de números");
                        cadenaNumeros = TecladoIn.readLine();
                        if (validarCadena(cadenaNumeros)){
                            respuesta = obtenerOcurrenciasCadena(telefono, cadenaNumeros);
                        } else {
                            respuesta = "La cadena ingresada no es válida. Por favor intente nuevamente.";
                        }
                    } else {
                        respuesta = "El número ingresado no es válido. Por favor intente nuevamente.";
                    }
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
     * Modulo 10. 
     * Muestra las opciones de un Menú.
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
        System.out.println("7-Incrementar un número de teléfono en una unidad");
        System.out.println("8-Dada una secuencia de números de teléfonos (recibido por parámetro en un String) obtener aquel número más grande");
        System.out.println("9-Dada una secuencia de números de teléfonos (recibido por parámetro en un String) y un número de teléfono determinado A, hallar cantidad de ocurrencias de A en la secuencia");
        System.out.println("10-Terminar ");
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
    }

    /**
     * Modulo 1.
     * Verifica si un telefono tiene una estructura válida.
     * Estructura válida: CCCC-NNNNNNNNN.
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
     * Modulo 2.
     * Determina por qué un teléfono no es válido.
     * @param telefono
     * @return String
     */
    public static String errorTelefono(String telefono) {
        String caracteristica, numero;
        String error = "";
        if(telefono.length() == 14){
            if(telefono.charAt(4)== '-'){
                caracteristica = cortarCaracteristica(telefono);
                numero = cortarTelefono(telefono);
                if (!isNumeric(caracteristica)){
                    error += "La característica ingresada no es un número \n";
                }
                if(!isNumeric(numero)){
                    error += "El teléfono ingresado no es un número \n";
                }
            } else {
                error += "El formato es incorrecto \n";
            }
        } else {
            error += "La cantidad de dígitos es incorrecta \n";
        }
        return error;
    }

    /**
     * Modulo 3.
     * Verifica si el primer número(sin considerar la característica), es
     * menor que el segundo.
     * @param telefonoUno
     * @param telefonoDos
     * @return boolean
     */
    public static boolean verificarEsMenor(String telefonoUno, String telefonoDos) {
        boolean esMenor = false;
        telefonoUno = cortarTelefono(telefonoUno);
        telefonoDos = cortarTelefono(telefonoDos);
        if (Integer.parseInt(telefonoUno)<Integer.parseInt(telefonoDos)){
            esMenor = true;
        }
        return esMenor;
    }

    /**
     * Modulo 4.
     * Verifica si ambos números son iguales.
     * @param telefonoUno
     * @param telefonoDos
     * @return boolean
     */
    public static boolean verificarSonIguales(String telefonoUno, String telefonoDos) {
        boolean sonIguales = false;
        if (telefonoUno.equals(telefonoDos)){
            sonIguales = true;
        }
        return sonIguales;
    }

    /**
     * Modulo 5.
     * Solicita al usuario una secuencia de números de teléfono mientras
     * este lo desee. Finalmente devuelve el mayor.
     * @return String
     */
    public static String devolverMayor() {
        boolean continuar;
        String telefonoMayor = "No ha ingresado ningún teléfono válido";
        String telefono;
        int numero;
        int numeroMayor = 0;
        do {
            System.out.println("Ingrese un número de teléfono");
            telefono = TecladoIn.readLine();
            if (validarTelefono(telefono)) {
                numero = Integer.parseInt(cortarTelefono(telefono));
                if (numero>numeroMayor){
                    numeroMayor = numero;
                    telefonoMayor = "El número mayor es: " + telefono;
                }
            } else {
                System.out.println("El número de teléfono no es válido.");
            }
            System.out.println("Desea continuar (true:si|false:no)?");
            continuar = TecladoIn.readLineBoolean();        
        } while (continuar);
        return telefonoMayor;
    }

    /**
     * Modulo 6.
     * Recibe por parámetro un teléfono. Luego solicita otros hasta que el
     * usuario desee. Finalmente indica si el teléfono recibido por parámetro está
     * duplicado. De ser así, también indica cuántas veces.
     * @param telefono
     * @return String
     */
    public static String obtenerOcurrencias(String telefono) {
        boolean continuar;
        String resultadoOcurrencias, telefonoNuevo;
        int cantidadOcurrencias = 0;
        do {
            System.out.println("Ingrese un nuevo número de teléfono");
            telefonoNuevo = TecladoIn.readLine();
            if (validarTelefono(telefonoNuevo)) {
                if (verificarSonIguales(telefono,telefonoNuevo)){
                    cantidadOcurrencias++;
                };
            } else {
                System.out.println("El número de teléfono no es válido.");
            }
            System.out.println("Desea continuar (true:si|false:no)?");
            continuar = TecladoIn.readLineBoolean();        
        } while (continuar);
        resultadoOcurrencias = obtenerTextoOcurrencias(cantidadOcurrencias);
        return resultadoOcurrencias;
    }

    /**
     * Modulo 7.
     * Se incrementa el número telefónico en 1 unidad.
     * @param telefono
     * @return String
     */
    public static String incrementarTelefono(String telefono) {
        String telefonoIncrementado;
        int numero = Integer.parseInt(cortarTelefono(telefono));
        // Si el número es 999999999, no se puede incrementar uno más, por lo que se transforma en 000000000
        // Utilizamos dos métodos diferentes con el propósito de mostrar las diferentes maneras de hacerlo.
        if (numero==999999999){
            telefonoIncrementado = telefono.replace(Integer.toString(numero),new String ("000000000")); 
        } else {
            numero = numero + 1;
            telefonoIncrementado = cortarCaracteristica(telefono) + "-" + numero;
        }
        return telefonoIncrementado;
    }

    /**
     * 
     * Modulo 8.
     * Recibe por parámetro una cadena de telefonos contenidos en un string. 
     * Retorna cuál de ellos es el menor.
     * @param cadena
     * @return String
     */
    public static String devolverMenor(String cadena) {
        String telefonoMenor="0299-999999999";
        int cantTelefonos = cadena.length()/14;
        int posicionInicial = 0;
        int posicionFinal = 14;
        String telefono;
        int i = 0;
        // Obtenemos la cantidad de telefonos que existen, y luego, a través de substring, 
        // obtenemos cada uno de ellos.
        while (i<cantTelefonos){
            telefono = cadena.substring(posicionInicial,posicionFinal);
            if (verificarEsMenor(telefono,telefonoMenor)){
                telefonoMenor = telefono;
            }
            posicionInicial+=14;
            posicionFinal+=14;
            i++;
        }
        return telefonoMenor;
    }

    /**
     * Modulo 9.
     * Dado un número de telefono determinado "A", y una secuencia de teléfonos 
     * recibidos por parámetro en un solo string, devueve la 
     * cantidad de ocurrencias de A en la secuencia.
     * @param telefono
     * @param cadenaNumeros
     * @return String
     */
    public static String obtenerOcurrenciasCadena(String telefono, String cadenaNumeros) {        
        String resultadoOcurrencias, telefonoNuevo;
        int cantidadOcurrencias = 0;
        int cantTelefonos = cadenaNumeros.length()/14;
        int posicionInicial = 0;
        int posicionFinal = 14;
        int i = 0;
        while (i<cantTelefonos){
            telefonoNuevo = cadenaNumeros.substring(posicionInicial,posicionFinal);
            if (verificarSonIguales(telefono,telefonoNuevo)){
                cantidadOcurrencias++;
            }
            posicionInicial+=14;
            posicionFinal+=14;
            i++;
        }
        resultadoOcurrencias = obtenerTextoOcurrencias(cantidadOcurrencias);
        return resultadoOcurrencias;
    }

    /**
     * Módulo adicional.
     * Este módulo retorna solo el número del teléfono, sin tener en cuenta su característica.
     * Ejemplo: Si recibe "0299-154567890", devuelve "154567890".
     * @param telefono
     * @return String
     */
    public static String cortarTelefono(String telefono) {
        String numTelefono;
        numTelefono = telefono.substring(5,14);
        return numTelefono;
    }

    /**
     * Módulo adicional.
     * Este módulo retorna solo la característica del teléfono, sin tener en cuenta el resto del número.
     * Ejemplo: Si recibe "0299-154567890", devuelve "0299".
     * @param telefono
     * @return String
     */
    public static String cortarCaracteristica(String telefono) {
        String caracteristica;
        caracteristica = telefono.substring(0,4);
        return caracteristica;
    }

    /**
     * Módulo adicional.
     * Este módulo valida que la cadena de teléfonos ingresados por el usuario sea válida.
     * @param cadena
     * @return boolean
     */

    public static boolean validarCadena(String cadena){
        boolean valido = true;
        int cantTelefonos; 
        int i = 0;
        int posicionInicial = 0;
        int posicionFinal = 14;
        String telefono;
        if ((cadena.length() % 14) == 0){
            cantTelefonos = cadena.length()/14;
            while (i<cantTelefonos && valido){
                telefono = cadena.substring(posicionInicial,posicionFinal);
                if (!validarTelefono(telefono)){
                    valido=false;
                }
                posicionInicial+=14;
                posicionFinal+=14;
                i++;
            }
        } else {
            valido=false;
        }
        return valido;
    }

    /**
     * Módulo adicional.
     * Convierte las ocurrencias, según la cantidad que existan, a texto.
     * @param cantidadOcurrencias
     * @return String
     */

    public static String obtenerTextoOcurrencias (int cantidadOcurrencias){
        String textoOcurrencias;
        switch (cantidadOcurrencias){
            case 0:
            textoOcurrencias = "No hay ocurrencias";
                break;
            case 1:
            textoOcurrencias = "Existe una ocurrencia";
                break;
            default:
            textoOcurrencias = "Existen " + cantidadOcurrencias + " ocurrencias";
        }
        return textoOcurrencias;
    }

    /**
     * Módulo adicional.
     * Módulo que valida que el parametro recibido sea de tipo numérico.
     * Utilizamos un try/catch, debido a que lo hemos utilizado en otros proyectos.
     * Este nos permite intentar convertir el String a int y si no lo logra arroja una excepción,
     * permitiendonos darnos cuenta de que dicho String no contiene números. 
     * @param cadena
     * @return boolean
     */
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
