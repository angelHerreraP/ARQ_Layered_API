package com.exampleLayered.demoLayered.model;
import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.*;


@Table(name="modulos")
@Entity
@Getter
@Setter
@NoArgsConstructor //genera un constructor vacio
@AllArgsConstructor //genera un consturctor con tokio y kawazaki
@Builder //a la hora de construir te ahorra lineas de codigo
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Nivel nivel;

    private int orden;

    @Column(nullable = false)
    private boolean visible = true;





}


/*


Mi DB its like thisssssss
* CREATE TABLE modulos (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descripcion TEXT,
    nivel VARCHAR(20) CHECK (nivel IN ('Básico', 'Intermedio', 'Avanzado')),
    orden INT,
    visible BOOLEAN DEFAULT TRUE
);
*
* */