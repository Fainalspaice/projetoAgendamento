package com.javanauta.agendadorHorarios.services;


import com.javanauta.agendadorHorarios.infrastructure.repository.entity.Entity.Agendamento;
import com.javanauta.agendadorHorarios.infrastructure.repository.entity.Repository.agendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor

public class AgendamentoService {

    private static agendamentoRepository agendamentoRepository;

    public Agendamento salvarAgendamento(Agendamento agendamento) {

        LocalDateTime horaAgendamento = agendamento.getDataHoraAgendamemento();
        LocalDateTime horaFim = agendamento.getDataHoraAgendamemento().plusHours(1);

        Agendamento agendados = agendamentoRepository.findByServicoAndDataHoraAgendamementoBetween(agendamento.getServico(), horaAgendamento , horaFim);

        if (Objects.nonNull(agendados)) {
            throw new RuntimeException("horário já está preenchido.");
        }

        return agendamentoRepository.save(agendamento);

    }

    public static void deletarAgendamento(LocalDateTime dataHoraAgendamento, String cliente) {

        agendamentoRepository.deleteByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);
    }
    public Agendamento findByDataHoraAgendamementoBetween (LocalDate data){
        LocalDateTime primeiraHoraDia = data.atStartOfDay();
        LocalDateTime horaFinalDia = data.atTime(23, 59, 59);

        return agendamentoRepository.findByDataHoraAgendamementoBetween (primeiraHoraDia, horaFinalDia);
    }

    public Agendamento alterarAgendamento(Agendamento agendamento,  String cliente, LocalDateTime dataHoraAgendamento) {
        Agendamento agenda = agendamentoRepository.findByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);

        if (Objects.nonNull(agenda)) {
            throw new RuntimeException("horário nao está preenchido.");
        }

        agendamento.setId(agendamento.getId());
        return agendamentoRepository.save(agendamento);


    }

    public List<Agendamento> buscarAgendamentosDia(LocalDate data) {


        return List.of();
    }    }