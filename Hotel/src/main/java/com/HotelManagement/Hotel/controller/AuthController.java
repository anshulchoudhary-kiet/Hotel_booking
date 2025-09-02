package com.HotelManagement.Hotel.controller;

import com.HotelManagement.Hotel.dto.LoginRequest;
import com.HotelManagement.Hotel.dto.Response;
import com.HotelManagement.Hotel.entity.User;
import com.HotelManagement.Hotel.service.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody User user){
        Response response=userService.register(user);
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }
 @PostMapping("/login")
 public ResponseEntity<Response> login(@RequestBody LoginRequest loginRequest){
       Response response=userService.login(loginRequest);
       return ResponseEntity.status(response.getStatusCode()).body(response);
 }

}
