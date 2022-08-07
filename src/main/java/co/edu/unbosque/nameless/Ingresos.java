package co.edu.unbosque.nameless;

public class Ingresos {
	
	private long sesion_ingresos;
	private String usuario_usuarios;
	private long cedula_usuarios;
	private String fecha_hora_ingresos;
	
	public long getSesion_ingresos() {
		return sesion_ingresos;
	}
	
	public void setSesion_ingresos(long sesion_ingresos) {
		this.sesion_ingresos = sesion_ingresos;
	}
	
	public String getUsuario_usuarios() {
		return usuario_usuarios;
	}
	
	public void setUsuario_usuarios(String usuario_usuarios) {
		this.usuario_usuarios = usuario_usuarios;
	}
	
	public long getCedula_usuarios() {
		return cedula_usuarios;
	}
	
	public void setCedula_usuarios(long cedula_usuarios) {
		this.cedula_usuarios = cedula_usuarios;
	}
	
	public String getFecha_hora_ingresos() {
		return fecha_hora_ingresos;
	}
	
	public void setFecha_hora_ingresos(String fecha_hora_ingresos) {
		this.fecha_hora_ingresos = fecha_hora_ingresos;
	}

}
