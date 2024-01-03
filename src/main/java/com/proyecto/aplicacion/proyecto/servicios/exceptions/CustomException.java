/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.aplicacion.proyecto.servicios.exceptions;

/**
 *
 * @author JhonM
 */
public class CustomException extends Exception{
    private String mensaje;
    private String codigo;

    public CustomException(String mensaje, String codigo) {
        super(mensaje);
        this.mensaje = mensaje;
        this.codigo = codigo;
    }
    
    
    
}
