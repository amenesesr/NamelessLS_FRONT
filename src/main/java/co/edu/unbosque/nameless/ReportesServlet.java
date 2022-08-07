package co.edu.unbosque.nameless;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReportesServlet
 */
@WebServlet("/ReportesServlet")
public class ReportesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String btnListadoUsuarios = request.getParameter("btnListadoUsuarios");
		String btnListadoClientes = request.getParameter("btnListadoClientes");
		String btnlistadoProveedores= request.getParameter("btnlistadoProveedores");
		String btnlistadoProductos = request.getParameter("btnlistadoProductos");
		String btnVentasCliente = request.getParameter("btnVentasCliente");
		String btnVentas = request.getParameter("btnVentas");
		

		if (btnListadoUsuarios != null) {
			listarUsuarios(request,response);
		}
		
		if (btnListadoClientes != null) {
			listarClientes(request,response);
		}
		
		if (btnlistadoProveedores != null) 
		{
			listarProveedores(request,response);
		}

		if (btnlistadoProductos != null) 
		{
			listarProductos(request,response);
		}
		
		if (btnVentasCliente != null)
		{
			listarVentasCliente(request,response);
		}
		
		if (btnVentas != null)
		{
			listarVentas(request,response);
		}
		
	}
	
	public void listarUsuarios(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Usuarios> lista = UsuariosJSON.getJSON();
			String pagina = "/listadousuarios.jsp";
			request.setAttribute("lista",lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listarClientes(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Clientes> lista = ClientesJSON.getJSON();
			String pagina = "/listadoclientes.jsp";
			request.setAttribute("lista",lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listarProveedores(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Proveedores> lista = ProveedoresJSON.getJSON();
			String pagina = "/listadoproveedores.jsp";
			request.setAttribute("lista",lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listarProductos(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Productos> lista = ProductosJSON.getJSON();
			String pagina = "/listadoproductos.jsp";
			request.setAttribute("lista",lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listarVentas(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Ventas> lista = VentasJSON.getJSON();
			String pagina = "/listadoventas.jsp";
			request.setAttribute("lista",lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void listarVentasCliente(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Ventas> listaVentas = VentasJSON.getJSON();
			ArrayList<Clientes> listaClientes = ClientesJSON.getJSON();
			String pagina = "/ventascliente.jsp";
			request.setAttribute("listaVentas",listaVentas);
			request.setAttribute("listaClientes",listaClientes);
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
