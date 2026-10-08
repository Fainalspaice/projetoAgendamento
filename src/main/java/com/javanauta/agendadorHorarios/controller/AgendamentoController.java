package com.javanauta.agendadorHorarios.controller;

import com.javanauta.agendadorHorarios.infrastructure.repository.entity.Entity.Agendamento;
import com.javanauta.agendadorHorarios.services.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Agendamento> salvarAgendamento(
            @RequestBody Agendamento agendamento) {

        return ResponseEntity.ok()
                .body(agendamentoService.salvarAgendamento(agendamento));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAgendamento(
            @RequestParam String cliente,
            @RequestParam LocalDateTime dataHoraAgendamento) {

        agendamentoService.deletarAgendamento(
                dataHoraAgendamento,
                cliente
        );

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> buscarAgendamentosDia(
            @RequestParam LocalDate data) {

        return ResponseEntity.ok()
                .body(agendamentoService.buscarAgendamentosDia(data));
    }

    @PutMapping
    public ResponseEntity<Agendamento> alterarAgendamento(
            @RequestParam String cliente,
            @RequestParam LocalDateTime dataHoraAgendamento,
            @RequestBody Agendamento agendamento) {

        return ResponseEntity.accepted()
                .body(agendamentoService.alterarAgendamento(
                        agendamento,
                        cliente,
                        dataHoraAgendamento
                ));
    }
}