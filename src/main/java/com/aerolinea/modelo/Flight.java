/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase modelo que permite hacer conexion y persistencia, entidad mapeada
 * @author Santiago Betancur V
 */


@Entity
@Table(name="flight")
public class Flight implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_flight;
    @Column
    private String departure_station;
    @Column
    private String arrival_station;
    @Column
    private String flight_number;
    @Column
    private Double price;
    @Column
    private String currency;
    @Temporal(TemporalType.DATE)
    private Date departure_date;

    public Flight(String departure_station, String arrival_station, String flight_number, Double price, String currency, Date departure_date) {
        this.departure_station = departure_station;
        this.arrival_station = arrival_station;
        this.flight_number = flight_number;
        this.price = price;
        this.currency = currency;
        this.departure_date = departure_date;
    }

    public Flight() {
    }
    
    

    public int getId_flight() {
        return id_flight;
    }
    
    

    public void setId_flight(int id_flight) {
        this.id_flight = id_flight;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public String getDeparture_station() {
        return departure_station;
    }

    public void setDeparture_station(String departure_station) {
        this.departure_station = departure_station;
    }

    public String getArrival_station() {
        return arrival_station;
    }

    public void setArrival_station(String arrival_station) {
        this.arrival_station = arrival_station;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Flight{" + "id_flight=" + id_flight + ", departure_date=" + departure_date + ", departure_station=" + departure_station + ", arrival_station=" + arrival_station + ", flight_number=" + flight_number + ", price=" + price + ", currency=" + currency + '}';
    }
    
    
    
}
