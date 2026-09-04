package com.universidad.app.vistaConsola;

import com.universidad.app.controlador_servicio.*;

public class VistaConsola {
    DocenteControlador docenteControlador;
    EstudianteControlador estudianteControlador;
    MateriaControlador materiaControlador;
    CursoInscritoControler cursoInscritoControler;

    public VistaConsola() {
        this.docenteControlador = new DocenteControlador();
        this.estudianteControlador = new EstudianteControlador();
        this.materiaControlador = new MateriaControlador();
        this.cursoInscritoControler = new CursoInscritoControler();
    }

    private void getDocentes(){
        System.out.println();
        System.out.println(docenteControlador.get());
    };

    private void getEstidiantes(){
        System.out.println();
        System.out.println(estudianteControlador.get());
    };

    private void getMaterias(){
        System.out.println();
        System.out.println(materiaControlador.get());
    };

    private void getCursosInscritos(){
        System.out.println();
        cursoInscritoControler.get().forEach(
                c -> System.out.println(c.getDocente().getNombre() + " " + c.getDocente().getIdentificacion() + " " + c.getEstudiante().getNombre() + " " + c.getMateria().getNombre() + " " + c.getNota().toString())
        );
    };

    public void start(){
        getMaterias();
        getCursosInscritos();
        getDocentes();
        getEstidiantes();
    }
}
