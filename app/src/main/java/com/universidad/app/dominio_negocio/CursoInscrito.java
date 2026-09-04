package com.universidad.app.dominio_negocio;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CursoInscrito {
    private Docente docente;
    private Estudiante estudiante;
    private Materia materia;
    private BigDecimal nota;

    public CursoInscrito(Docente docente, Estudiante estudiante, Materia materia, BigDecimal nota) {
        this.docente = docente;
        this.estudiante = estudiante;
        this.materia = materia;
        this.nota = nota;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public Docente getDocente() {
        return docente;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public BigDecimal getNota() {
        return nota;
    }
}
