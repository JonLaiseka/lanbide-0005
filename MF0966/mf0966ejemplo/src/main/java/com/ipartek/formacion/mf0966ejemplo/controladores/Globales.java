package com.ipartek.formacion.mf0966ejemplo.controladores;

import com.ipartek.formacion.mf0966ejemplo.accesodatos.Dao;
import com.ipartek.formacion.mf0966ejemplo.accesodatos.DaoMySqlCategoria;
import com.ipartek.formacion.mf0966ejemplo.accesodatos.DaoMySqlProducto;
import com.ipartek.formacion.mf0966ejemplo.accesodatos.DaoMySqlUsuarios;
import com.ipartek.formacion.mf0966ejemplo.modelos.Categoria;
import com.ipartek.formacion.mf0966ejemplo.modelos.Producto;
import com.ipartek.formacion.mf0966ejemplo.modelos.Usuario;

public class Globales {
	private Globales() {
	}
	
	public static final Dao<Usuario> DAO_USUARIOS = DaoMySqlUsuarios.getInstancia();
	public static final Dao<Producto> DAO_PRODUCTO = DaoMySqlProducto.getInstancia();
	public static final Dao<Categoria> DAO_CATEGORIA = DaoMySqlCategoria.getInstancia();
}
