package com.uniamerida.estadistica.Controller;

import com.uniamerida.estadistica.DTO.EstatisticasDTO;
import com.uniamerida.estadistica.Service.NumeroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/numeros")
public class NumeroController {

    @Autowired
    private NumeroService numeroService;

    @PostMapping
    public ResponseEntity<Void> adicionarNumero(@RequestBody @Valid Double valor) { // validation added
        if (valor == null) {
            return ResponseEntity.badRequest().build();
        }
        numeroService.salvarNumero(valor);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/estatisticas")
    public ResponseEntity<EstatisticasDTO> obterEstatisticas() { // Return DTO
        try {
            NumeroService.Estatisticas estatisticas = numeroService.calcularEstatisticas();
            EstatisticasDTO dto = new EstatisticasDTO(estatisticas.getMedia(), estatisticas.getMediana(), estatisticas.getDesvioPadrão());
            return ResponseEntity.ok(dto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

