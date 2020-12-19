package com.spcbrasil.api.shared;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddressDTO implements Serializable {

    private static final long serialVersionUID = 953297098295030686L;

    private String id;
    private String postalCode;
    private String address;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private Double latitude;
    private Double longitude;
    private String timezone;

}
