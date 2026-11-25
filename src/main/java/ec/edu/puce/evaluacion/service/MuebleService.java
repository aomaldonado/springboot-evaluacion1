package ec.edu.puce.evaluacion.service;

import ec.edu.puce.evaluacion.model.Mueble;
import ec.edu.puce.evaluacion.repository.MuebleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MuebleService {

    private final MuebleRepository muebleRepository;

    public MuebleService(MuebleRepository muebleRepository) {
        this.muebleRepository = muebleRepository;
    }

    // TRAER TODOS
    public List<Mueble> traerMuebles() {
        return muebleRepository.findAll();
    }

    // GUARDAR
    public Mueble guardar(Mueble mueble) {
        return muebleRepository.save(mueble);
    }

    // CASO ESPECIAL NRO 2: LISTAR MUEBLES CON PRECIO DENTRO DE UN RANGO
    public List<Mueble> buscarPorRangoPrecio(double min, double max) {
        List<Mueble> muebles = muebleRepository.findAll();
        List<Mueble> mueblesEnRango = new ArrayList<>();

        for (Mueble mueble : muebles) {
            if (mueble.getPrecio() >= min && mueble.getPrecio() <= max) {
                mueblesEnRango.add(mueble);
            }
        }

        return mueblesEnRango;
    }
}
