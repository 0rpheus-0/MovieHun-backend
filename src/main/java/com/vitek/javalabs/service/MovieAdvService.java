package com.vitek.javalabs.service;

import org.springframework.stereotype.Service;

import com.vitek.javalabs.payload.MovieAdv;

@Service
public interface MovieAdvService {

    MovieAdv getInfotm(String name);

}