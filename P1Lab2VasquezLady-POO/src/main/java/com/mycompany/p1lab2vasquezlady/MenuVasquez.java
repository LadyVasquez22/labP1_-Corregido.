package com.mycompany.p1lab2vasquezlady;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuVasquez {

    private int opMenuVasquez;
    private Scanner scanner = new Scanner(System.in);
    CarsVasquez cars = new CarsVasquez("", "", 0);
    PlaneVasquez plane = new PlaneVasquez("", "", 0);
    VehicleVasquez vehicle = new CarsVasquez("", "", 0);
    //ARRAYLIST CARROS
    private ArrayList<CarsVasquez> listCarsVasquez = new ArrayList<>();
    private int cantCarsVasquez;
    //ARRAYLIST AVION
    private ArrayList<PlaneVasquez> listPlaneVasquez = new ArrayList<>();
    private int cantPlaneVasquez = 0;

    //GETTER
    public int getCantCarsVasquez() {
        return cantCarsVasquez;
    }

    //SETTER
    public void setCantCarsVasquez(int cantCarsVasquez) {
        this.cantCarsVasquez = cantCarsVasquez;
    }

    //GETTER
    public int getCantPlaneVasquez() {
        return cantPlaneVasquez;
    }

    //SETTER
    public void setCantPlaneVasquez(int cantPlaneVasquez) {
        this.cantPlaneVasquez = cantPlaneVasquez;
    }

    public void menuuVasquez() {                      //MENU
        do {

            System.out.println("Bienvenido, elija una opcion");
            System.out.println("1. Guardar carro en Json y leer lista");
            System.out.println("2. Guardar avion en Csv");
            System.out.println("3. Leer el archivo");
            System.out.println("4. Salir");
            opMenuVasquez = scanner.nextInt();
            switch (opMenuVasquez) {
                case 1:
                    saveCarsVasquez("json_carro.json");
                    readCarsVasquez();
                    break;
                case 2:
                    savePlaneVasquez("csv_plane.csv");
                    readPlaneVasquez();
                    break;
                case 3:
                    vehicle.readVasquez("");
                    break;
                case 4:
                    System.out.println("Gracias por usar este programa");
                    break;
                default:
                    System.out.println("Opcion incorrecta ingrese nuevamente");
                    break;
            }

        } while (opMenuVasquez != 4);
    }
    //METODO PARA GUARDAR CARROS, LLAMA AL METODO DE PEDIR DATOS Y GUARDAR

    public void saveCarsVasquez(String fileName) {
        do {
            System.out.println("Ingrese la cant. carros (1-3):");
            setCantCarsVasquez(scanner.nextInt());
        } while (cantCarsVasquez < 1 || cantCarsVasquez > 3);

        for (int i = 0; i < getCantCarsVasquez(); i++) {
            cars = new CarsVasquez("", "", 0);        //inicialización de la clase
            cars.pedirDatosCars();                               //se llama al metodo pedirDatos de la clase
            cars.saveJsonVasquez("json_carro.json");         //se llama al metodo guardarCsv de la clase
            listCarsVasquez.add(cars);
        }
    }
    //LLAMA AL METODO DE LEER CARROS

    public void readCarsVasquez() {                          //metodo para leer los libros
        System.out.println("----------------------");
        for (CarsVasquez car : listCarsVasquez) {
            System.out.println("Color: " + car.getColorVasquez());
            System.out.println("Placa: " + car.getPlateVasquez());
            System.out.println("Año: " + car.getYearVasquez());
            System.out.println("----------------------");
        }
    }

    //METODO PARA GUARDAR AVION, LLAMA AL METODO DE PEDIR DATOS Y GUARDAR
    public void savePlaneVasquez(String fileName) {
        do {
            System.out.println("Ingrese la cant. aviones (1-3):");
            setCantPlaneVasquez(scanner.nextInt());
        } while (cantPlaneVasquez < 1 || cantPlaneVasquez > 3);

        for (int i = 0; i < getCantPlaneVasquez(); i++) {
            plane = new PlaneVasquez("", "", 0);        //inicialización de la clase
            plane.pedirDatosPlane();                               //se llama al metodo pedirDatos de la clase
            plane.saveCsvVasquez("csv_plane.csv");         //se llama al metodo guardarCsv de la clase
            listPlaneVasquez.add(plane);
        }
    }

    //LLAMA AL METODO DE LEER AVION
    public void readPlaneVasquez() {                          //metodo para leer los libros
        System.out.println("----------------------");
        for (PlaneVasquez planeLeerVasquez : listPlaneVasquez) {
            System.out.println("Color: " + planeLeerVasquez.getColorVasquez());
            System.out.println("Pais: " + planeLeerVasquez.getCountriesVasquez());
            System.out.println("Año: " + planeLeerVasquez.getYearVasquez());
            System.out.println("----------------------");
        }
    }

}
