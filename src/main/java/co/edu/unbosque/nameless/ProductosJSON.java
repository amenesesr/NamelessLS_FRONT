package co.edu.unbosque.nameless;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ProductosJSON {
	
	private static URL url;
	private static String sitio = "http://localhost:5000/";

	public static ArrayList<Productos> parsingProductos (String json) throws ParseException {
		
		JSONParser jsonParser = new JSONParser();
		ArrayList<Productos> lista = new ArrayList<Productos>();
		
		JSONArray productos = (JSONArray) jsonParser.parse(json);
		Iterator i = productos.iterator();
		
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Productos producto = new Productos();
			producto.setCodigo_productos(Long.parseLong(innerObj.get("codigo_productos").toString()));
			producto.setIvacompra_productos(Double.parseDouble(innerObj.get("ivacompra_productos").toString()));
			producto.setNitproveedor_proveedores(Long.parseLong(innerObj.get("nitproveedor_proveedores").toString()));
			producto.setNombre_productos(innerObj.get("nombre_productos").toString());	
			producto.setPrecio_compra_productos(Double.parseDouble(innerObj.get("precio_compra_productos").toString()));
			producto.setPrecio_venta_productos(Double.parseDouble(innerObj.get("precio_venta_productos").toString()));
			lista.add(producto);
		}
		return lista;
	}

	public static ArrayList<Productos> getJSON() throws IOException, ParseException{
		
		url = new URL(sitio+"productos/listar");
		String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
		HttpURLConnection http = (HttpURLConnection)url.openConnection();		
		
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		
		http.setRequestProperty("Autorization", "Basic" + authStr);
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		
		for (int i = 0; i<inp.length ; i++) {
			json += (char)inp[i];
		}
		
		ArrayList<Productos> lista = new ArrayList<Productos>();
		lista = parsingProductos(json);
		http.disconnect();
		return lista;
	}
	
	public static int postJSON(Productos producto) throws IOException {
		url = new URL(sitio+"productos/guardar");
		
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
		
		try {
			http.setRequestMethod("POST");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
		
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Autorization", "Basic" + authStr);
		http.setRequestProperty("Content-Type", "application/json");
		String data = "{"
		+ "\"codigo_productos\":\""+ producto.getCodigo_productos()
		+"\",\"ivacompra_productos\":\""+producto.getIvacompra_productos()
		+"\",\"nitproveedor_proveedores\": \""+producto.getNitproveedor_proveedores()
		+"\",\"nombre_productos\": \""+producto.getNombre_productos()
		+"\",\"precio_compra_productos\":\""+producto.getIvacompra_productos()
		+"\",\"precio_venta_productos\":\""+producto.getPrecio_venta_productos()
		+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	public static int deleteJSON(String id) throws IOException {

		url = new URL(sitio + "productos/eliminar/"+id); //trae el metodo de Usuarios.API 
		HttpURLConnection http = (HttpURLConnection) url.openConnection();


		try {
			http.setRequestMethod("DELETE");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}

		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	public static boolean validarCSV(String nombreArchivo) {
		int contador = 0;
        char valdador;
        for (int i = 0; i < nombreArchivo.length(); i++) {
        	valdador = nombreArchivo.charAt(i);
            if (valdador == '.')
            	contador++;
        }
        
        if (contador<2) {
        	if(nombreArchivo.contains(".csv")) {
    			return true;
    		}else {
    			return false;
    		}
        }else{
        	return false;
        }
	}
	
}


