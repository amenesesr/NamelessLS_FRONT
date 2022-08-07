package co.edu.unbosque.nameless;

public class Ventas {
	
	private long codigo_ventas;
	private long cedula_clientes;
	private long cedula_usuarios;
	private double ivaventa_ventas;
	private double total_venta_ventas;
	private double valor_venta_ventas;
	
	public long getCodigo_ventas() {
		return codigo_ventas;
	}
	
	public void setCodigo_ventas(long codigo_ventas) {
		this.codigo_ventas = codigo_ventas;
	}
	
	public long getCedula_clientes() {
		return cedula_clientes;
	}
	
	public void setCedula_clientes(long cedula_clientes) {
		this.cedula_clientes = cedula_clientes;
	}
	
	public long getCedula_usuarios() {
		return cedula_usuarios;
	}
	
	public void setCedula_usuarios(long cedula_usuarios) {
		this.cedula_usuarios = cedula_usuarios;
	}
	
	public double getIvaventa_ventas() {
		return ivaventa_ventas;
	}
	
	public void setIvaventa_ventas(double ivaventa_ventas) {
		this.ivaventa_ventas = ivaventa_ventas;
	}
	
	public double getTotal_venta_ventas() {
		return total_venta_ventas;
	}
	
	public void setTotal_venta_ventas(double total_venta_ventas) {
		this.total_venta_ventas = total_venta_ventas;
	}
	
	public double getValor_venta_ventas() {
		return valor_venta_ventas;
	}
	
	public void setValor_venta_ventas(double valor_venta_ventas) {
		this.valor_venta_ventas = valor_venta_ventas;
	}
	
}
