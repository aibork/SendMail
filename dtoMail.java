package com.axelbork.portfolioDto;

import javax.validation.constraints.NotBlank;


public class dtoMail {
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String message;

    public dtoMail() {
    }

    public dtoMail(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
