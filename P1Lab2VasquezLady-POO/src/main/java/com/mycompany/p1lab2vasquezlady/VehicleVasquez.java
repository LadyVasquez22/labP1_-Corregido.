package com.mycompany.p1lab2vasquezlady;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public abstract class VehicleVasquez {

    private String colorVasquez;
    private int yearVasquez;
    Scanner scanner = new Scanner(System.in);

    //CONSTRUCTOR
    public VehicleVasquez(String colorVasquez, int yearVasquez) {
        this.colorVasquez = colorVasquez;
        this.yearVasquez = yearVasquez;
    }

    //METODOS ABSTRACTOS
    public abstract void saveJsonVasquez(String fileName);

    public abstract void saveCsvVasquez(String fileName);

    //GETTER
    public String getColorVasquez() {
        return colorVasquez;
    }

    //SETTER
    public void setColorVasquez(String colorVasquez) {
        while (colorVasquez.isEmpty()) {
            System.out.println("Erro no pueda ingresar vacio, ingrese nuevamente");
            colorVasquez = scanner.nextLine();
        }
        this.colorVasquez = colorVasquez;
    }

    //GETTER
    public int getYearVasquez() {
        return yearVasquez;
    }

    //SETTER Y PEDIDO DE NOTAS
    public void setYearVasquez(int yearVasquez) {
        while (yearVasquez < 1900 || yearVasquez > 2024) {
            System.out.println("Rango incorrecto, ingrese bneuvamente");
            yearVasquez = scanner.nextInt();
        }
        this.yearVasquez = yearVasquez;
    }

    public int controlVasquez() {
        Scanner sc_anio = new Scanner(System.in);
        int anio = 0;
        boolean validInput = true; // Bandera para controlar la validez de la entrada
        do {
            try {
                anio = sc_anio.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Error, solo se permite el ingreso de números");
                sc_anio.nextLine();
                validInput = false;
            }
        } while (!validInput);
        return anio;
    }

    //METODO LEER
    public void readVasquez(String fileName) {
        System.out.println("Ingrese el nombre del archivo que desea leer");
        fileName = scanner.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

}
