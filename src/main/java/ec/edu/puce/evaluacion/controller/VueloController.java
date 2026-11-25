package ec.edu.puce.evaluacion.controller;

import ec.edu.puce.evaluacion.model.Vuelo;
import ec.edu.puce.evaluacion.service.VueloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {

    private final VueloService vueloService;

    public VueloController(VueloService vueloService) {

        this.vueloService = vueloService;
    }

    // LISTAR TODOS
    @GetMapping
    public List<Vuelo> listarTodos() {

        return vueloService.traerTodos();
    }

    // REGISTRAR
    @PostMapping
    public ResponseEntity<Vuelo> registrar(@RequestBody Vuelo vuelo) {
        Vuelo nuevoVuelo = vueloService.guardar(vuelo);
        return new ResponseEntity<>(nuevoVuelo, HttpStatus.CREATED);
    }

    // CASO ESPECIAL NRO 3: LISTAR VUELOS HACIA UN DESTINO
    @GetMapping("/destino")
    public List<Vuelo> buscarPorDestino(@RequestParam String ciudad) {

        return vueloService.buscarPorDestino(ciudad);
    }
}
