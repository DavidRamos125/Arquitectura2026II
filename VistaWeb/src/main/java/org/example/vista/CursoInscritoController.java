package org.example.vista;

import com.universidad.app.controlador_servicio.CursoInscritoControler;
import com.universidad.app.dto.CursoInscritoDTO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cursos")
public class CursoInscritoController {

    private final CursoInscritoControler controlador;

    public CursoInscritoController() {
        this.controlador = new CursoInscritoControler();
    }
    @GetMapping
    public String listar(Model model) {

        model.addAttribute(
                "cursos",
                controlador.get()
        );

        return "cursos/lista";
    }
}

