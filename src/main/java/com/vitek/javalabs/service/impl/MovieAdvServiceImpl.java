package com.vitek.javalabs.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.vitek.javalabs.payload.MovieAdv;
import com.vitek.javalabs.service.MovieAdvService;

@Service
public class MovieAdvServiceImpl implements MovieAdvService {
    @Value("${apiKey}")
    private String apiKey;

    public MovieAdv getInfotm(String name) {
        String url = "https://www.omdbapi.com/?apikey={apiKey}&t={name}";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(0, createMappingJacksonHttpMessageConverter());
        ResponseEntity<MovieAdv> responseEntity;
        HashMap<String, String> urlParams = new HashMap<>();
        urlParams.put("name", name);
        urlParams.put("apiKey", apiKey);
        responseEntity = restTemplate.getForEntity(url, MovieAdv.class, urlParams);
        MovieAdv responseBody = responseEntity.getBody();
        if (responseBody != null) {
            MovieAdv movieAdv = new MovieAdv();
            movieAdv.setTitle(responseBody.getTitle());
            movieAdv.setYear(responseBody.getYear());
            movieAdv.setReleased(responseBody.getReleased());
            movieAdv.setRuntime(responseBody.getRuntime());
            movieAdv.setGenre(responseBody.getGenre());
            movieAdv.setDirector(responseBody.getDirector());
            movieAdv.setWriter(responseBody.getWriter());
            movieAdv.setActors(responseBody.getActors());
            movieAdv.setPlot(responseBody.getPlot());
            movieAdv.setLanguage(responseBody.getLanguage());
            movieAdv.setCountry(responseBody.getCountry());
            movieAdv.setImdbRating(responseBody.getImdbRating());
            movieAdv.setType(responseBody.getType());
            return movieAdv;
        } else {
            return null;
        }
    }

    private ObjectMapper createObjectMapper() { // API возвращает неверные имена свойств

        return JsonMapper.builder()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false) // разрешить не указывать все
                                                                                     // свойства внутри класса
                .build();
    }

    private MappingJackson2HttpMessageConverter createMappingJacksonHttpMessageConverter() {

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(createObjectMapper());
        return converter;
    }

}