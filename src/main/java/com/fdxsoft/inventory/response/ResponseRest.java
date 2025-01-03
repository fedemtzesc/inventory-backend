package com.fdxsoft.inventory.response;

/**
 * 02.	Esta clase sirve para enviar metadatos y mensajes referentes
 * 		al estatus de la respuesta solicitada. Estos metadatos primeramente
 * 		se tienen que setear para que puedan ser mostrados en la respuesta.
 * 		
 *		Ademas, esta clase es generica y en este primer ejemplo se esta 		
 *		heredando a la clase CategoryResponseRest, pero si se crean mas clases
 *		estas tambien podran heredarlas para facilitar el uso de los metadatos
 *		que se tienen que mostrar en la respuesta de cada objeto.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class ResponseRest {
	private ArrayList<HashMap<String, String>> metadata = new ArrayList<>();

	public ArrayList<HashMap<String, String>> getMetadata() {
		return metadata;
	}

	public void setMetadata(String type, String code, String date) {
		HashMap< String, String> map = new HashMap<String, String>();
		map.put("type", type);
		map.put("code", code);
		map.put("date", date);
		
		metadata.add(map);
	}
}
