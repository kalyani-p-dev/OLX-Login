package com.olx.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.olx.dto.UserDto;
import com.olx.entity.UserEntity; // Correct import for UserEntity class
import com.olx.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseEntity<UserDto> registerNewUser(UserDto userDto) {
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        userEntity = userRepository.save(userEntity); // Saves into table
        userDto = modelMapper.map(userEntity, UserDto.class);
        return new ResponseEntity<UserDto>(userDto, HttpStatus.CREATED);
    }

	@Override
	public Object validateToken(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
