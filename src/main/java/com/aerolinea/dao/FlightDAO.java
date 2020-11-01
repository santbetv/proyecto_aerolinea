/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.dao;

import com.aerolinea.modelo.Flight;
import com.aerolinea.utilidad.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Clase DAO que permite generar interacción con BD Mysql, con conexion jpb y hibernate 
 * @author Santiago Betancur V
 */
public class FlightDAO implements IGestionarDao<Flight>{

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    // guardar vuelo
    public void guardar(Flight vuelo) {
        entity.getTransaction().begin();
        entity.persist(vuelo);
        entity.getTransaction().commit();
        JPAUtil.shutdown();
    }

    // obtener todos los vuelos desde la BD
    public List<Flight> obtenerClientes() {
        List<Flight> listaClientes = new ArrayList<>();
        Query q = entity.createQuery("SELECT f FROM Flight f");
        listaClientes = q.getResultList();
//        JPAUtil.shutdown();
        return listaClientes;
    }

}
