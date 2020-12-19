package com.spcbrasil.api.data.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "address")
@Getter
@Setter
@ToString
public class Address  implements Serializable {

    @Id
    private String id;
    private String postalCode;
    private String address;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String country;

    /*
    [0] latitude
    [1] longitude
     */
    @GeoSpatialIndexed
    private Double[] location;


    private String timezone;





}
