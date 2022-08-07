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
@WebServlet("/ProductoIndividualServlet")
public class ProductoIndividualServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoIndividualServlet() {
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
			listarProductos(request,response);
		}
		
		if(btnCrear != null)
		{
			crearProductoIndividual(request,response);
		}
		
		if(btnActualizar != null)
		{
			actualizarProductoIndividual(request,response);
		}
		
		if(btnBorrar != null)
		{	
			eliminarProductoIndividual(request,response);
		}
		
	}
	
	public void crearProductoIndividual(HttpServletRequest request, HttpServletResponse response) {
	
		String txtCodigo = request.getParameter("txtCodigo");
		String txtNombre = request.getParameter("txtNombre");
		String txtNIT = request.getParameter("txtNIT");
		String txtIVA = request.getParameter("txtIVA");
		String txtValorCompra = request.getParameter("txtValorCompra");
		String txtValorVenta = request.getParameter("txtValorVenta");
		
		if (txtNombre != "" && txtNIT != "" && txtIVA != "" && txtValorCompra != "" && txtValorVenta != "")
		{
			Productos producto = new Productos();
			producto.setCodigo_productos(Long.parseLong(txtCodigo));
			producto.setNombre_productos(txtNombre);
			producto.setNitproveedor_proveedores(Long.parseLong(txtNIT));
			producto.setIvacompra_productos(Double.parseDouble(txtIVA));
			producto.setPrecio_compra_productos(Double.parseDouble(txtValorCompra));
			producto.setPrecio_venta_productos(Double.parseDouble(txtValorVenta));
			int respuesta = 0;
			int verificadorproducto = 0;
			int verificadorproveedor = 0;
				
			try {
				ArrayList<Productos> lista = ProductosJSON.getJSON();
				for(Productos productoverificar : lista) {
					if(productoverificar.getCodigo_productos() == Long.parseLong(txtCodigo)) {
						verificadorproducto  = 1;
						break;
					}
				}
				
				ArrayList<Proveedores> listaproveedores = ProveedoresJSON.getJSON();
				for(Proveedores proveedorverificar : listaproveedores) {
					if(proveedorverificar.getNitproveedor_proveedores() == Long.parseLong(txtNIT)) {
						verificadorproveedor = 1;
						break;
					}
				}
				
				if(verificadorproducto == 1) 
				{
					request.getRequestDispatcher("/productoindividualerrorcrear.jsp").forward(request, response);
				}
				
				if(verificadorproveedor == 0) 
				{
					request.getRequestDispatcher("/productoindividualerrorcrearproveedor.jsp").forward(request, response);
				}
					
				respuesta = ProductoIndividualJSON.postJSON(producto);
				PrintWriter writer = response.getWriter();
				if (respuesta == 200)
				{
					request.getRequestDispatcher("/productoindividualcrear.jsp").forward(request, response);
				}
				else 
				{
					writer.println("Error: " + respuesta);
				}
				writer.close();
			}catch(IOException | ServletException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else
		{
			try {
				request.getRequestDispatcher("/productoindividualerrorcampos.jsp").forward(request, response);
			}catch(IOException | ServletException e){
				e.printStackTrace();
			}		
		}		
	}
	
	public void eliminarProductoIndividual(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("txtCodigo"));			
		int respuesta=0;
		int verificadorproducto = 0;
		int  verificadordetalleventas = 0;
		try {
			
			ArrayList<Productos> listaproductos = ProductosJSON.getJSON();
			for(Productos productoverificar:listaproductos) {
				if(productoverificar.getCodigo_productos() == id) {
					verificadorproducto = 1;
					break;
				}
			}
			
			ArrayList<DetalleVentas> listadetalleventas = DetalleVentasJSON.getJSON();
			for(DetalleVentas ventasverificar:listadetalleventas) {
				if(ventasverificar.getCodigo_productos() == id) {
					verificadordetalleventas = 1;
					break;
				}
			}
			
			if(verificadorproducto == 0) 
			{	
				request.getRequestDispatcher("/productoindividualerroreliminarnoexiste.jsp").forward(request, response);	
			}
			
			if(verificadordetalleventas == 0) 
			{	
				respuesta = ProductoIndividualJSON.deleteJSON(id);
				PrintWriter write = response.getWriter();
				if (respuesta==200) 
				{
					request.getRequestDispatcher("/productoindividualeliminar.jsp").forward(request, response);
				} 
				else 
				{
					write.println("Error: " +  respuesta);
				}
				write.close();
			}	
			else 
			{
				request.getRequestDispatcher("/productoindividualerroreliminarllaveforanea.jsp").forward(request, response);	
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void actualizarProductoIndividual(HttpServletRequest request, HttpServletResponse response) {
		
		String txtCodigo = request.getParameter("txtCodigo");
		String txtNombre = request.getParameter("txtNombre");
		String txtNIT = request.getParameter("txtNIT");
		String txtIVA = request.getParameter("txtIVA");
		String txtValorCompra = request.getParameter("txtValorCompra");
		String txtValorVenta = request.getParameter("txtValorVenta");
			
		if (txtNombre != "" && txtNIT != "" && txtIVA != "" && txtValorCompra != "" && txtValorVenta != "")
		{
			Productos producto = new Productos();
			producto.setCodigo_productos(Long.parseLong(txtCodigo));
				producto.setNombre_productos(txtNombre);
				producto.setNitproveedor_proveedores(Long.parseLong(txtNIT));
				producto.setIvacompra_productos(Double.parseDouble(txtIVA));
				producto.setPrecio_compra_productos(Double.parseDouble(txtValorCompra));
				producto.setPrecio_venta_productos(Double.parseDouble(txtValorVenta));
				int respuesta = 0;
				int verificadorproducto = 0;
				int verificadorproveedor = 0;
				
				try {
					ArrayList<Productos> listaproductos = ProductosJSON.getJSON();
					for(Productos productoverificar : listaproductos) {
						if(productoverificar.getCodigo_productos() == Long.parseLong(txtCodigo)) {
							verificadorproducto = 1;
							break;
						}
					}
					
					ArrayList<Proveedores> listaproveedores = ProveedoresJSON.getJSON();
					for(Proveedores proveedorverificar : listaproveedores) {
						if(proveedorverificar.getNitproveedor_proveedores() == Long.parseLong(txtNIT)) {
							verificadorproveedor = 1;
							break;
						}
					}
					
					if(verificadorproducto == 0) 
					{
						request.getRequestDispatcher("/productoindividualerroractualizar.jsp").forward(request, response);
					}
					
					if(verificadorproveedor == 0) 
					{
						request.getRequestDispatcher("/productoindividualerroractualizarproveedor.jsp").forward(request, response);
					}	
						
					respuesta = ProductoIndividualJSON.putJSON(producto,producto.getCodigo_productos());
					PrintWriter writer = response.getWriter();
					if (respuesta == 200)
					{
						request.getRequestDispatcher("/productoindividualactualizar.jsp").forward(request, response);
					}
					else 
					{
						writer.println("Error: " + respuesta);
					}
					writer.close();
				}catch(IOException | ServletException e){
					e.printStackTrace();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			else
			{
				try {
					request.getRequestDispatcher("/productoindividualerrorcampos.jsp").forward(request, response);
				}catch(IOException | ServletException e){
					e.printStackTrace();
				}		
			}		
	}	

	
	public void listarProductos(HttpServletRequest request, HttpServletResponse response) {
		try {
			long txtCodigo = Long.parseLong(request.getParameter("txtCodigo"));
			long txtNIT = 0;
			String txtNombre = "";
			double txtValorCompra = 0;
			double txtValorVenta = 0;
			double txtIVA = 0;
			int error = 0;
			ArrayList<Productos> lista = ProductosJSON.getJSON();
			String pagina = "/productoindividualconsulta.jsp";
			
			for (Productos producto:lista){
				if (producto.getCodigo_productos() == txtCodigo)
				{
					txtCodigo = producto.getCodigo_productos();
					txtNIT  = producto.getNitproveedor_proveedores();
					txtNombre = producto.getNombre_productos();
					txtValorCompra = producto.getPrecio_compra_productos();
					txtValorVenta = producto.getPrecio_venta_productos();
					txtIVA = producto.getIvacompra_productos();
					error = 1;
					break;
				}
			}
			
			request.setAttribute("txtCodigo",txtCodigo);
			request.setAttribute("txtNIT",txtNIT);
			request.setAttribute("txtNombre",txtNombre);
			request.setAttribute("txtValorCompra",txtValorCompra);
			request.setAttribute("txtValorVenta",txtValorVenta);
			request.setAttribute("txtIVA",txtIVA);
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
