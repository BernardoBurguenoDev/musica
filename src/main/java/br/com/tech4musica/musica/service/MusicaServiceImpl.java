package br.com.tech4musica.musica.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4musica.musica.model.Musica;
import br.com.tech4musica.musica.repository.MusicaRepository;
import br.com.tech4musica.musica.shared.MusicaDto;

@Service
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicaRepository repo;

    private MusicaDto fromModel(Musica musica) {
        MusicaDto dto = new MusicaDto();
        dto.setId(musica.getId());
        dto.setTitulo(musica.getTitulo());
        dto.setArtista(musica.getArtista());
        dto.setAlbum(musica.getAlbum());
        dto.setGenero(musica.getGenero());
        dto.setAnoLancamento(musica.getAnoLancamento());
        dto.setCompositor(musica.getCompositor());
        return dto;
    }

    private Musica fromDto(MusicaDto dto) {
        Musica musica = new Musica();
        musica.setId(dto.getId());
        musica.setTitulo(dto.getTitulo());
        musica.setArtista(dto.getArtista());
        musica.setAlbum(dto.getAlbum());
        musica.setGenero(dto.getGenero());
        musica.setAnoLancamento(dto.getAnoLancamento());
        musica.setCompositor(dto.getCompositor());
        return musica;
    }

    @Override
    public List<MusicaDto> obterTodas() {
        return repo.findAll().stream()
                .map(this::fromModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MusicaDto> obterPorId(String id) {
        return repo.findById(id).map(this::fromModel);
    }

    @Override
    public MusicaDto cadastrar(MusicaDto dto) {
        Musica musica = fromDto(dto);
        return fromModel(repo.save(musica));
    }

    @Override
    public MusicaDto atualizar(String id, MusicaDto dto) {
        Musica musica = fromDto(dto);
        musica.setId(id);
        return fromModel(repo.save(musica));
    }

    @Override
    public void remover(String id) {
        repo.deleteById(id);
    }
}
