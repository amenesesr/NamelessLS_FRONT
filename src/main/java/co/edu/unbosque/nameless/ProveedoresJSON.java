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

public class ProveedoresJSON {
	
	private static URL url;
	private static String sitio = "http://localhost:5000/";

	public static ArrayList<Proveedores> parsingProveedores (String json) throws ParseException {
		
		JSONParser jsonParser = new JSONParser();
		ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
		
		JSONArray proveedores = (JSONArray) jsonParser.parse(json);
		Iterator i = proveedores.iterator();
		
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Proveedores proveedor = new Proveedores();
			proveedor.setNitproveedor_proveedores(Long.parseLong(innerObj.get("nitproveedor_proveedores").toString()));
			proveedor.setNombre_proveedores(innerObj.get("nombre_proveedores").toString());
			proveedor.setCiudad_proveedores(innerObj.get("ciudad_proveedores").toString());
			proveedor.setDireccion_proveedores(innerObj.get("direccion_proveedores").toString());
			proveedor.setTelefono_proveedores(innerObj.get("telefono_proveedores").toString());
			lista.add(proveedor);
		}
		return lista;
	}

	public static ArrayList<Proveedores> getJSON() throws IOException, ParseException{
		
		url = new URL(sitio+"proveedores/listar");
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
		
		ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
		lista = parsingProveedores(json);
		http.disconnect();
		return lista;
	}
	
	public static int postJSON(Proveedores proveedor) throws IOException {
		url = new URL(sitio+"proveedores/guardar");
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
		+ "\"nitproveedor_proveedores\":\""+ proveedor.getNitproveedor_proveedores()
		+"\",\"nombre_proveedores\": \""+proveedor.getNombre_proveedores()
		+"\",\"telefono_proveedores\": \""+proveedor.getTelefono_proveedores()
		+"\",\"direccion_proveedores\":\""+proveedor.getDireccion_proveedores()
		+"\",\"ciudad_proveedores\":\""+proveedor.getCiudad_proveedores()
		+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	public static int putJSON(Proveedores proveedor, Long id) throws IOException {
		
		url = new URL(sitio+"proveedores/actualizar");
		String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		try {
		  http.setRequestMethod("PUT");
		} catch (ProtocolException e) {
		  e.printStackTrace();
		}
		
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Autorization", "Basic" + authStr);
		http.setRequestProperty("Content-Type", "application/json");
		
		String data = "{"
				+ "\"nitproveedor_proveedores\":\""+ proveedor.getNitproveedor_proveedores()
				+"\",\"nombre_proveedores\": \""+proveedor.getNombre_proveedores()
				+"\",\"telefono_proveedores\": \""+proveedor.getTelefono_proveedores()
				+"\",\"direccion_proveedores\":\""+proveedor.getDireccion_proveedores()
				+"\",\"ciudad_proveedores\":\""+proveedor.getCiudad_proveedores()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}


	public static int deleteJSON(Long id) throws IOException {
	
		url = new URL(sitio+"proveedores/eliminar/" + id);
		String authStr = Base64.getEncoder().encodeToString("usuario:tiendagenerica".getBytes());
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
	
		try {
			http.setRequestMethod("DELETE");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
	
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Autorization", "Basic" + authStr);
		http.setRequestProperty("Content-Type", "application/json");
	
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	
}


