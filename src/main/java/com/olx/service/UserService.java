package com.olx.service;


import org.springframework.http.ResponseEntity;

import com.olx.dto.UserDto;

public interface UserService {
 ResponseEntity<UserDto> registerNewUser(UserDto userDto);

Object validateToken(String string);


}

