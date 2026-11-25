package ec.edu.puce.evaluacion.controller;

import ec.edu.puce.evaluacion.model.Mueble;
import ec.edu.puce.evaluacion.service.MuebleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/muebles")
public class MuebleController {

    private final MuebleService muebleService;

    public MuebleController(MuebleService muebleService) {

        this.muebleService = muebleService;
    }

    // LISTAR TODOS
    @GetMapping
    public List<Mueble> listarTodos() {

        return muebleService.traerMuebles();
    }

    // REGISTRAR
    @PostMapping
    public ResponseEntity<Mueble> registrar(@RequestBody Mueble mueble) {
        Mueble nuevoMueble = muebleService.guardar(mueble);
        return new ResponseEntity<>(nuevoMueble, HttpStatus.CREATED);
    }

    // CASO ESPECIAL NRO 2: LISTAR MUEBLES CON PRECIO DENTRO DE UN RANGO
    @GetMapping("/precio")
    public List<Mueble> buscarPorRangoPrecio(@RequestParam double min, @RequestParam double max) {
        return muebleService.buscarPorRangoPrecio(min, max);
    }
}
