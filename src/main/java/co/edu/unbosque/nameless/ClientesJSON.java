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

public class ClientesJSON {
	
	private static URL url;
	private static String sitio = "http://localhost:5000/";

	public static ArrayList<Clientes> parsingClientes (String json) throws ParseException {
		
		JSONParser jsonParser = new JSONParser();
		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		
		JSONArray clientes = (JSONArray) jsonParser.parse(json);
		Iterator i = clientes.iterator();
		
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Clientes cliente = new Clientes();
			cliente.setCedula_clientes(Long.parseLong(innerObj.get("cedula_clientes").toString()));
			cliente.setEmail_clientes(innerObj.get("email_clientes").toString());
			cliente.setNombre_clientes(innerObj.get("nombre_clientes").toString());
			cliente.setTelefono_clientes(innerObj.get("telefono_clientes").toString());
			cliente.setDireccion_clientes(innerObj.get("direccion_clientes").toString());
			lista.add(cliente);
		}
		return lista;
	}

	public static ArrayList<Clientes> getJSON() throws IOException, ParseException{
		
		url = new URL(sitio+"clientes/listar");
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
		
		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		lista = parsingClientes(json);
		http.disconnect();
		return lista;
	}
	
	public static int postJSON(Clientes cliente) throws IOException {
		url = new URL(sitio+"clientes/guardar");
		
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
		+ "\"cedula_clientes\":\""+ cliente.getCedula_clientes()
		+"\",\"email_clientes\": \""+cliente.getEmail_clientes()
		+"\",\"nombre_clientes\": \""+cliente.getNombre_clientes()
		+"\",\"telefono_clientes\":\""+cliente.getTelefono_clientes()
		+"\",\"direccion_clientes\":\""+cliente.getDireccion_clientes()
		+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	public static int putJSON(Clientes cliente, Long id) throws IOException {
		
		url = new URL(sitio+"clientes/actualizar");
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
				+ "\"cedula_clientes\":\""+ cliente.getCedula_clientes()
				+"\",\"email_clientes\": \""+cliente.getEmail_clientes()
				+"\",\"nombre_clientes\": \""+cliente.getNombre_clientes()
				+"\",\"telefono_clientes\":\""+cliente.getTelefono_clientes()
				+"\",\"direccion_clientes\":\""+cliente.getDireccion_clientes()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}


	public static int deleteJSON(Long id) throws IOException {
	
		url = new URL(sitio+"clientes/eliminar/" + id);
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