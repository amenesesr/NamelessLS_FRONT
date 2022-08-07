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

public class IngresosJSON {
	
	private static URL url;
	private static String sitio = "http://localhost:5000/";

	public static ArrayList<Ingresos> parsingIngresos(String json) throws ParseException {
		
		JSONParser jsonParser = new JSONParser();
		ArrayList<Ingresos> lista = new ArrayList<Ingresos>();
		
		JSONArray ingresos = (JSONArray) jsonParser.parse(json);
		Iterator i = ingresos.iterator();
		
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Ingresos ingreso = new Ingresos();
			ingreso.setSesion_ingresos(Long.parseLong(innerObj.get("sesion_ingresos").toString()));
			ingreso.setUsuario_usuarios(innerObj.get("usuario_usuarios").toString());
			ingreso.setCedula_usuarios(Long.parseLong(innerObj.get("cedula_usuarios").toString()));
			ingreso.setFecha_hora_ingresos(innerObj.get("fecha_hora_ingresos").toString());
			lista.add(ingreso);
		}
		return lista;
	}

	public static ArrayList<Ingresos> getJSON() throws IOException, ParseException{
		
		url = new URL(sitio+"ingresos/listar");
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
		
		ArrayList<Ingresos> lista = new ArrayList<Ingresos>();
		lista = parsingIngresos(json);
		http.disconnect();
		return lista;
	}
	
	public static int postJSON(Ingresos ingreso) throws IOException {
		url = new URL(sitio+"ingresos/guardar");
		
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
		+ "\"sesion_ingresos\":\""+ ingreso.getSesion_ingresos()
		+"\",\"usuario_usuarios\": \""+ingreso.getUsuario_usuarios()
		+"\",\"cedula_usuarios\": \""+ingreso.getCedula_usuarios()
		+"\",\"fecha_hora_ingresos\": \""+ingreso.getFecha_hora_ingresos()
		+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
}


