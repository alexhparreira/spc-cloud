package com.spcbrasil.api.users.service.impl;

import java.util.*;

import com.spcbrasil.api.data.model.Usuario;
import com.spcbrasil.api.exception.UserNotFoundException;
import com.spcbrasil.api.shared.UserDTO;
import com.spcbrasil.api.users.data.UserRepository;
import com.spcbrasil.api.users.service.mapper.UserMapper;
import com.spcbrasil.api.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersServiceImpl implements UsersService {

    UserRepository usersRepository;

    BCryptPasswordEncoder passwordEncoder;




    public UsersServiceImpl(UserRepository usersRepository, BCryptPasswordEncoder passwordEncoder) {
        super();
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Autowired
    UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) {

        Usuario userEntity = usersRepository.findByUsernameOrEmail(username, username);


        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(userEntity.getEmail(), userEntity.getPassword(), true, true, true, true, new ArrayList<>());
    }

    @Override
    @Transactional
    public UserDTO getUserDetailsByEmail(String emailOrUsername) {


        Usuario Usuario = usersRepository.findByUsernameOrEmail(emailOrUsername, emailOrUsername);

        if (Usuario == null) {
            throw new UserNotFoundException("Not Found");
        }

        UserDTO dto = new UserDTO();
        userMapper.entityToDTO(Usuario, dto);

        return dto;

    }





}
