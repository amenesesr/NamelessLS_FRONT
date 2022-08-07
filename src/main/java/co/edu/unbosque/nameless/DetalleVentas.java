package co.edu.unbosque.nameless;

public class DetalleVentas {
	
	private long codigo_detalle_venta;
	private int cantidad_producto_detalle_venta;
	private long codigo_productos;
	private long codigo_ventas;
	private double valor_total_detalle_venta;
	private double valor_venta_detalle_venta;
	private double valoriva_detalle_venta;
	
	public long getCodigo_detalle_venta() {
		return codigo_detalle_venta;
	}
	
	public void setCodigo_detalle_venta(long codigo_detalle_venta) {
		this.codigo_detalle_venta = codigo_detalle_venta;
	}
	
	public int getCantidad_producto_detalle_venta() {
		return cantidad_producto_detalle_venta;
	}
	
	public void setCantidad_producto_detalle_venta(int cantidad_producto_detalle_venta) {
		this.cantidad_producto_detalle_venta = cantidad_producto_detalle_venta;
	}
	
	public long getCodigo_productos() {
		return codigo_productos;
	}
	
	public void setCodigo_productos(long codigo_productos) {
		this.codigo_productos = codigo_productos;
	}
	
	public long getCodigo_ventas() {
		return codigo_ventas;
	}
	
	public void setCodigo_ventas(long codigo_ventas) {
		this.codigo_ventas = codigo_ventas;
	}
	
	public double getValor_total_detalle_venta() {
		return valor_total_detalle_venta;
	}
	
	public void setValor_total_detalle_venta(double valor_total_detalle_venta) {
		this.valor_total_detalle_venta = valor_total_detalle_venta;
	}
	
	public double getValor_venta_detalle_venta() {
		return valor_venta_detalle_venta;
	}
	
	public void setValor_venta_detalle_venta(double valor_venta_detalle_venta) {
		this.valor_venta_detalle_venta = valor_venta_detalle_venta;
	}
	
	public double getValoriva_detalle_venta() {
		return valoriva_detalle_venta;
	}
	
	public void setValoriva_detalle_venta(double valoriva_detalle_venta) {
		this.valoriva_detalle_venta = valoriva_detalle_venta;
	}	
}
