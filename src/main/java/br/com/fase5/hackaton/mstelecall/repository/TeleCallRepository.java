package br.com.fase5.hackaton.mstelecall.repository;

import br.com.fase5.hackaton.mstelecall.model.TeleCallModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface TeleCallRepository extends JpaRepository<TeleCallModel, UUID> {
}
