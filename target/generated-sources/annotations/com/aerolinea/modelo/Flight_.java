package com.aerolinea.modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-12T20:40:44")
@StaticMetamodel(Flight.class)
public class Flight_ { 

    public static volatile SingularAttribute<Flight, String> departure_station;
    public static volatile SingularAttribute<Flight, String> flight_number;
    public static volatile SingularAttribute<Flight, Double> price;
    public static volatile SingularAttribute<Flight, Date> departure_date;
    public static volatile SingularAttribute<Flight, String> currency;
    public static volatile SingularAttribute<Flight, String> arrival_station;
    public static volatile SingularAttribute<Flight, Integer> id_flight;

}