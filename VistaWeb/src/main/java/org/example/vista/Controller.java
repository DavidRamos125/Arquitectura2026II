package org.example.vista;

import com.universidad.app.dto.CursoInscritoDTO;
import com.universidad.app.service.CursoInscritoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cursos")
public class CursoInscritoController {

    private final CursoInscritoService service;

    public CursoInscritoController(
            CursoInscritoService service) {

        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {

        model.addAttribute(
                "cursos",
                service.listar()
        );

        return "cursos/lista";
    }


    // ==========================================
    // FORMULARIO NUEVO
    // GET /cursos/nuevo
    // ==========================================

    @GetMapping("/nuevo")
    public String nuevo(Model model) {

        model.addAttribute(
                "curso",
                new CursoInscritoDTO()
        );

        return "cursos/formulario";
    }


    // ==========================================
    // GUARDAR
    // POST /cursos/guardar
    // ==========================================

    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute("curso")
            CursoInscritoDTO curso) {

        service.guardar(curso);

        return "redirect:/cursos";
    }


    // ==========================================
    // DETALLE
    // GET /cursos/detalle
    // ==========================================

    @GetMapping("/detalle")
    public String detalle(
            @RequestParam String estudiante,
            @RequestParam String materia,
            Model model) {

        CursoInscritoDTO curso =
                service.buscar(estudiante, materia);

        if (curso == null) {
            return "redirect:/cursos";
        }

        model.addAttribute("curso", curso);

        return "cursos/detalle";
    }


    // ==========================================
    // EDITAR
    // GET /cursos/editar
    // ==========================================

    @GetMapping("/editar")
    public String editar(
            @RequestParam String estudiante,
            @RequestParam String materia,
            Model model) {

        CursoInscritoDTO curso =
                service.buscar(estudiante, materia);

        if (curso == null) {
            return "redirect:/cursos";
        }

        model.addAttribute("curso", curso);

        // Guardamos los valores originales
        model.addAttribute(
                "estudianteOriginal",
                estudiante
        );

        model.addAttribute(
                "materiaOriginal",
                materia
        );

        return "cursos/formulario";
    }

    @PostMapping("/actualizar")
    public String actualizar(

            @RequestParam String estudianteOriginal,

            @RequestParam String materiaOriginal,

            @ModelAttribute("curso")
            CursoInscritoDTO curso) {

        service.actualizar(
                estudianteOriginal,
                materiaOriginal,
                curso
        );

        return "redirect:/cursos";
    }

    @GetMapping("/eliminar")
    public String eliminar(

            @RequestParam String estudiante,

            @RequestParam String materia) {

        service.eliminar(
                estudiante,
                materia
        );

        return "redirect:/cursos";
    }
}