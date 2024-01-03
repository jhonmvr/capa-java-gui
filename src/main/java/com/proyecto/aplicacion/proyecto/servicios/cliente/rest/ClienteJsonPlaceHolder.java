/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.aplicacion.proyecto.servicios.cliente.rest;

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
public class ClienteJsonPlaceHolder {
    
    private static final String API_URL = "https://jsonplaceholder.typicode.com";
    private static final String ACCESS_MEHTOD_GET = "GET";
    private static final String ENDPOINT_POSTS = "/posts";
    
    public static String obtenerTodosPosts(){
      try {
            String apiUrl;
            apiUrl = API_URL.concat(ENDPOINT_POSTS);
            URL url = new URL(apiUrl);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

             conexion.setRequestMethod(ACCESS_MEHTOD_GET);
            BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea;
            StringBuffer respuesta = new StringBuffer();

            while ((linea = reader.readLine()) != null) {
               respuesta.append(linea);
            }
            reader.close();

            conexion.disconnect();

            return respuesta.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }   
      return null;
    }
    
    public static void main(String[] args) {
      System.out.println(ClienteJsonPlaceHolder.obtenerTodosPosts());
    }
}
