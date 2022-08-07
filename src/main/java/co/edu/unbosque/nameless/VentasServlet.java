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

import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class VentaServlet
 */
@WebServlet("/VentasServlet")
public class VentasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VentasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: Entre al servlet").append(request.getContextPath());
			
		String btnConsultarCliente = request.getParameter("btnConsultarCliente");
		
		String btnConsultarProducto = request.getParameter("btnConsultarProducto");
	
		String btnConfirmar = request.getParameter("btnConfirmar");
		
		if(btnConsultarCliente  != null)
		{
			consultaClientes(request,response);
		}
		
		if(btnConsultarProducto != null)
		{
			consultaProductos(request,response); 
		}
		
		if(btnConfirmar != null)
		{
			try {
				registrarVenta(request,response);
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
		
	public void consultaClientes(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String pagina = "/ventasconsultas.jsp";
			long txtCedula = Long.parseLong(request.getParameter("txtCedula"));
			String txtCliente= "";
			long txtConsecutivo =  0;
			
			long txtCodProd1 = 0;
			String txtNomProd1 = " ";
			double txtValProd1 = 0;
	    	int txtCantidad1 = 0;
	    	double txtValorTotal1 = 0;
			
	    	long txtCodProd2 = 0;
			String txtNomProd2 = " ";
			double txtValProd2 = 0;
	    	int txtCantidad2 = 0;
	    	double txtValorTotal2 = 0;
	    	
	    	long txtCodProd3 = 0;
			String txtNomProd3 = " ";
			double txtValProd3 = 0;
	    	int txtCantidad3 = 0;
	    	double txtValorTotal3 = 0;
	    	
	    	double txtTotalIva = 0;
	    	double txtTotalVenta = 0;
	    	double txtTotalConIva = 0;
			
	    	int verificadorcliente = 0;
	    	
			ArrayList<Clientes> lista = ClientesJSON.getJSON();		
			
			for (Clientes cliente: lista){
				if (cliente.getCedula_clientes() == txtCedula)
				{
					txtCedula = cliente.getCedula_clientes();
					txtCliente = cliente.getNombre_clientes();
					verificadorcliente = 1;
				}
			}
			
			if(verificadorcliente == 0)
			{
				request.getRequestDispatcher("/ventaserrorcliente.jsp").forward(request, response);
			}
			

			ArrayList<Ventas> listaVentas = VentasJSON.getJSON();
			int i = 0;

			for (Ventas venta: listaVentas){
				i++;
				if (i == (listaVentas.size()))
				{
					txtConsecutivo = venta.getCodigo_ventas()+1;
				}
				
			} 
				
			request.setAttribute("txtCedula",txtCedula);
			request.setAttribute("txtCliente",txtCliente);
			request.setAttribute("txtConsecutivo",txtConsecutivo);
			
			request.setAttribute("txtCodProd1",txtCodProd1);
			request.setAttribute("txtNomProd1",txtNomProd1);
			request.setAttribute("txtValProd1",txtValProd1);
			request.setAttribute("txtCantidad1",txtCantidad1);
			request.setAttribute("txtValorTotal1",txtValorTotal1);
			
			request.setAttribute("txtCodProd2",txtCodProd2);
			request.setAttribute("txtNomProd2",txtNomProd2);
			request.setAttribute("txtValProd2",txtValProd2);
			request.setAttribute("txtCantidad2",txtCantidad2);
			request.setAttribute("txtValorTotal2",txtValorTotal2);
			
			request.setAttribute("txtCodProd3",txtCodProd3);
			request.setAttribute("txtNomProd3",txtNomProd3);
			request.setAttribute("txtValProd3",txtValProd3);
			request.setAttribute("txtCantidad3",txtCantidad3);
			request.setAttribute("txtValorTotal3",txtValorTotal3);
			
			request.setAttribute("txtTotalIva",txtTotalIva);
			request.setAttribute("txtTotalVenta",txtTotalVenta);
			request.setAttribute("txtTotalConIva",txtTotalConIva);
			
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void consultaProductos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String pagina = "/ventasconsultas.jsp";
			long txtCedula = Long.parseLong(request.getParameter("txtCedula"));
			String txtCliente = "";
			long txtConsecutivo = 0;
			
			long txtCodProd1 = Long.parseLong(request.getParameter("txtCodProd1"));
			String txtNomProd1 = request.getParameter("txtNomProd1");
			double txtValProd1 = 0;
	    	int txtCantidad1 = Integer.parseInt(request.getParameter("txtCantidad1"));
	    	double txtValorTotal1 = 0;
			
	    	long txtCodProd2 = Long.parseLong(request.getParameter("txtCodProd2"));
			String txtNomProd2 = "";
			double txtValProd2 = 0;
	    	int txtCantidad2 = Integer.parseInt(request.getParameter("txtCantidad2"));
	    	double txtValorTotal2 = 0;
	    	
	    	long txtCodProd3 = Long.parseLong(request.getParameter("txtCodProd3"));
			String txtNomProd3 = "";
			double txtValProd3 = 0;
	    	int txtCantidad3 = Integer.parseInt(request.getParameter("txtCantidad3"));
	    	double txtValorTotal3 = 0;
	    	
	    	double txtTotalIva = 0;
	    	double txtTotalVenta = 0;
	    	double txtTotalConIva = 0;
	    	
	    	double iva = 0.19;
	    	
	    	ArrayList<Clientes> lista = ClientesJSON.getJSON();
			
			for (Clientes cliente: lista){
				if (cliente.getCedula_clientes() == txtCedula)
				{
					txtCedula = cliente.getCedula_clientes();
					txtCliente = cliente.getNombre_clientes();
				}
			}
	    	
			ArrayList<Productos> listaProductos = ProductosJSON.getJSON();
			txtNomProd1 = "ERROR";
			txtNomProd2 = "ERROR";
			txtNomProd3 = "ERROR";
			for (Productos producto:listaProductos){
				if (producto.getCodigo_productos() == txtCodProd1)
				{
					txtValProd1 = producto.getPrecio_venta_productos();
					txtNomProd1 = producto.getNombre_productos();
					break;
				}
			}
			
			for (Productos producto:listaProductos){
				if (producto.getCodigo_productos() == txtCodProd2)
				{
					txtValProd2 = producto.getPrecio_venta_productos();
					txtNomProd2 = producto.getNombre_productos();
					break;
				}
			}
			
			for (Productos producto:listaProductos){
				if (producto.getCodigo_productos() == txtCodProd3)
				{
					txtValProd3 = producto.getPrecio_venta_productos();
					txtNomProd3 = producto.getNombre_productos();
					break;
				}
			}
			
			ArrayList<Ventas> listaVentas = VentasJSON.getJSON();
			int i = 0;

			for (Ventas venta: listaVentas){
				i++;
				if (i == (listaVentas.size()))
				{
					txtConsecutivo = venta.getCodigo_ventas()+1;
				}
				
			} 
			
			txtValorTotal1 = txtCantidad1 * txtValProd1;
			txtValorTotal2 = txtCantidad2 * txtValProd2;
			txtValorTotal3 = txtCantidad3 * txtValProd3;
			txtTotalVenta = txtValorTotal1 + txtValorTotal2 + txtValorTotal3;
			txtTotalIva = txtTotalVenta * iva;
			txtTotalConIva = txtTotalVenta + txtTotalIva;
			
		
			request.setAttribute("txtCedula",txtCedula);
			request.setAttribute("txtCliente",txtCliente);
			request.setAttribute("txtConsecutivo",txtConsecutivo);
			
			request.setAttribute("txtCodProd1",txtCodProd1);
			request.setAttribute("txtNomProd1",txtNomProd1);
			request.setAttribute("txtValProd1",txtValProd1);
			request.setAttribute("txtCantidad1",txtCantidad1);
			request.setAttribute("txtValorTotal1",txtValorTotal1);
			
			request.setAttribute("txtCodProd2",txtCodProd2);
			request.setAttribute("txtNomProd2",txtNomProd2);
			request.setAttribute("txtValProd2",txtValProd2);
			request.setAttribute("txtCantidad2",txtCantidad2);
			request.setAttribute("txtValorTotal2",txtValorTotal2);
			
			request.setAttribute("txtCodProd3",txtCodProd3);
			request.setAttribute("txtNomProd3",txtNomProd3);
			request.setAttribute("txtValProd3",txtValProd3);
			request.setAttribute("txtCantidad3",txtCantidad3);
			request.setAttribute("txtValorTotal3",txtValorTotal3);
			
			request.setAttribute("txtTotalIva",txtTotalIva);
			request.setAttribute("txtTotalVenta",txtTotalVenta);
			request.setAttribute("txtTotalConIva",txtTotalConIva);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void registrarVenta(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException, ServletException {
		try {
			
		String pagina = "/ventasconsultas.jsp";
		
		long txtCedula = Long.parseLong(request.getParameter("txtCedula"));
		String txtCliente = "";
		long txtConsecutivo = 0;
		
		long txtCodProd1 = Long.parseLong(request.getParameter("txtCodProd1"));
		String txtNomProd1 = request.getParameter("txtNomProd1");
		double txtValProd1 = 0;
    	int txtCantidad1 = Integer.parseInt(request.getParameter("txtCantidad1"));
    	double txtValorTotal1 = 0;
    	double iva1 = 0;
    	double totalDetalleVenta1 = 0;
		
    	long txtCodProd2 = Long.parseLong(request.getParameter("txtCodProd2"));
		String txtNomProd2 = "";
		double txtValProd2 = 0;
    	int txtCantidad2 = Integer.parseInt(request.getParameter("txtCantidad2"));
    	double txtValorTotal2 = 0;
    	double iva2 = 0;
    	double totalDetalleVenta2 = 0;
    	
    	long txtCodProd3 = Long.parseLong(request.getParameter("txtCodProd3"));
		String txtNomProd3 = "";
		double txtValProd3 = 0;
    	int txtCantidad3 = Integer.parseInt(request.getParameter("txtCantidad3"));
    	double iva3 = 0;
    	double totalDetalleVenta3 = 0;
    	
    	double txtValorTotal3 = 0;
    	double txtTotalIva = 0;
    	double txtTotalVenta = 0;
    	double txtTotalConIva = 0;
    	
    	double iva = 0.19;
      	
    	PrintWriter writer = response.getWriter();
    	
	   	ArrayList<Clientes> lista = ClientesJSON.getJSON();
		for (Clientes cliente: lista){
			if (cliente.getCedula_clientes() == txtCedula)
			{
				txtCedula = cliente.getCedula_clientes();
				txtCliente = cliente.getNombre_clientes(); 
			}
		}
		
		ArrayList<Ingresos> listaIngresos = IngresosJSON.getJSON();	
		int x = 0;
		long cedulausuario = 0;
		for (Ingresos ingreso: listaIngresos){			
			if (x == listaIngresos.size()-1)
			{
				cedulausuario = ingreso.getCedula_usuarios();
				break;
			}
			x++;	
		} 
		
		/*ArrayList<Usuarios> listausuarios = UsuariosJSON.getJSON();
		int x = 0;
		long cedulausuario = 0;
		for (Usuarios usuario: listausuarios){
			if (x == listausuarios.size()-1)
			{
				cedulausuario = usuario.getCedula_usuarios();
			}
			x++;
		}*/
	   	
		ArrayList<Productos> listaProductos = ProductosJSON.getJSON();
		txtNomProd1 = "-";
		txtNomProd2 = "-";
		txtNomProd3 = "-";
		for (Productos producto:listaProductos){
			if (producto.getCodigo_productos() == txtCodProd1)
			{
				txtValProd1 = producto.getPrecio_venta_productos();
				txtNomProd1 = producto.getNombre_productos();
				break;
			}
		}
			
		for (Productos producto:listaProductos){
			if (producto.getCodigo_productos() == txtCodProd2)
			{
				txtValProd2 = producto.getPrecio_venta_productos();
				txtNomProd2 = producto.getNombre_productos();
				break;
			}
		}
			
		for (Productos producto:listaProductos){
			if (producto.getCodigo_productos() == txtCodProd3)
			{
				txtValProd3 = producto.getPrecio_venta_productos();
				txtNomProd3 = producto.getNombre_productos();
				break;
			}
		}
		
		
		
			
		txtValorTotal1 = txtCantidad1 * txtValProd1;
		txtValorTotal2 = txtCantidad2 * txtValProd2;
		txtValorTotal3 = txtCantidad3 * txtValProd3;
		
		txtTotalVenta = txtValorTotal1 + txtValorTotal2 + txtValorTotal3;
		txtTotalIva = txtTotalVenta * iva;
		txtTotalConIva = txtTotalVenta + txtTotalIva;
			
		iva1 = txtValorTotal1 * iva;
		totalDetalleVenta1 = txtValorTotal1 + iva1;
		
		iva2 = txtValorTotal2 * iva;
		totalDetalleVenta2 = txtValorTotal2 + iva2;
			
		iva3 = txtValorTotal3 * iva;
		totalDetalleVenta3 = txtValorTotal3 + iva3;
			
		Ventas venta = new Ventas();
		venta.setCedula_clientes(Long.parseLong(request.getParameter("txtCedula")));
		venta.setCedula_usuarios(cedulausuario); //OJO ESTO HAY QUE CAMBIARLO
		venta.setIvaventa_ventas(txtTotalIva);
		venta.setValor_venta_ventas(txtTotalVenta);
		venta.setTotal_venta_ventas(txtTotalConIva);
		int respuestaVentas = 0;
			
		ArrayList<Ventas> listaVentas = VentasJSON.getJSON();
		int i = 0;
	
		for (Ventas ventaconsecutivo: listaVentas)
		{
			i++;
			if (i == (listaVentas.size()))
			{
				txtConsecutivo = ventaconsecutivo.getCodigo_ventas()+1;
			}			
		} 
			
			
		if(txtTotalVenta == 0.0) 
		{
			request.getRequestDispatcher("/ventaserrorventanula.jsp").forward(request, response);	
		}
		else 
		{
			respuestaVentas = VentasJSON.postJSON(venta);
		}
		
		if(txtCantidad1 > 0.0) 
		{
			DetalleVentas detalleVenta1 = new DetalleVentas();
			detalleVenta1.setCantidad_producto_detalle_venta(txtCantidad1);
			detalleVenta1.setCodigo_productos(Long.parseLong(request.getParameter("txtCodProd1")));
			detalleVenta1.setCodigo_ventas(txtConsecutivo);
			detalleVenta1.setValor_total_detalle_venta(totalDetalleVenta1);
			detalleVenta1.setValor_venta_detalle_venta(txtValorTotal1);
			detalleVenta1.setValoriva_detalle_venta(iva1);
			int respuestaDetalleVentas1 = 0;
				
			respuestaDetalleVentas1 = DetalleVentasJSON.postJSON(detalleVenta1);
			if (respuestaDetalleVentas1 == 200)
			{
		
			}
			else 
			{
				writer.println("Error: " + respuestaDetalleVentas1);
			}
		}
			
		if(txtCantidad2 > 0.0) 
		{
			DetalleVentas detalleVenta2 = new DetalleVentas();
			detalleVenta2.setCantidad_producto_detalle_venta(txtCantidad2);
			detalleVenta2.setCodigo_productos(Long.parseLong(request.getParameter("txtCodProd2")));
			detalleVenta2.setCodigo_ventas(txtConsecutivo);
			detalleVenta2.setValor_total_detalle_venta(totalDetalleVenta2);
			detalleVenta2.setValor_venta_detalle_venta(txtValorTotal2);
			detalleVenta2.setValoriva_detalle_venta(iva2);
			int respuestaDetalleVentas2 = 0;
				
			respuestaDetalleVentas2 = DetalleVentasJSON.postJSON(detalleVenta2);
			if (respuestaDetalleVentas2 == 200)
			{
					
			}
			else 
			{
				writer.println("Error: " + respuestaDetalleVentas2);
			}
		}
			
		if(txtCantidad3 > 0.0) 
		{
			
			DetalleVentas detalleVenta3 = new DetalleVentas();
			detalleVenta3.setCantidad_producto_detalle_venta(txtCantidad3);
			detalleVenta3.setCodigo_productos(Long.parseLong(request.getParameter("txtCodProd3")));
			detalleVenta3.setCodigo_ventas(txtConsecutivo);
			detalleVenta3.setValor_total_detalle_venta(totalDetalleVenta3);
			detalleVenta3.setValor_venta_detalle_venta(txtValorTotal3);
			detalleVenta3.setValoriva_detalle_venta(iva3);
			int respuestaDetalleVentas3 = 0;
				
			respuestaDetalleVentas3 = DetalleVentasJSON.postJSON(detalleVenta3);
			if (respuestaDetalleVentas3 == 200)
			{
					
			}
			else 
			{
				writer.println("Error: " + respuestaDetalleVentas3);
			}
		}
			
		
		if (respuestaVentas == 200)
		{
			request.setAttribute("txtCedula",txtCedula);
			request.setAttribute("txtCliente",txtCliente);
			request.setAttribute("txtConsecutivo",txtConsecutivo);
				
			request.setAttribute("txtCodProd1",txtCodProd1);
			request.setAttribute("txtNomProd1",txtNomProd1);
			request.setAttribute("txtValProd1",txtValProd1);
			request.setAttribute("txtCantidad1",txtCantidad1);
			request.setAttribute("txtValorTotal1",txtValorTotal1);
				
			request.setAttribute("txtCodProd2",txtCodProd2);
			request.setAttribute("txtNomProd2",txtNomProd2);
			request.setAttribute("txtValProd2",txtValProd2);
			request.setAttribute("txtCantidad2",txtCantidad2);
			request.setAttribute("txtValorTotal2",txtValorTotal2);
					
			request.setAttribute("txtCodProd3",txtCodProd3);
			request.setAttribute("txtNomProd3",txtNomProd3);
			request.setAttribute("txtValProd3",txtValProd3);
			request.setAttribute("txtCantidad3",txtCantidad3);
			request.setAttribute("txtValorTotal3",txtValorTotal3);
					
			request.setAttribute("txtTotalIva",txtTotalIva);
			request.setAttribute("txtTotalVenta",txtTotalVenta);
			request.setAttribute("txtTotalConIva",txtTotalConIva);
			request.getRequestDispatcher("/ventasexitosa.jsp").forward(request, response);
		}
		else 
		{
			writer.println("Error: " + respuestaVentas);
		}
		writer.close();	
	}catch(IOException | ServletException e){
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
