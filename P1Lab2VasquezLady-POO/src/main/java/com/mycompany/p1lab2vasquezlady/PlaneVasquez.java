package com.mycompany.p1lab2vasquezlady;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class PlaneVasquez extends VehicleVasquez {

    private String countriesVasquez;
    private Scanner scanner = new Scanner(System.in);

    //CONSTRUCTOR
    public PlaneVasquez(String countriesVasquez, String colorVasquez, int yearVasquez) {
        super(colorVasquez, yearVasquez);
        this.countriesVasquez = countriesVasquez;
    }

    //GETTER
    public String getCountriesVasquez() {
        return countriesVasquez;
    }

    //SETTER
    public void setCountriesVasquez(String countriesVasquez) {
        while (countriesVasquez.isEmpty()) {
            System.out.println("Erro no pueda ingresar vacio, ingrese nuevamente");
            countriesVasquez = scanner.nextLine();
        }
        this.countriesVasquez = countriesVasquez;
    }

    public void pedirDatosPlane() {
        System.out.println("Ingrese el año del avion");
        setYearVasquez(controlVasquez());
        System.out.println("Ingrese el color del avion");
        setColorVasquez(scanner.next());
        System.out.println("Ingrese el pais al que guste volar en el avion");
        setCountriesVasquez(scanner.next());
    }

    @Override
    public void saveJsonVasquez(String fileName) {

    }

    @Override
    public void saveCsvVasquez(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write("Año ,Color ,Pais \n");
            bw.write(getYearVasquez() + ", ");
            bw.write(getColorVasquez() + ", ");
            bw.write(getCountriesVasquez() + ", ");
        } catch (IOException e) {
            System.out.println("El archivo no fue guardado");
        }
    }

}
