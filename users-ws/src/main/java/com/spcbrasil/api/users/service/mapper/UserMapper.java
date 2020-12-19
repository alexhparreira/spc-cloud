package com.spcbrasil.api.users.service.mapper;


import com.spcbrasil.api.data.model.*;
import com.spcbrasil.api.exception.SPCException;
import com.spcbrasil.api.shared.AddressDTO;
import com.spcbrasil.api.shared.UserDTO;
import com.spcbrasil.api.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserMapper {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;


    public Usuario dtoToEntity(UserDTO userDetails, Usuario Usuario) {

        if(userDetails.getPassword()!=null) {
            Usuario.setPassword( passwordEncoder.encode(userDetails.getPassword()) );
        }

        if(userDetails.getBirthdayDate()!=null){
            Date birthday = StringUtil.stringToDate(userDetails.getBirthdayDate(), "dd/MM/yyyy");
            Usuario.setBirthdayDate(birthday);
        }

        if(userDetails.getName()!=null){
            Usuario.setName(userDetails.getName());
        }

        if(userDetails.getEmail()!=null){
            Usuario.setEmail(userDetails.getEmail());
        }

        if(userDetails.getDocumentId()!=null){
            Usuario.setDocumentId(userDetails.getDocumentId());
        }

        if(userDetails.getUsername()!=null){
            Usuario.setUsername(userDetails.getUsername());
        }

        if(userDetails.getPhone()!=null){
            Usuario.setPhone(userDetails.getPhone());
        }

        if(userDetails.getMobilePhone()!=null){
            Usuario.setMobilePhone(userDetails.getMobilePhone());
        }

        AddressDTO addressDTO = userDetails.getAddress();




        if(userDetails.getProfileImage()!=null){
            Usuario.setProfileImage(userDetails.getProfileImage());
        }

        return Usuario;
    }


    public UserDTO entityToDTO(Usuario entity,UserDTO userDetails){


        if(entity.getBirthdayDate()!=null){
            String birthday =   StringUtil.dateToString(entity.getBirthdayDate(), "dd/MM/yyyy");
            userDetails.setBirthdayDate(birthday);
        }

        if(entity.getName()!=null){
            userDetails.setName(entity.getName());
        }

        if(entity.getEmail()!=null){
            userDetails.setEmail(entity.getEmail());
        }

        if(entity.getDocumentId()!=null){
            userDetails.setDocumentId(entity.getDocumentId());
        }

        userDetails.setId(entity.getId());

        if(entity.getUsername()!=null){
            userDetails.setUsername(entity.getUsername());
        }

        if(entity.getPhone()!=null){
            userDetails.setPhone(entity.getPhone());
        }

        if(entity.getMobilePhone()!=null){
            userDetails.setMobilePhone(entity.getMobilePhone());
        }

        Address address = entity.getAddress();

        if(address!=null){

            AddressDTO addressDTO = new AddressDTO();
            BeanUtils.copyProperties(address,addressDTO);
            userDetails.setAddress(addressDTO);
            if(address.getLocation() != null && address.getLocation().length==2){
                addressDTO.setLatitude(address.getLocation()[0]);
                addressDTO.setLongitude(address.getLocation()[1]);

            }

        }


        if(entity.getProfileImage()!=null){
            userDetails.setProfileImage(entity.getProfileImage());
        }



        userDetails.setAccountVerified(entity.getAccountVerified());

        return userDetails;
    }





}