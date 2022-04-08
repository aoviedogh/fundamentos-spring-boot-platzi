package com.fundamentosplatzi.springboot.fundamentos.dto;

import java.time.LocalDate;

public class UserDto {
    private Long id;
    private String nombre;
    private LocalDate cumpleanos;

    public UserDto(Long id, String nombre, LocalDate cumpleanos) {
        this.id = id;
        this.nombre = nombre;
        this.cumpleanos = cumpleanos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getCumpleanos() {
        return cumpleanos;
    }

    public void setCumpleanos(LocalDate cumpleanos) {
        this.cumpleanos = cumpleanos;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cumpleanos='" + cumpleanos + '\'' +
                '}';
    }
}
