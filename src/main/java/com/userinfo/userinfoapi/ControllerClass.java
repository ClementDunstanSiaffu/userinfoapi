package com.userinfo.userinfoapi;

import java.util.Map;
import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class ControllerClass {

    private RepositoryClass repository;

    @Autowired
    ControllerClass(RepositoryClass repository){
        this.repository = repository;
    }
    
    @RequestMapping(value = "/postUserInfo",method =RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Map<String,Boolean> postUserInfo(@RequestBody BodyEntity body){
        repository.save(body.getWhere());
        HashMap <String,Boolean> map = new HashMap<>();
        map.put("status",true);
        return map;
    }

    @RequestMapping (value = "/getUserInfo", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public EntityClass getUserInfo(@RequestBody DeviceWhereEntity deviceid){
        String deviceId = deviceid.getWhere().getDeviceid();
        try{
            return repository.findByDeviceid(deviceId);
        }
        catch(Exception e){
            EntityClass newEntityClass = new EntityClass();
            return newEntityClass;
        }
    }

    @RequestMapping(value = "/putUserInfo",method =RequestMethod.PUT)
    @ResponseBody
    @CrossOrigin
    public Map<String,Boolean> putUserInfo(@RequestBody BodyEntity body){
        String deviceid = body.getWhere().getDeviceid();
        String city = body.getWhere().getCity();
        String street = body.getWhere().getStreet();
        String firstname = body.getWhere().getFirstname();
        String lastname = body.getWhere().getLastname();
        String phone = body.getWhere().getPhone();
        EntityClass currentEntity = repository.findByDeviceid(deviceid);
        System.out.println("check the value" + " "+ city);
        if(currentEntity != null){
            currentEntity.setCity(city);
            currentEntity.setPhone(phone);
            currentEntity.setFirstname(firstname);
            currentEntity.setLastname(lastname);
            currentEntity.setStreet(street);
            currentEntity.setDeviceid(deviceid);
            repository.save(currentEntity);
        }else{
            repository.save(body.getWhere());
        }
        HashMap <String,Boolean> map = new HashMap<>();
        map.put("status",true);
        return map;
    }

    
}
