package com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.controllers;

import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.Alquiler;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.Vehiculo;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.repositories.AlquilerRepository;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.repositories.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alquileres")
public class AlquilerController {
    @Autowired
    private final AlquilerRepository alquilerRepository;
    public AlquilerController(AlquilerRepository alquilerRepository) {
        this.alquilerRepository = alquilerRepository;
    }

    @GetMapping({"", "/"})
    public String listarAlquileres(Model model) {
        List<Alquiler> listaAlquileres = alquilerRepository.findAll();
        model.addAttribute("paginaActiva", "alquileres"); // Agrega el nombre de la página activa
        model.addAttribute("listaClientes", listaAlquileres);
        return "alquileres";
    }

    @PostMapping("/")
    @ResponseBody
    public Alquiler crearAlquiler(@RequestBody Alquiler alquiler) {
        return alquilerRepository.save(alquiler);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Alquiler obtenerAlquiler(@PathVariable String id) {
        return alquilerRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Alquiler actualizarAlquiler(@PathVariable String id, @RequestBody Alquiler alquiler) {
        alquiler.setAlquilerId(id);
        return alquilerRepository.save(alquiler);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void eliminarAlquiler(@PathVariable String id) {
        alquilerRepository.deleteById(id);
    }
}

