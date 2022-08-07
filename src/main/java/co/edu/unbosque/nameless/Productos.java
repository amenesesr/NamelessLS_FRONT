package co.edu.unbosque.nameless;

public class Productos {

	private long codigo_productos;
	private double ivacompra_productos;
	private long nitproveedor_proveedores;
	private String nombre_productos;
	private double precio_compra_productos;
	private double precio_venta_productos;
	
	public Productos() {
		super();
	}
	
	public Productos(long codigo_productos, double ivacompra_productos, long nitproveedor_proveedores, String nombre_productos,
			double precio_compra_productos, double precio_venta_productos) {
		super();
		this.codigo_productos = codigo_productos;
		this.ivacompra_productos = ivacompra_productos;
		this.nitproveedor_proveedores = nitproveedor_proveedores;
		this.nombre_productos = nombre_productos;
		this.precio_compra_productos = precio_compra_productos;
		this.precio_venta_productos = precio_venta_productos;
	}

	public long getCodigo_productos() {
		return codigo_productos;
	}
	
	public void setCodigo_productos(long codigo_productos) {
		this.codigo_productos = codigo_productos;
	}
	
	public double getIvacompra_productos() {
		return ivacompra_productos;
	}
	
	public void setIvacompra_productos(double ivacompra_productos) {
		this.ivacompra_productos = ivacompra_productos;
	}
	
	public long getNitproveedor_proveedores() {
		return nitproveedor_proveedores;
	}
	
	public void setNitproveedor_proveedores(long nitproveedor_proveedores) {
		this.nitproveedor_proveedores = nitproveedor_proveedores;
	}
	
	public String getNombre_productos() {
		return nombre_productos;
	}
	
	public void setNombre_productos(String nombre_productos) {
		this.nombre_productos = nombre_productos;
	}
	
	public double getPrecio_compra_productos() {
		return precio_compra_productos;
	}
	
	public void setPrecio_compra_productos(double precio_compra_productos) {
		this.precio_compra_productos = precio_compra_productos;
	}
	
	public double getPrecio_venta_productos() {
		return precio_venta_productos;
	}
	
	public void setPrecio_venta_productos(double precio_venta_productos) {
		this.precio_venta_productos = precio_venta_productos;
	}
	
}
