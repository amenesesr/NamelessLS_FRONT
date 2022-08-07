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

public class VentasJSON {
	
	private static URL url;
	private static String sitio = "http://localhost:5000/";

	public static ArrayList<Ventas> parsingVentas(String json) throws ParseException {
		
		JSONParser jsonParser = new JSONParser();
		ArrayList<Ventas> lista = new ArrayList<Ventas>();
		
		JSONArray ventas = (JSONArray) jsonParser.parse(json);
		Iterator i = ventas.iterator();
		
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Ventas venta = new Ventas();
			venta.setCodigo_ventas(Long.parseLong(innerObj.get("codigo_ventas").toString()));
			venta.setCedula_usuarios(Long.parseLong(innerObj.get("cedula_usuarios").toString()));
			venta.setCedula_clientes(Long.parseLong(innerObj.get("cedula_clientes").toString()));
			venta.setIvaventa_ventas(Double.parseDouble(innerObj.get("ivaventa_ventas").toString()));
			venta.setTotal_venta_ventas(Double.parseDouble(innerObj.get("total_venta_ventas").toString()));
			venta.setValor_venta_ventas(Double.parseDouble(innerObj.get("valor_venta_ventas").toString()));
			lista.add(venta);
		}
		return lista;
	}

	public static ArrayList<Ventas> getJSON() throws IOException, ParseException{
		
		url = new URL(sitio+"ventas/listar");
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
		
		ArrayList<Ventas> lista = new ArrayList<Ventas>();
		lista = parsingVentas(json);
		http.disconnect();
		return lista;
	}
	
	public static int postJSON(Ventas venta) throws IOException {
		url = new URL(sitio+"ventas/guardar");
		
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
		+ "\"codigo_ventas\":\""+ venta.getCodigo_ventas()
		+"\",\"cedula_clientes\": \""+venta.getCedula_clientes()
		+"\",\"cedula_usuarios\": \""+venta.getCedula_usuarios()
		+"\",\"ivaventa_ventas\":\""+venta.getIvaventa_ventas()
		+"\",\"total_venta_ventas\":\""+venta.getTotal_venta_ventas()
		+"\",\"valor_venta_ventas\":\""+venta.getValor_venta_ventas()
		+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
}


