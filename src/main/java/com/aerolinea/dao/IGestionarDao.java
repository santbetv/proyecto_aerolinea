/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.dao;

import java.util.List;

/**
 * Interface que genera multiple funcionamineto en difetes DAOs
 * @author Santiago Betancur V
 * @param <T>
 */
public interface IGestionarDao<T> {
    
    // guardar vuelo
    public void guardar(T vuelo);

    // obtener todos los vuelos
    public List<T> obtenerClientes();
    
}
