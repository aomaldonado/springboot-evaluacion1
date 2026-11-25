package ec.edu.puce.evaluacion.repository;

import ec.edu.puce.evaluacion.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
}
