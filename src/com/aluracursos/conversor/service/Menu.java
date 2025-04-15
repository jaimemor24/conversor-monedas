package com.aluracursos.conversor.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static final String URL_BASE = "https://v6.exchangerate-api.com/v6/a7d5b7f2118cc2292ed16253/pair/";
    private ConsumoApi consumoAPI = new ConsumoApi();
    private Scanner teclado = new Scanner(System.in);


    public void muestraElMenu() {
        System.out.println("""
                *************************************************
                Bienvenido/a al conversor de monedas
                *************************************************
                """);
        System.out.println("Te presentamos el menu de opciones\n");

        var opcion = 0;
        while (opcion != 9) {
            var menu = """
                    1 - Convertir Dolar =>> Peso Mexicano 
                    2 - Convertir Peso Mexicano =>> Dolar
                    3 - Convertir Dolar =>> Euro
                    4 - Convertir Euro =>> Dolar
                    5 - Convertir Dolar =>> Real Brasileño
                    6 - Convertir Real Brasileño =>> Dolar
                    7 - Convertir Dolar =>> Peso Colombiano
                    8 - Convertir Peso Colombiano =>> Dolar
                    9 - Salir
                    """;
            System.out.println(menu);
            System.out.println("Elija el numero de la opcion deseada");
            try {
                opcion = teclado.nextInt();
                teclado.nextLine();
                switch (opcion) {
                    case 1:
                        convertirMoneda("USD", "MXN");

                        break;
                    case 2:
                        convertirMoneda("MXN", "USD");
                        break;
                    case 3:
                        convertirMoneda("USD", "EUR");
                        break;
                    case 4:
                        convertirMoneda("EUR", "USD");
                        break;
                    case 5:
                        convertirMoneda("USD", "BRL");
                        break;
                    case 6:
                        convertirMoneda("BRL", "USD");
                        break;
                    case 7:
                        convertirMoneda("USD", "COP");
                        break;
                    case 8:
                        convertirMoneda("COP", "USD");
                        break;
                    case 9:
                        System.out.println("Gracias por utilizar el conversor de monedas");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Numero no encontrado");
                break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicacion");
                break;
            }
        }
    }

    private void convertirMoneda(String monedaBase, String monedaCambio) {
        System.out.println("Ingrese el monto a convertir");
        var cantidad = teclado.nextDouble();
        var resultado = consumoAPI.obtenerDatos(URL_BASE + "/" + monedaBase + "/" + monedaCambio + "/" + cantidad);
        System.out.println("el valor de " + cantidad + "[" + monedaBase + "]" + " corresponde al valor final de =>>> " + resultado.conversion() + "[" + monedaCambio + "]");
        System.out.println("*************************************************************************\n");

    }
}