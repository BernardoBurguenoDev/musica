package br.com.tech4musica.musica.service;

import java.util.List;
import java.util.Optional;
import br.com.tech4musica.musica.shared.MusicaDto;

public interface MusicaService {
    List<MusicaDto> obterTodas();

    Optional<MusicaDto> obterPorId(String id);

    MusicaDto cadastrar(MusicaDto dto);

    MusicaDto atualizar(String id, MusicaDto dto);

    void remover(String id);
}
