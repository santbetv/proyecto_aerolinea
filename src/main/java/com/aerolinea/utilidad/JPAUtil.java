/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.utilidad;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase que permite la inyeccion de dependecias, que generando union a los ORM y sus tablas
 * Ayuda a interactuar con la unidad de persistencia.
 * @author Santiago Betancur V
 */
public class JPAUtil {

    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    //nos desconecta de la base de datos 
    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }

}
