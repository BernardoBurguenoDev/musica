package br.com.tech4musica.musica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4musica.musica.service.MusicaService;
import br.com.tech4musica.musica.shared.MusicaDto;

@RestController
@RequestMapping("/api/musicas")
public class MusicaController {

    @Autowired
    private MusicaService service;

    @GetMapping
    public List<MusicaDto> obterTodas() {
        return service.obterTodas();
    }

    @GetMapping("/{id}")
    public Optional<MusicaDto> obterPorId(@PathVariable String id) {
        return service.obterPorId(id);
    }

    @PostMapping
    public MusicaDto cadastrar(@RequestBody MusicaDto dto) {
        return service.cadastrar(dto);
    }

    @PutMapping("/{id}")
    public MusicaDto atualizar(@PathVariable String id, @RequestBody MusicaDto dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable String id) {
        service.remover(id);
    }
}
