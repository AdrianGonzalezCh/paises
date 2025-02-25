package com.paises.paises.controller;

import com.paises.paises.domain.Paises;
import com.paises.paises.service.PaisesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/pais")  // Asegurar que coincida con la URL base
public class PaisesController {

    private final PaisesService paisesService;

    public PaisesController(PaisesService paisesService) {
        this.paisesService = paisesService;
    }

    @GetMapping("/listado")
public String listarPaises(Model model) {
    var paises = paisesService.getPaises();
    model.addAttribute("paises", paises);
    model.addAttribute("totalPaises", paises.size());
    // Agregar un objeto 'pais' vacío para el formulario del modal
    model.addAttribute("pais", new Paises());
    return "pais/listado";
}
    @GetMapping("/nuevo")
    public String nuevoPais(Model model) {
        model.addAttribute("pais", new Paises());
        return "pais/formulario";  // Vista para crear un nuevo país
    }

    @PostMapping("/guardar")
    public String guardarPais(@ModelAttribute Paises pais) {
        paisesService.save(pais);
        return "redirect:/pais/listado";
    }

    @GetMapping("/eliminar/{idPais}")
    public String eliminarPais(@PathVariable("idPais") Integer idPais) {
        Paises pais = new Paises();
        pais.setIdPais(idPais);
        paisesService.delete(pais);
        return "redirect:/pais/listado";
    }

    @GetMapping("/editar/{idPais}")
    public String editarPais(@PathVariable("idPais") Integer idPais, Model model) {
        Paises pais = new Paises();
        pais.setIdPais(idPais);
        pais = paisesService.getPais(pais);
        model.addAttribute("pais", pais);
        return "pais/formulario";  // Vista para editar un país existente
    }
}
