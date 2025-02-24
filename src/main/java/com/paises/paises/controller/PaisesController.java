package com.paises.paises.controller;

import com.paises.paises.domain.Paises;
import com.paises.paises.service.PaisesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/paises")
public class PaisesController {
    
    @Autowired
    private PaisesService paisesService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var paises = paisesService.getPaises();
        model.addAttribute("paises", paises);
        model.addAttribute("totalPaises", paises.size());
        return "/paises/listado";
    }
    
    @GetMapping("/nuevo")
    public String paisesNuevo(Paises pais) {
        return "/paises/modifica";
    }

    @PostMapping("/guardar")
    public String guardar(Paises pais) {        
        paisesService.save(pais);
        return "redirect:/paises/listado";
    }

    @GetMapping("/eliminar/{idPais}")
    public String eliminar(Paises pais) {
        paisesService.delete(pais);
        return "redirect:/paises/listado";
    }

    @GetMapping("/modificar/{idPais}")
    public String modificar(Paises pais, Model model) {
        pais = paisesService.getPais(pais);
        model.addAttribute("pais", pais);
        return "/paises/modifica";
    }
}
