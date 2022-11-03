package com.ipartek.formacion.mf0967.uf2218.listeners;

import com.ipartek.formacion.mf0967.uf2216.doscapas.accesodatos.DaoMemoriaProducto;
import com.ipartek.formacion.mf0967.uf2218.controladores.Globales;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class InicioServidorListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
         Globales.dao = DaoMemoriaProducto.getInstancia();
    }
	
}
