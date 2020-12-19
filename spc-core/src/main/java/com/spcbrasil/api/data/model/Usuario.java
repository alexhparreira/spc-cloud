package com.spcbrasil.api.data.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document(collection = "user")
@Data
public class Usuario implements Serializable {

    private static final long serialVersionUID = 4320748870214037443L;

    @Id
    private String id;

    @TextIndexed
    private String name;

     
    private String email;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date birthdayDate;

    private String documentId;

    private String username;

    private String password;

    private String phone;

    private String mobilePhone;

    private Address address;

    private byte[] profileImage;


    private Boolean accountVerified;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario person = (Usuario) o;
        return Objects.equals(getId(), person.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}
