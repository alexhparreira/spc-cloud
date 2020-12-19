package com.spcbrasil.api.users.model;

import lombok.Data;

@Data
public class AddressModel {

    private String id;
    private String postalCode;
    private String address;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String country;
    private Double latitude;
    private Double longitude;
}
