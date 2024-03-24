package com.vitek.javalabs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vitek.javalabs.cache.EntityCache;
import com.vitek.javalabs.model.Genre;
import com.vitek.javalabs.repository.GenreRepository;
import com.vitek.javalabs.service.GenreService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GenreServiceImpl implements GenreService {

    private GenreRepository genres;
    private EntityCache<Genre> genreCache;

    public List<Genre> getAllGenres() {
        return genres.findAll();
    }

    public Optional<Genre> getGenreById(Long id) {
        Optional<Genre> genre = genreCache.get(id);
        if (!genre.isPresent()) {
            genre = genres.findById(id);
            if (genre.isPresent())
                genreCache.put(id, genre.get());
        }
        return genre;
    }

    public Genre createGenre(Genre genre) {
        genreCache.put(genre.getId(), genre);
        return genres.save(genre);
    }

    public Genre updateGenre(Long id, Genre genre) {
        genre.setId(id);
        genreCache.put(id, genre);
        return genres.save(genre);
    }

    public Void deleteGenreBuId(Long id) {
        genreCache.remove(id);
        genres.deleteById(id);
        return null;
    }
}
