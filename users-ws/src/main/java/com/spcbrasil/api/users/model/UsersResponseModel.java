package com.spcbrasil.api.users.model;

import com.spcbrasil.api.shared.AddressDTO;
import lombok.Data;

import java.io.Serializable;

@Data
public class UsersResponseModel implements Serializable {


	private String id;

	private String name;

	private String email;

	private String birthdayDate;

	private String documentId;

	private String username;

	private String password;

	private String phone;

	private String mobilePhone;

	private byte[] profileImage;

	private AddressDTO address;


	
	
}
