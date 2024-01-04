/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.aplicacion.servicios.util;

import com.google.gson.Gson;

/**
 *
 * @author JhonM
 */
public class ProyectoUtil {
    
     public static <T> T mapearJsonBean(String json, Class<T> beanClass) {
        Gson gson = new Gson();
        return gson.fromJson(json, beanClass);
    }
    
}
