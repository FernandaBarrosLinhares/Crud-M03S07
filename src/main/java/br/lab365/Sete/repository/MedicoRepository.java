package br.lab365.Sete.repository;

import br.lab365.Sete.model.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicoRepository extends JpaRepository<MedicoModel, UUID> {
}
