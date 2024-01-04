/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.aplicacion.servicios.cliente.rest;

import com.mycompany.segundacapacitacion.servicios.exception.CustomException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.VarHandle;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author JhonM
 */
public class ClienteTypicodeRest {
    
   private static final String URL_BASE = "https://jsonplaceholder.typicode.com";
    private static final String ENDPOINT_POST = "/posts";
    private static final String METHOD_URL = "GET";
    
    /**
     * 
     * @return 
     */
    public static String devolverTodosPost(){
        try {
             String apiUrl;
             apiUrl = URL_BASE.concat(ENDPOINT_POST);
             URL url = new URL(apiUrl);
             HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

            // Establecer el método de solicitud como GET
            conexion.setRequestMethod(METHOD_URL);

            // Leer la respuesta del API
             BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea;
            StringBuffer respuesta = new StringBuffer();

            while ((linea = reader.readLine()) != null) {
                respuesta.append(linea);
            }
            reader.close();

            // Cerrar la conexión
            conexion.disconnect();
            
            return respuesta.toString();

        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        return null;
    }
    
    public static String devolverPostPorId(String id) throws CustomException{
        
        try {
             String apiUrl;
             apiUrl = URL_BASE.concat(ENDPOINT_POST).concat("/" + id);
             URL url = new URL(apiUrl);
             HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

            // Establecer el método de solicitud como GET
            conexion.setRequestMethod(METHOD_URL);

            // Leer la respuesta del API
             BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            int codigoRespuesta = conexion.getResponseCode();
            if(codigoRespuesta >=300 && codigoRespuesta<400){
             throw new CustomException("Error al consumir el servicio rest", "400");    
            }
            if(codigoRespuesta >=400 && codigoRespuesta<500){
             throw new CustomException("Error al consumir el servicio rest", "400");   
            }
            if(codigoRespuesta >=500){
             throw new CustomException("Error al consumir el servicio rest", "400");   
            }
            String linea;
            StringBuffer respuesta = new StringBuffer();

            while ((linea = reader.readLine()) != null) {
                respuesta.append(linea);
            }
            reader.close();

            // Cerrar la conexión
            conexion.disconnect();

            return respuesta.toString();  
            

        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomException("Error al consumir el servicio rest", "400");
        } 
        
        
    }
    public static String devolverComentariosIdPost(String id, String comments){
        
        try {
             String apiUrl;
             apiUrl = URL_BASE.concat(ENDPOINT_POST).concat("/" + id + "/" + comments);
             URL url = new URL(apiUrl);
             HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

            // Establecer el método de solicitud como GET
            conexion.setRequestMethod(METHOD_URL);

            // Leer la respuesta del API
             BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea;
            StringBuffer respuesta = new StringBuffer();

            while ((linea = reader.readLine()) != null) {
                respuesta.append(linea);
            }
            reader.close();

            // Cerrar la conexión
            conexion.disconnect();
            
            return respuesta.toString();

        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        return null;
    }
}
