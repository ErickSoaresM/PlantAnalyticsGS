package br.com.fiap.plantanalytics.controllers;

import br.com.fiap.plantanalytics.models.Analise;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.plantanalytics.repositories.AnaliseRepository;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/analises")
public class AnaliseController {


    private AnaliseRepository analiseRepository;

    @GetMapping("listar")
    public List<Analise> listarAnalises() {
        return analiseRepository.findAll();
    }

    @PostMapping("cadastrar")
    public Analise enviarAnalise(@RequestBody Analise analise) {
        Analise novaAnalise = analiseRepository.save(analise);
        return ResponseEntity.ok(novaAnalise).getBody();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Analise> obterAnalisePorId(@PathVariable Long id) {
        Optional<Analise> analiseOptional = analiseRepository.findById(id);

        if (analiseOptional.isPresent()) {
            Analise analise = analiseOptional.get();
            return ResponseEntity.ok(analise);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAnalise(@PathVariable Long id) {
        Optional<Analise> analiseOptional = analiseRepository.findById(id);

        if (analiseOptional.isPresent()) {
            analiseRepository.delete(analiseOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}