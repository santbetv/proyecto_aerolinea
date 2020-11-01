/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.excepcion;

/**
 * Clase que permite manupulaciones de acciones del usuario
 * @author Santiago Betancur Villegas <santiago-betancur at hotmail.com>
 */
public class AerolineaExcepcion extends Exception{

    public AerolineaExcepcion() {
    }

    public AerolineaExcepcion(String message) {
        super(message);
    }

    public AerolineaExcepcion(String message, Throwable cause) {
        super(message, cause);
    }

    public AerolineaExcepcion(Throwable cause) {
        super(cause);
    }
    
    
    
    
    
    
}
