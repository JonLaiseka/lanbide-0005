package com.ipartek.formacion.mf0966ejemplo.controladores;

import com.ipartek.formacion.mf0966ejemplo.accesodatos.Dao;
import com.ipartek.formacion.mf0966ejemplo.accesodatos.DaoMySqlUsuarios;
import com.ipartek.formacion.mf0966ejemplo.modelos.Usuario;

public class Globales {
	public static final Dao<Usuario> DAO_USUARIOS = DaoMySqlUsuarios.getInstancia();
}
