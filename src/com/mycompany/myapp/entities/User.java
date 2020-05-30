/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;

/**
 *
 * @author hpp
 */
public class User {
    private int id  ;
    private String username ;
    
    private String email ;
    
    private int enabled ;
    private String salt ;
    private String password ;
    private Date last_login ;
    private String confirmation_token ;
    private Date password_requested_at	 ;
    private String roles ;


    public User(int id, String img_user, String nom) {
        this.id = id;

    }

    public User(int id) {
        this.id = id;
    }
    
        public User(String username , String email ,String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

   
    
    

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }



    public String getEmail() {
        return email;
    }

  

    public int getEnabled() {
        return enabled;
    }

    public String getSalt() {
        return salt;
    }

    public String getPassword() {
        return password;
    }

    public Date getLast_login() {
        return last_login;
    }

    public String getConfirmation_token() {
        return confirmation_token;
    }

    public Date getPassword_requested_at() {
        return password_requested_at;
    }

    public String getRoles() {
        return roles;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public void setEmail(String email) {
        this.email = email;
    }


    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public void setConfirmation_token(String confirmation_token) {
        this.confirmation_token = confirmation_token;
    }

    public void setPassword_requested_at(Date password_requested_at) {
        this.password_requested_at = password_requested_at;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public User(int id, String username, String email, int enabled, String salt, String password, Date last_login, String confirmation_token, Date password_requested_at, String roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.last_login = last_login;
        this.confirmation_token = confirmation_token;
        this.password_requested_at = password_requested_at;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", email=" + email + ", enabled=" + enabled + ", salt=" + salt + ", password=" + password + ", last_login=" + last_login + ", confirmation_token=" + confirmation_token + ", password_requested_at=" + password_requested_at + ", roles=" + roles + '}';
    }

    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
    }



            
    
}
