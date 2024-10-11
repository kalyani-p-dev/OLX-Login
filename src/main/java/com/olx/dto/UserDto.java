package com.olx.dto;

import jakarta.validation.constraints.NotEmpty;

public class UserDto {
	private int id;
	@NotEmpty(message = "User Name cannot be blank")
	private String userName;
	@NotEmpty(message = "Fisrt Name cannot be blank")
	private String firstName;
	private String lastName;
	private String email;
	private long phone;
	private String password;
	private String token;
	
	public UserDto() {}
	
	public UserDto(int id, String userName, String firstName, String lastName, String email, long phone,
			String password, String token) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.token = token;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	@Override
	public boolean equals(Object object) {
		UserDto userDto = (UserDto)object;
		if(this.id == userDto.id)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + ", password=" + password + ", token=" + token + "]";
	}
	
	
	
	

}
