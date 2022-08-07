package co.edu.unbosque.nameless;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsuariosServlet
 */
@WebServlet("/UsuariosServlet")
public class UsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuariosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String btnConsultar = request.getParameter("btnConsultar");	
		String btnCrear = request.getParameter("btnCrear");	
		String btnActualizar = request.getParameter("btnActualizar");	
		String btnBorrar = request.getParameter("btnBorrar");
		
		
		if(btnConsultar != null)
		{
			listarUsuarios(request,response);
		}
		
		if(btnCrear != null)
		{
			crearUsuario(request,response);
		}
		
		if(btnActualizar != null)
		{
			actualizarUsuario(request,response);
		}
		
		if(btnBorrar != null)
		{	
			eliminarUsuario(request,response);
		}
		
	}
	
	public void crearUsuario(HttpServletRequest request, HttpServletResponse response) {
		
		long txtCedula = Long.parseLong(request.getParameter("txtCedula")); 
		String txtNombre = request.getParameter("txtNombre");
		String txtCorreo = request.getParameter("txtCorreo");
		String txtUsuario = request.getParameter("txtUsuario");
		String txtPassword = request.getParameter("txtPassword");
		
		if (txtNombre != "" && txtCorreo != "" && txtUsuario != "" && txtPassword != "")
		{
			Usuarios usuario = new Usuarios();
			usuario.setCedula_usuarios(txtCedula);
			usuario.setNombre_usuarios(txtNombre);
			usuario.setEmail_usuarios(txtCorreo);
			usuario.setUsuario_usuarios(txtUsuario);
			usuario.setPassword_usuarios(txtPassword);
			int respuesta = 0;
			int verificador = 0;
			
			try {
				ArrayList<Usuarios> lista = UsuariosJSON.getJSON();
				for(Usuarios usuarioverificar : lista) {
					if(usuarioverificar.getCedula_usuarios() == txtCedula) {
						verificador = 1;
						break;
					}
				}
				
				if(verificador == 0) 
				{
					respuesta = UsuariosJSON.postJSON(usuario);
					PrintWriter writer = response.getWriter();
					if (respuesta == 200)
					{
						request.getRequestDispatcher("/usuarioscrear.jsp").forward(request, response);
					}
					else 
					{
						writer.println("Error: " +  respuesta);
					}
					writer.close();
				}
				else 
				{
					request.getRequestDispatcher("/usuarioserrorcrear.jsp").forward(request, response);
				}
				
			}catch(IOException | ServletException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else
		{
			try {
				request.getRequestDispatcher("/usuarioserrorcampos.jsp").forward(request, response);
			}catch(IOException | ServletException e){
				e.printStackTrace();
			}
		}
	}
	
	public void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("txtCedula"));			
		int respuesta=0;
		int verificadorusuario = 0;
		int  verificadorventas = 0;
		
		try {
			ArrayList<Usuarios> listausuarios = UsuariosJSON.getJSON();
			for(Usuarios usuarioverificar:listausuarios) {
				if(usuarioverificar.getCedula_usuarios() == id) {
					verificadorusuario = 1;
					break;
				}
			}
			ArrayList<Ventas> listaventas = VentasJSON.getJSON();
			for(Ventas ventasverificar:listaventas) {
				if(ventasverificar.getCedula_usuarios() == id) {
					verificadorventas = 1;
					break;
				}
			}
			
			if(verificadorusuario == 0) 
			{	
				request.getRequestDispatcher("/usuarioserroreliminarnoexiste.jsp").forward(request, response);	
			}
			
			if(verificadorventas == 0) 
			{		
				respuesta = UsuariosJSON.deleteJSON(id);
				PrintWriter write = response.getWriter();
				if (respuesta==200) 
				{
					request.getRequestDispatcher("/usuarioseliminar.jsp").forward(request, response);
				}
				else 
				{
					write.println("Error: " +  respuesta);
				}
				write.close();
			}
			else 
			{
				request.getRequestDispatcher("/usuarioserroreliminarllaveforanea.jsp").forward(request, response);	
			} 
		
		
		
		
		
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) {
		
		long txtCedula = Long.parseLong(request.getParameter("txtCedula")); 
		String txtNombre = request.getParameter("txtNombre");
		String txtCorreo = request.getParameter("txtCorreo");
		String txtUsuario = request.getParameter("txtUsuario");
		String txtPassword = request.getParameter("txtPassword");
		
		if (txtNombre != "" && txtCorreo != "" && txtUsuario != "" && txtPassword != "")
		{
			Usuarios usuario = new Usuarios();
			usuario.setCedula_usuarios(txtCedula);
			usuario.setNombre_usuarios(txtNombre);
			usuario.setEmail_usuarios(txtCorreo);
			usuario.setUsuario_usuarios(txtUsuario);
			usuario.setPassword_usuarios(txtPassword);
			int respuesta=0;
			int verificador = 0;
		
			try {
				ArrayList<Usuarios> lista = UsuariosJSON.getJSON();
				for(Usuarios usuarioverificar:lista) {
					if(usuarioverificar.getCedula_usuarios() == txtCedula) {
						verificador = 1;
						break;
					}
				}
				if(verificador == 1) 
				{		
					respuesta = UsuariosJSON.putJSON(usuario,usuario.getCedula_usuarios());
					PrintWriter writer = response.getWriter();
					if (respuesta==200) {
						request.getRequestDispatcher("/usuariosactualizar.jsp").forward(request, response);
					} 
					else 
					{
						writer.println("Error: " +  respuesta);
					}
					writer.close();
				}
				else	
				{
					request.getRequestDispatcher("/usuarioserroractualizar.jsp").forward(request, response);
				}
		}catch(IOException | ServletException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	else
	{
			try {
				request.getRequestDispatcher("/usuarioserrorcampos.jsp").forward(request, response);
			}catch(IOException | ServletException e){
				e.printStackTrace();
			}
		}
	}

	
	public void listarUsuarios(HttpServletRequest request, HttpServletResponse response) {
		try {
			long txtCedula = Long.parseLong(request.getParameter("txtCedula"));
			String txtUsuario = request.getParameter("txtUsuario");
			String txtNombre = request.getParameter("txtNombre");
			String txtPassword = request.getParameter("txtPassword");
			String txtCorreo = request.getParameter("txtCorreo");
			int error = 0;
			ArrayList<Usuarios> lista = UsuariosJSON.getJSON();
			String pagina = "/usuariosconsulta.jsp";
			
			for (Usuarios usuario:lista){
				if (usuario.getCedula_usuarios() == txtCedula)
				{
					txtCedula = usuario.getCedula_usuarios();
					txtNombre = usuario.getNombre_usuarios();
					txtCorreo = usuario.getEmail_usuarios();
					txtUsuario = usuario.getUsuario_usuarios();
					txtPassword = usuario.getPassword_usuarios();
					error = 1;
					break;
				}
			}
			
			request.setAttribute("txtCedula",txtCedula);
			request.setAttribute("txtNombre",txtNombre);
			request.setAttribute("txtCorreo",txtCorreo);
			request.setAttribute("txtUsuario",txtUsuario);
			request.setAttribute("txtPassword",txtPassword);
			request.setAttribute("error",error);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
