package ec.edu.puce.evaluacion.service;

import ec.edu.puce.evaluacion.model.Vuelo;
import ec.edu.puce.evaluacion.repository.VueloRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VueloService {

    private final VueloRepository vueloRepository;

    public VueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    // TRAER TODOS
    public List<Vuelo> traerTodos() {
        return vueloRepository.findAll();
    }

    // GUARDAR
    public Vuelo guardar(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }

    // CASO ESPECIAL NRO 3: LISTAR VUELOS HACIA UN DESTINO
    public List<Vuelo> buscarPorDestino(String ciudad) {
        List<Vuelo> vuelos = vueloRepository.findAll();
        List<Vuelo> vuelosDestino = new ArrayList<>();

        for (Vuelo vuelo : vuelos) {
            if (vuelo.getDestino() != null && vuelo.getDestino().equalsIgnoreCase(ciudad)) {
                vuelosDestino.add(vuelo);
            }
        }

        return vuelosDestino;
    }
}
