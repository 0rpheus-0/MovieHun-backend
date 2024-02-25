package com.vitek.javalabs.service;

import org.springframework.stereotype.Service;

@Service
public class InformService {
    public String informName(String name){
        return "The name of the movie " + name;
    }
    public String informEmpty(){
        return "Please enter name";
    }
}
