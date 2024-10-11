//package com.olxcontroller;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
//import static org.hamcrest.Matchers.containsString;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.olx.controller.UserController;
//import com.olx.dto.UserDto;
//import com.olx.exception.InvalidLoginException;
//import com.olx.service.UserService;
////import com.zensar.controller.StockController;
//
//
//@ExtendWith(MockitoExtension.class)
//@WebMvcTest(UserController.class)
//
//public class UserControllerTest {
//	@Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserService userService; 
//
//    @InjectMocks
//    private UserController userController;
//    
//    @Autowired
//	ObjectMapper objectMapper;
//    @Test
//    public void testRegisterNewUser() throws Exception {
//        UserDto userDto = new UserDto();
//        userDto.setUserName("john_doe");
//        userDto.setFirstName("John");
//        userDto.setLastName("Doe");
//        userDto.setEmail("john.doe@example.com");
//        userDto.setPhone(1234567890L);
//        userDto.setPassword("password123");
//        userDto.setToken("token123");
//
//        ResponseEntity<UserDto> responseEntity = new ResponseEntity<>(userDto, HttpStatus.CREATED);
//        when(userService.registerNewUser(any(UserDto.class))).thenReturn(responseEntity);
//
//        mockMvc.perform(post("http://localhost:5005/user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(userDto)))
//                .andExpect(status().isCreated())
//                .andExpect(content().string(containsString("john_doe")));
//    }
//
//
//    @Test
//    public void testRegisterNewUserBlankUserName() throws Exception {
//        UserDto userDto = new UserDto();
//        userDto.setUserName("");
//        userDto.setFirstName("John");
//        userDto.setLastName("Doe");
//        userDto.setEmail("john.doe@example.com");
//        userDto.setPhone(1234567890L);
//        userDto.setPassword("password123");
//        userDto.setToken("token123");
//
//        when(userService.registerNewUser(any(UserDto.class))).thenThrow(new InvalidLoginException("User Name cannot be blank"));
//
//        MvcResult mvcResult = mockMvc.perform(post("http://localhost:5005/user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(userDto)))
//                .andExpect(status().isBadRequest())
//                .andReturn();
//    }
//    
////    @BeforeEach
////    public void setUp() {
////        // Initialize MockMvc with the controller under test
////        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
////    }
////
////    @Test
////    public void validateUserToken_ReturnsTrue_IfTokenIsValid() throws Exception {
////        // Assuming the service method to validate the token
////        when(userService.validateToken("X9KK3EIQ0CM")).thenReturn(true);
////
////        mockMvc.perform(get("/token/validate")
////                .header("token", "X9KK3EIQ0CM"))
////                .andExpect(status().isOk())
////                .andExpect(content().string("true"));
////    }
////
////    @Test
////    public void validateUserToken_ReturnsFalse_IfTokenIsInvalid() throws Exception {
////        // Assuming the service method to validate the token
////        when(userService.validateToken("invalid_token")).thenReturn(false);
////
////        mockMvc.perform(get("/token/validate")
////                .header("token", "invalid_token"))
////                .andExpect(status().isUnauthorized())
////                .andExpect(content().string("false"));
////    }
//    
//    
//}
