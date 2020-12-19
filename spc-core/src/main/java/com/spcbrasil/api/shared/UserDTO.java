package com.spcbrasil.api.shared;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO  implements Serializable {

	private static final long serialVersionUID = -953297098295050686L;

	private String id;

	private String name;

	private String email;

	private String birthdayDate;

	private String documentId;

	private String username;

	private String password;

	private String phone;

	private String mobilePhone;

	private AddressDTO address;

	private String lang;

	private byte[] profileImage;

	private Boolean accountVerified;
	
	
	
	 
	
	
	
}
