package com.ipartek.formacion.mf0966ejemplo.listeners;

import com.ipartek.formacion.mf0966ejemplo.modelos.Pedido;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;


@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se)  { 
         se.getSession().setAttribute("carrito", new Pedido());
    }
	
}
