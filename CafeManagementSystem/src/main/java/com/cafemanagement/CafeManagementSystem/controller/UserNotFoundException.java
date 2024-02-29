package com.cafemanagement.CafeManagementSystem.controller;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("could not found user for this id"+id);
    }
}
