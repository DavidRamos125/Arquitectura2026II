package com.universidad.app.dto;

import com.universidad.app.dominio_negocio.CursoInscrito;
import java.math.BigDecimal;

public class CursoInscritoDTO {
    private DocenteDTO docente;
    private EstudianteDTO estudiante;
    private MateriaDTO materia;
    private BigDecimal nota;

    public CursoInscritoDTO() {
        this.docente = new DocenteDTO();
        this.estudiante = new EstudianteDTO();
        this.materia = new MateriaDTO();
    }

    public CursoInscritoDTO(
            DocenteDTO docente,
            EstudianteDTO estudiante,
            MateriaDTO materia,
            BigDecimal nota) {
        this.docente = docente;
        this.estudiante = estudiante;
        this.materia = materia;
        this.nota = nota;
    }

    public DocenteDTO getDocente() {
        return docente;
    }

    public void setDocente(DocenteDTO docente) {
        this.docente = docente;
    }

    public EstudianteDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDTO estudiante) {
        this.estudiante = estudiante;
    }

    public MateriaDTO getMateria() {
        return materia;
    }

    public void setMateria(MateriaDTO materia) {
        this.materia = materia;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public static CursoInscritoDTO toDTO(CursoInscrito cursoInscrito) {
        if (cursoInscrito == null) {
            return null;
        }

        return new CursoInscritoDTO(
                DocenteDTO.toDTO(cursoInscrito.getDocente()),
                EstudianteDTO.toDTO(cursoInscrito.getEstudiante()),
                MateriaDTO.toDTO(cursoInscrito.getMateria()),
                cursoInscrito.getNota()
        );
    }

    public static CursoInscrito fromDTO(CursoInscritoDTO dto) {
        if (dto == null) {
            return null;
        }

        return new CursoInscrito(
                DocenteDTO.fromDTO(dto.getDocente()),
                EstudianteDTO.fromDTO(dto.getEstudiante()),
                MateriaDTO.fromDTO(dto.getMateria()),
                dto.getNota()
        );
    }
}