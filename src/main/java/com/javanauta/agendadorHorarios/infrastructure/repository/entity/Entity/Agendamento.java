package com.javanauta.agendadorHorarios.infrastructure.repository.entity.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agendamento")

public class Agendamento{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String produto;
    private String servico;
    private  String profissional;
    private LocalDateTime dataHoraAgendamemento;
    private  String cliente;
    private  String telefoneCliente;
    private LocalDateTime dataInsercao = LocalDateTime.now();



}
