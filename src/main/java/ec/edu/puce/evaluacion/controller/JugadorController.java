package ec.edu.puce.evaluacion.controller;

import ec.edu.puce.evaluacion.model.Jugador;
import ec.edu.puce.evaluacion.service.JugadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {

        this.jugadorService = jugadorService;
    }

    // LISTAR TODOS
    @GetMapping
    public List<Jugador> listarTodos() {
        return jugadorService.traerTodos();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Jugador> buscarPorId(@PathVariable int id) {
        return jugadorService.traerUno(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // CREAR
    @PostMapping
    public ResponseEntity<Jugador> crear(@RequestBody Jugador jugador) {
        Jugador nuevoJugador = jugadorService.guardar(jugador);
        return new ResponseEntity<>(nuevoJugador, HttpStatus.CREATED);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Jugador> actualizar(@PathVariable int id, @RequestBody Jugador jugador) {
        return jugadorService.actualizar(id, jugador)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        if (jugadorService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // CASO ESPECIAL NRO 1: TOTAL DE GOLES DE TODOS LOS JUGADORES
    @GetMapping("/goles")
    public ResponseEntity<Integer> obtenerTotalGoles() {

        return ResponseEntity.ok(jugadorService.obtenerTotalGoles());
    }
}
