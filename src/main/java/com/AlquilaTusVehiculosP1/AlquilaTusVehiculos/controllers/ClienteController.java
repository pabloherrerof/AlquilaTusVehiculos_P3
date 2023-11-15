package com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.controllers;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models.Cliente;
import com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private final ClienteRepository clienteRepository;
    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    @GetMapping({"", "/"})
    public String listarClientes(Model model) {
        List<Cliente> listaClientes = clienteRepository.findAll();
        model.addAttribute("paginaActiva", "clientes"); // Agrega el nombre de la página activa
        model.addAttribute("listaClientes", listaClientes);
        return "clientes";
    }

    @PostMapping("/")
    @ResponseBody
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Cliente obtenerCliente(@PathVariable String id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Cliente actualizarCliente(@PathVariable String id, @RequestBody Cliente cliente) {
        cliente.setClienteId(id);
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void eliminarCliente(@PathVariable String id) {
        clienteRepository.deleteById(id);
    }
}
