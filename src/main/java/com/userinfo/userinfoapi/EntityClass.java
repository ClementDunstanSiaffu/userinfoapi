
package com.userinfo.userinfoapi;

import org.springframework.data.annotation.Id;

public class EntityClass{
    
    @Id
    private String id;
    private String deviceid;
    private String firstname;
    private String lastname;
    private String city;
    private String phone;
    private String street;

    EntityClass(){};

    EntityClass(
        String deviceid,
        String firstname,
        String lastname,
        String city,
        String phone,
        String street
    ){
        this.deviceid = deviceid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.phone = phone;
        this.street = street;
    }

    public String setDeviceid(String deviceid){
        return this.deviceid = deviceid;
    }

    public String getDeviceid(){
        return this.deviceid;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getFirstname (){
        return this.firstname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getLastname(){
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

    public void setStreet(String street){
        this.street = street;
    }

    public String getStreet (){
        return street;
    }


}