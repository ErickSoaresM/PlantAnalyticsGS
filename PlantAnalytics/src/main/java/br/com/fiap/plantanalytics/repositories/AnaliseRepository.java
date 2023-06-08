package br.com.fiap.plantanalytics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.fiap.plantanalytics.models.Analise;

@Repository
public interface AnaliseRepository extends JpaRepository<Analise, Long>{
}
