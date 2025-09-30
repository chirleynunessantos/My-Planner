package br.com.myplanney.core.habitos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.myplanney.core.habitos.model.Habitos;
@Repository
public interface HabitoRepository extends JpaRepository<Habitos, Long> {

}
