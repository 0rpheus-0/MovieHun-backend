package com.vitek.javalabs.service;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.vitek.javalabs.payload.Movie;

@Service
public class InformService {
    public Movie getInfotm(String name) {
        String url = "https://www.omdbapi.com/?apikey=71559e25&t={name}";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(0, createMappingJacksonHttpMessageConverter());
        ResponseEntity<Movie> responseEntity;
        responseEntity = restTemplate.getForEntity(url, Movie.class, name);
        Movie responseBody = responseEntity.getBody();
        if (responseBody != null) {
            Movie movie = new Movie();
            movie.setTitle(responseBody.getTitle());
            movie.setYear(responseBody.getYear());
            movie.setReleased(responseBody.getReleased());
            movie.setRuntime(responseBody.getRuntime());
            movie.setGenre(responseBody.getGenre());
            movie.setDirector(responseBody.getDirector());
            movie.setWriter(responseBody.getWriter());
            movie.setActors(responseBody.getActors());
            movie.setPlot(responseBody.getPlot());
            movie.setLanguage(responseBody.getLanguage());
            movie.setCountry(responseBody.getCountry());
            movie.setImdbRating(responseBody.getImdbRating());
            movie.setType(responseBody.getType());
            return movie;
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