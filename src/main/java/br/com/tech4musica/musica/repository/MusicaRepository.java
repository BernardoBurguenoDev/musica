package br.com.tech4musica.musica.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.tech4musica.musica.model.Musica;

public interface MusicaRepository extends MongoRepository<Musica, String> {
}
