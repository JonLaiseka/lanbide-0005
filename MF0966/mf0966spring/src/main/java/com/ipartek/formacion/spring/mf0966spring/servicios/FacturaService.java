package com.ipartek.formacion.spring.mf0966spring.servicios;

import com.ipartek.formacion.spring.mf0966spring.entidades.Cliente;
import com.ipartek.formacion.spring.mf0966spring.entidades.Factura;
import com.ipartek.formacion.spring.mf0966spring.entidades.Pedido;

public interface FacturaService {
	Factura obtenerFactura(Pedido pedido, Cliente cliente);
	String obtenerCodigoNuevo(int anno);
	Factura guardarFactura(Factura factura);
	Factura obtenerFacturaPorCodigo(String codigo);
}
