package com.exampleLayered.demoLayered.model;
import java.util.*;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Table(name ="usuarios")//Define el nombre de tu tabla
@Entity //lo considera una entidad (eso si es considerarlo una tabla)
@Getter // ahorra escribir
@Setter// ahorra escribir
@NoArgsConstructor //genera un constructor vacio
@AllArgsConstructor //genera un consturctor con tokio y kawazaki
@Builder //a la hora de construir te ahorra lineas de codigo
public class Usuario {


    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(length=100, nullable = false)
    private String nombre;

    @Column(length=150, nullable = false, unique = true)
    private String email;

    @Column(name="password_hash", nullable = false)
    private String passwordHash;

    @Column(length=20, nullable = false)
    @Enumerated(EnumType.STRING)
    private Rol rol = Rol.VENDEDOR;

    @Column(name="fecha_registro", nullable = false, updatable = false)
    private  LocalDateTime fechaRegistro = LocalDateTime.now();

    @Column(nullable = false)
    private boolean activo = true;





///modifica este enum para tener mas ROLE
/// - ADMIN, generales
/// - VENDEDOR, solo ventas y visualizacion de inventarios
/// - INGRESOS, edit del INVENTARIO, pero trackeado
    public enum Rol{
        ADMIN, VENDEDOR, INGRESOS
    }

// Metodo para cambiar de Rol
    //este puede ir aqui, porque SOLO cambia el valor de la variable, la logica de los permisos y demas va en otro lado:
    public void ChanceRole(Rol nuevoRol){
        if(nuevoRol != null){
            this.rol = nuevoRol;
        }
    }


}
