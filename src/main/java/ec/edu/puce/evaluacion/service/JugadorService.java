package ec.edu.puce.evaluacion.service;

import ec.edu.puce.evaluacion.model.Jugador;
import ec.edu.puce.evaluacion.repository.JugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    private final JugadorRepository jugadorRepository;

    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    // TRAER TODOS
    public List<Jugador> traerTodos() {
        return jugadorRepository.findAll();
    }

    // TRAER UNO POR ID
    public Optional<Jugador> traerUno(int id) {
        return jugadorRepository.findById(id);
    }

    // GUARDAR
    public Jugador guardar(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    // ACTUALIZAR
    public Optional<Jugador> actualizar(int id, Jugador jugadorActualizado) {
        return jugadorRepository.findById(id).map(jugador -> {
            jugador.setNombre(jugadorActualizado.getNombre());
            jugador.setEquipo(jugadorActualizado.getEquipo());
            jugador.setPosicion(jugadorActualizado.getPosicion());
            jugador.setEdad(jugadorActualizado.getEdad());
            jugador.setGoles(jugadorActualizado.getGoles());
            return jugadorRepository.save(jugador);
        });
    }

    // ELIMINAR
    public boolean eliminar(int id) {
        if (jugadorRepository.existsById(id)) {
            jugadorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // CASO ESPECIAL NRO 1: TOTAL DE GOLES DE TODOS LOS JUGADORES
    public int obtenerTotalGoles() {
        List<Jugador> jugadores = jugadorRepository.findAll();
        int totalGoles = 0;

        for (Jugador jugador : jugadores) {
            totalGoles += jugador.getGoles();
        }

        return totalGoles;
    }
}
