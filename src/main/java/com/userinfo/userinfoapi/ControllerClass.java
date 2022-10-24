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
    public Map<String,Boolean> postUserInfo(@RequestBody EntityClass body){
        repository.save(body);
        HashMap <String,Boolean> map = new HashMap<>();
        map.put("status",true);
        return map;
    }

    @RequestMapping (value = "/getUserInfo", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public EntityClass getUserInfo(@RequestBody String deviceId){
        return repository.findByDeviceId(deviceId);
    }

    
}
