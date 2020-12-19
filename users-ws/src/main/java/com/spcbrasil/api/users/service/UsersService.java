package com.spcbrasil.api.users.service;

import com.spcbrasil.api.shared.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UsersService extends UserDetailsService {


    UserDTO getUserDetailsByEmail(String userName);



}
