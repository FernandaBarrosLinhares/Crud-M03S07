package br.lab365.Sete.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Entity
@Table(name="TB-MEDICO")
@Getter
@Setter

public class MedicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String email;
    private String nome;
    private String telefone;
    private String Crm;
}
