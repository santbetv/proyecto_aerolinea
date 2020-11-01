/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.controlador;

import com.aerolinea.dao.FlightDAO;
import com.aerolinea.modelo.Flight;
import com.aerolinea.utilidad.Constantes;
import com.aerolinea.utilidad.ConsumoRestWS;
import com.aerolinea.validadores.AerolineaValidador;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author rizzoli
 */
@Named(value = "controladorFlight")
@SessionScoped
public class ControladorFlight implements Serializable {

    private int cantidadDeVuelos = 3;
    private String origen = "";
    private String destino = "";
    private Date viaje;
    private List<Flight> arrayDeJsonAero = new ArrayList<>();

    /**
     * Creates a new instance of ControladorFlight
     */
    public ControladorFlight() {

    }

    public int getCantidadDeVuelos() {
        return cantidadDeVuelos;
    }

    public List<Flight> getArrayDeJsonAero() {
        return arrayDeJsonAero;
    }

    public void setArrayDeJsonAero(List<Flight> arrayDeJsonAero) {
        this.arrayDeJsonAero = arrayDeJsonAero;
    }

    public void setArrayDeJsonAero(ArrayList<Flight> arrayDeJsonAero) {
        this.arrayDeJsonAero = arrayDeJsonAero;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getViaje() {
        return viaje;
    }

    public void setViaje(Date viaje) {
        this.viaje = viaje;
    }

    //Metodo para inicializar antes las paginas
    @PostConstruct
    public void iniciar() {

        //datosJsonConsumoServicio();
    }

    public void buscarVuelos() {
        String valor = "" + viaje.toString();
        String fechaFormato = "" + ZonedDateTime.parse(valor, DateTimeFormatter.ofPattern("EEE MMM d HH:mm:ss zzz uuuu", Locale.US));
        valor = fechaFormato.substring(0, fechaFormato.indexOf("T"));
        datosJsonConsumoServicio(origen, destino, valor);
    }

    private void datosJsonConsumoServicio(String ori, String des, String fecha) {
        try {

            String json = "{\"Origin\":\"" + ori + "\",\"Destination\":\"" + des + "\",\"From\":\"" + fecha + "\"}";
            
            //Se adiciona manejos de exepciones 
//            AerolineaValidador.verificarDatosIguales(ori, des);
            
            String[] respuesta = ConsumoRestWS.comsumoRestPost(json, Constantes.RUTA_RECURSOS, "");

            if (respuesta[0].equals("true")) {

                String dataOuputFiltrada = respuesta[1];
                dataOuputFiltrada = dataOuputFiltrada.substring(1, dataOuputFiltrada.length() - 1).replace("\\", "");
                JSONArray arregloJson = new JSONArray(dataOuputFiltrada);

                for (int i = 0; i < arregloJson.length(); i++) {

                    arrayDeJsonAero = new ArrayList<>();
                    JSONObject valores = arregloJson.getJSONObject(i);

                    arrayDeJsonAero.add(new Flight(valores.getString("DepartureStation"),
                            valores.getString("ArrivalStation"),
                            valores.getString("FlightNumber"),
                            valores.getDouble("Price"),
                            valores.getString("Currency"),
                            ParseFecha(valores.getString("DepartureDate"))));
                }

                FacesContext context = FacesContext.getCurrentInstance();

                context.addMessage(null, new FacesMessage("Successful", "Se encuentra en busqueda de vuelos"));

            }else{
                FacesContext context = FacesContext.getCurrentInstance();

                context.addMessage(null, new FacesMessage("Error", "Intenta de nuevo"));
            }
        } catch (Exception e) {
            System.out.println("Eroor de proceso"+e.getMessage());
        }
    }

    //me todos de consumo Este per utilizar la base de datos Mysql, Con ORM HIbernate y JPA, mostrando lo que se tiene alli adentro
    public void obtenerClientes() {
        FlightDAO clienteDAO = new FlightDAO();
        
        System.out.println("datoss: " + clienteDAO.obtenerClientes());
    }

    /**
     * Permite convertir un String en fecha (Date).
     *
     * @param fecha Cadena de fecha dd/MM/yyyy
     * @return Objeto Date
     */
    public static Date ParseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }

}
