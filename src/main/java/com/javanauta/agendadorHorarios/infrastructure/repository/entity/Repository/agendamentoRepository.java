package com.javanauta.agendadorHorarios.infrastructure.repository.entity.Repository;

import com.javanauta.agendadorHorarios.infrastructure.repository.entity.Entity.Agendamento;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.Transient;
import java.time.LocalDateTime;

public interface agendamentoRepository  extends JpaRepository<Agendamento, Long> {

    Agendamento findByServicoAndDataHoraAgendamementoBetween(String getServico, LocalDateTime dataHoraInicial, LocalDateTime dataHoraFim);

    @Transactional
    void deleteByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente);


    Agendamento findByDataHoraAgendamementoBetween(LocalDateTime dataHoraInicial, LocalDateTime dataHoraFinal);

    Agendamento findByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente);





}



