package ec.edu.puce.evaluacion.repository;

import ec.edu.puce.evaluacion.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueloRepository extends JpaRepository<Vuelo, Integer> {
}
