package com.spcbrasil.api.users.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class CreateUsersRequestModel {
	

	@Size(min=4,message = "min 4 carac")
	private String name;

	@Email(message="Invalid Email")
	private String email;
	
	private String password;

	private String id;

	private String birthdayDate;

	private String documentId;

	private String username;


	private String phone;

	private String mobilePhone;

	private AddressModel address;

	@Size(min=2,max=5,message = "Invalid Number of caracters")
	private String lang;

	private  byte[] profileImage;
	
	
	
}
