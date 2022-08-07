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

public class DetalleVentasJSON {
	
	private static URL url;
	private static String sitio = "http://localhost:5000/";

	public static ArrayList<DetalleVentas> parsingDetalleVentas (String json) throws ParseException {
		
		JSONParser jsonParser = new JSONParser();
		ArrayList<DetalleVentas> lista = new ArrayList<DetalleVentas>();
		
		JSONArray detalleVentas = (JSONArray) jsonParser.parse(json);
		Iterator i = detalleVentas.iterator();
		
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			DetalleVentas detalleVenta = new DetalleVentas();
			detalleVenta.setCodigo_detalle_venta(Long.parseLong(innerObj.get("codigo_detalle_venta").toString()));
			detalleVenta.setCantidad_producto_detalle_venta(Integer.parseInt(innerObj.get("cantidad_producto_detalle_venta").toString()));
			detalleVenta.setCodigo_productos(Long.parseLong(innerObj.get("codigo_productos").toString()));
			detalleVenta.setCodigo_ventas(Long.parseLong(innerObj.get("codigo_ventas").toString()));
			detalleVenta.setValor_total_detalle_venta(Double.parseDouble(innerObj.get("valor_total_detalle_venta").toString()));
			detalleVenta.setValor_venta_detalle_venta(Double.parseDouble(innerObj.get("valor_venta_detalle_venta").toString()));
			detalleVenta.setValoriva_detalle_venta(Double.parseDouble(innerObj.get("valoriva_detalle_venta").toString()));
			lista.add(detalleVenta);
		}
		return lista;
	}

	public static ArrayList<DetalleVentas> getJSON() throws IOException, ParseException{
		
		url = new URL(sitio+"detalle_ventas/listar");
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
		
		ArrayList<DetalleVentas> lista = new ArrayList<DetalleVentas>();
		lista = parsingDetalleVentas(json);
		http.disconnect();
		return lista;
	}
	
	public static int postJSON(DetalleVentas detalleVenta) throws IOException {
		url = new URL(sitio+"detalle_ventas/guardar");
		
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
		+ "\"codigo_detalle_venta\":\""+ detalleVenta.getCodigo_detalle_venta()
		+"\",\"cantidad_producto_detalle_venta\":\""+detalleVenta.getCantidad_producto_detalle_venta()
		+"\",\"codigo_productos\": \""+detalleVenta.getCodigo_productos()
		+"\",\"codigo_ventas\": \""+detalleVenta.getCodigo_ventas()
		+"\",\"valor_total_detalle_venta\":\""+detalleVenta.getValor_total_detalle_venta()
		+"\",\"valor_venta_detalle_venta\":\""+detalleVenta.getValor_venta_detalle_venta()
		+"\",\"valoriva_detalle_venta\":\""+detalleVenta.getValoriva_detalle_venta()	
		+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
}


