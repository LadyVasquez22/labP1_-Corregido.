package com.mycompany.p1lab2vasquezlady;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class CarsVasquez extends VehicleVasquez {

    private String plateVasquez;            //ATRIBUTO PROPIO

    private Scanner scanner = new Scanner(System.in);
    private JSONObject objectFisico = null;

    //CONSTRUCTOR
    public CarsVasquez(String plateVasquez, String colorVasquez, int yearVasquez) {
        super(colorVasquez, yearVasquez);       //ATRIBUTOS HEREDADOS
        this.plateVasquez = plateVasquez;  //ATRIBUTO PROPIO
    }

    //GETTER
    public String getPlateVasquez() {
        return plateVasquez;
    }

    //SETTER
    public void setPlateVasquez(String plateVasquez) {
        while (plateVasquez.isEmpty()) {
            System.out.println("Erro no pueda ingresar vacio, ingrese nuevamente");
            plateVasquez = scanner.nextLine();
        }
        this.plateVasquez = plateVasquez;
    }

    //METODO PARA PEDIR DATOS
    public void pedirDatosCars() {
        System.out.println("Ingrese el color de su vehiculo");
        setColorVasquez(scanner.next());                //SE ALMACENAN EN EL
        System.out.println("Ingrese la placa de su carro");
        setPlateVasquez(scanner.next());
        System.out.println("Ingrese el año de su vehiculo");
        setYearVasquez(controlVasquez());
    }

    //METODO PARA GUARDAR EN JSON
    @Override
    public void saveJsonVasquez(String fileName) {
        JSONObject libroJson = new JSONObject();
        libroJson.put("Color ", getColorVasquez());
        libroJson.put("Placa ", getPlateVasquez());
        libroJson.put("Año  ", getYearVasquez());

        JSONArray librosArray = new JSONArray();
        try (FileReader reader = new FileReader(fileName)) {
            librosArray = (JSONArray) new JSONParser().parse(reader);

        } catch (IOException e) {
            System.out.println("El archivo no fue encontrado, se creara uno nuevo");
        } catch (Exception e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
        }
        librosArray.add(libroJson);

        try (FileWriter file = new FileWriter(fileName)) {
            file.write(librosArray.toJSONString());
            file.flush();
            System.out.println("Carros guardados en Json ");
        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo JSON: " + e.getMessage());
        }
    }

    //METODO PARA GUARDAR EN CSV, PERO EN ESTA LIBRERIA NO SE LO UTILIZA
    //PERO SI SE COLOCA PORQUE ES HEREDADO, POR ENDE EL @Override
    @Override
    public void saveCsvVasquez(String fileName) {

    }

}
