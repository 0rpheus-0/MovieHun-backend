package com.vitek.javalabs.service;
import com.vitek.javalabs.Inform;
import org.springframework.stereotype.Service;

@Service
public class InformService {
    public Inform informName(String name) {
        Inform inform = new Inform();
        inform.setInform("The name of the movie " + name);
        return inform;
    }

    public Inform informEmpty() {
        Inform inform = new Inform();
        inform.setInform("Please enter name");
        return inform;
    }
}
