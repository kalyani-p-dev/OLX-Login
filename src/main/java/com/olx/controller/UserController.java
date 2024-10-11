package com.olx.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.UserDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
public class UserController {

	
	@Operation(summary = "Authenticate user", description = "Authenticates a user and returns a token")
	@ApiResponse(responseCode = "200", description = "User successfully authenticated",
	        content = {
	                @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
	                         schema = @Schema(implementation = UserDto.class)),
	                @Content(mediaType = MediaType.APPLICATION_XML_VALUE,
	                         schema = @Schema(implementation = UserDto.class))
	        })
	@ApiResponse(responseCode = "401", description = "Unauthorized")
	@PostMapping(value = "/user/authenticate", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserDto> loginUser(@Valid @RequestBody UserDto userDto) {
		userDto.setToken("X9KK3EIQ0CM");
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);

	}

	@Operation(summary = "Logout user", description = "Logs out the user by invalidating the user's token")
	@ApiResponse(responseCode = "200", description = "User successfully logged out",
	        content = @Content(schema = @Schema(implementation = Boolean.class)))
	@ApiResponse(responseCode = "401", description = "Unauthorized, invalid or expired token")
	@DeleteMapping(value = "/user/logout")
	public ResponseEntity<Boolean> logoutUser(@RequestHeader("token") String authorization) {
		if (authorization.equals("X9KK3EIQ0CM")) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);

	}

	@Operation(summary = "Register new user", description = "Registers a new user and returns the user data")
	@ApiResponse(responseCode = "201", description = "User successfully registered",
	        content = @Content(schema = @Schema(implementation = UserDto.class)))
	@ApiResponse(responseCode = "400", description = "Bad Request, invalid user data")
	@PostMapping(value = "/user", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserDto> registerNewUser(@Valid @RequestBody UserDto userDto) {
		userDto.setId(user.size() + 1);
		user.add(userDto);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.CREATED);

	}

	@Operation(summary = "Get all users", description = "Retrieves a list of all registered users")
	@ApiResponse(responseCode = "200", description = "Successfully retrieved all users",
	        content = {
	                @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
	                         schema = @Schema(implementation = List.class)),
	                @Content(mediaType = MediaType.APPLICATION_XML_VALUE,
	                         schema = @Schema(implementation = List.class))
	        })
	@ApiResponse(responseCode = "401", description = "Unauthorized, invalid or expired token")
	@GetMapping(value = "/user", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<UserDto>> getAllUsers(@RequestHeader("token") String authorization) {
		if (authorization.equals("X9KK3EIQ0CM")) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

	@Operation(summary = "Validate user token", description = "Validates a user token and returns a boolean result")
	@ApiResponse(responseCode = "200", description = "Token is valid",
	        content = @Content(schema = @Schema(implementation = Boolean.class)))
	@ApiResponse(responseCode = "401", description = "Unauthorized, invalid or expired token")
	@GetMapping(value = "/token/validate")
	public ResponseEntity<Boolean> validateUserToken(@RequestHeader("token") String authorization) {
		if (authorization.equals("X9KK3EIQ0CM")) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);

	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	
}

	private static List<UserDto> user = new ArrayList<UserDto>();
	static {
		user.add(new UserDto(1, "KP567", "Kalyani", "P", "kalyanip@gmail.com", 28676, "12345", "X9KK3EIQ0CM"));
		user.add(new UserDto(2, "TS88889", "Tom", "S", "Tom@gmail.com", 24790, "12345", "X9KK3EIQ0CM"));
		user.add(new UserDto(3, "JK88787", "John", "K", "John@gmail.com", 296379, "12345", "X9KK3EIQ0CM"));
	}
}
