/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.utilidad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Santiago Betancur V
 */
public class Constantes {

    public static String RUTA_RECURSOS = "http://testapi.vivaair.com/otatest/api/values";

    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("/src/main/resources/sistema.properties")));
            RUTA_RECURSOS = properties.get("RUTA_RECURSOS").toString();
            System.out.println(properties.get("RUTA_RECURSOS"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
