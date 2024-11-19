package lopezPezo.MsLanders.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="alumno")

public class AlumnoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer idAlumno;

    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 1, max = 100, message = "El nombre debe tener entre 1 y 100 caracteres")
    @Column(name = "nombre", length = 100, nullable = false)
    public String nombre;

    @NotNull(message = "La nota no puede ser nula")
    @DecimalMin(value = "0.00", message = "La nota debe ser mayor o igual a 0")
    @DecimalMax(value = "10.00", message = "La nota debe ser menor o igual a 10")
    @Digits(integer = 3, fraction = 2, message = "La nota debe tener un formato válido con hasta 3 dígitos enteros y 2 decimales")
    @Column(name = "nota" , precision = 5 , scale = 2, nullable = false)
    public BigDecimal nota;

}
