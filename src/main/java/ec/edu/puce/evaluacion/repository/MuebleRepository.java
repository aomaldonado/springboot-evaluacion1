package ec.edu.puce.evaluacion.repository;

import ec.edu.puce.evaluacion.model.Mueble;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuebleRepository extends JpaRepository<Mueble, Integer> {
}
