package com.vitek.javalabs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vitek.javalabs.cache.EntityCache;
import com.vitek.javalabs.dto.GenreDto;
import com.vitek.javalabs.model.Genre;
import com.vitek.javalabs.repository.GenreRepository;
import com.vitek.javalabs.service.GenreService;
import com.vitek.javalabs.utils.GenreMapping;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GenreServiceImpl implements GenreService {

    private GenreRepository genres;
    private EntityCache<GenreDto> genreCache;
    private GenreMapping genreMapping;

    public List<GenreDto> getAllGenres() {
        return genres.findAll().stream().map(x -> genreMapping.toDto(x)).toList();
    }

    public Optional<GenreDto> getGenreById(Long id) {
        Optional<GenreDto> genre = genreCache.get(id);
        if (!genre.isPresent()) {
            Optional<Genre> genreEntity = genres.findById(id);
            if (genreEntity.isPresent()) {
                genre = Optional.of(genreMapping.toDto(genreEntity.get()));
                genreCache.put(id, genre.get());
            }
        }
        return genre;
    }

    public GenreDto createGenre(GenreDto genre) {
        genreCache.put(genre.getId(), genre);
        return genreMapping.toDto(genres.save(genreMapping.toEntity(genre)));
    }

    public GenreDto updateGenre(Long id, GenreDto genre) {
        genre.setId(id);
        genreCache.put(id, genre);
        return genreMapping.toDto(genres.save(genreMapping.toEntity(genre)));
    }

    public Void deleteGenreBuId(Long id) {
        genreCache.remove(id);
        genres.deleteById(id);
        return null;
    }
}
