/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.validadores;

import com.aerolinea.excepcion.AerolineaExcepcion;

/**
 * Clase que da soporte en el proyecto para llamarla en verificación de
 * procesos.
 *
 * @author rizzoli
 */
public class AerolineaValidador {

    public static void verificarDatosIguales(String destino, String salida) throws AerolineaExcepcion {
        if (destino.equals(salida)) {
            throw new AerolineaExcepcion("Debe diligenciar diferente cidudad");
        } else {
            throw new AerolineaExcepcion("Cidudades correctas");
        }
    }

    public static void verificarBasedeDatos() throws AerolineaExcepcion {

        throw new AerolineaExcepcion("Debe validar base de datos intalada y configurada");

    }

}
