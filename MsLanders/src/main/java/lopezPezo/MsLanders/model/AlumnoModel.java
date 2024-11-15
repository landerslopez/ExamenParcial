package lopezPezo.MsLanders.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="alumno")

public class AlumnoModel {
    @Id
    @Column(name = "id")
    public Integer idAlumno;

    @Column(name = "nombre")
    public String nombre;

    @Column(name = "nota" , precision = 3 , scale = 2)
    public BigDecimal nota;

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }
    
}
