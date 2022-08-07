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

public class UsuariosJSON {
	
	private static URL url;
	private static String sitio = "http://localhost:5000/";

	public static ArrayList<Usuarios> parsingUsuarios(String json) throws ParseException {
		
		JSONParser jsonParser = new JSONParser();
		ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		
		JSONArray usuarios = (JSONArray) jsonParser.parse(json);
		Iterator i = usuarios.iterator();
		
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Usuarios usuario = new Usuarios();
			usuario.setCedula_usuarios(Long.parseLong(innerObj.get("cedula_usuarios").toString()));
			usuario.setEmail_usuarios(innerObj.get("email_usuarios").toString());
			usuario.setNombre_usuarios(innerObj.get("nombre_usuarios").toString());
			usuario.setPassword_usuarios(innerObj.get("password_usuarios").toString());
			usuario.setUsuario_usuarios(innerObj.get("usuario_usuarios").toString());
			lista.add(usuario);
		}
		return lista;
	}

	public static ArrayList<Usuarios> getJSON() throws IOException, ParseException{
		
		url = new URL(sitio+"usuarios/listar");
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
		
		ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		lista = parsingUsuarios(json);
		http.disconnect();
		return lista;
	}
	
	public static int postJSON(Usuarios usuario) throws IOException {
		url = new URL(sitio+"usuarios/guardar");
		
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
		+ "\"cedula_usuarios\":\""+ usuario.getCedula_usuarios()
		+"\",\"email_usuarios\": \""+usuario.getEmail_usuarios()
		+"\",\"nombre_usuarios\": \""+usuario.getNombre_usuarios()
		+"\",\"password_usuarios\":\""+usuario.getPassword_usuarios()
		+"\",\"usuario_usuarios\":\""+usuario.getUsuario_usuarios()
		+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	public static int putJSON(Usuarios usuario, Long id) throws IOException {
		
		url = new URL(sitio+"usuarios/actualizar");
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
				+ "\"cedula_usuarios\":\""+ usuario.getCedula_usuarios()
				+"\",\"email_usuarios\": \""+usuario.getEmail_usuarios()
				+"\",\"nombre_usuarios\": \""+usuario.getNombre_usuarios()
				+"\",\"password_usuarios\":\""+usuario.getPassword_usuarios()
				+"\",\"usuario_usuarios\":\""+usuario.getUsuario_usuarios()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}


	public static int deleteJSON(Long id) throws IOException {
	
		url = new URL(sitio+"usuarios/eliminar/" + id);
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


