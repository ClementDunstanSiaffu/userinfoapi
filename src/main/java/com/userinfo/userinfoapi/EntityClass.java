
package com.userinfo.userinfoapi;

import org.springframework.data.annotation.Id;

public class EntityClass{
    
    @Id
    private String deviceId;
    private String firstname;
    private String lastname;
    private String city;
    private String phone;

    EntityClass(
        String deviceId,
        String firstname,
        String lastname,
        String city,
        String phone
    ){
        this.deviceId = deviceId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.phone = phone;
    }

    public String getId(){
        return this.deviceId;
    }

    public void setFirstName(String firstname){
        this.firstname = firstname;
    }

    public String getFirstName (){
        return this.firstname;
    }

    public void setLastName(String firstname){
        this.firstname = firstname;
    }

    public String getLastName(){
        return this.lastname;
    }

    public void setCity (String city){
        this.city = city;
    }

    public String getCity(){
        return this.city;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return this.phone;
    }


}