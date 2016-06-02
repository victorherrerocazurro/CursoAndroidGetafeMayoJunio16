package com.ejemplo.contenedores;

import java.util.HashMap;
import java.util.Map;

public class Contenedor {

	private Map<Class, BeanManejado> misBeans = new HashMap<>();
	
	private static Contenedor instance = new Contenedor();
	
	private Contenedor() {
		
	}
	
	public static Contenedor getInstance(){
		return instance;
	}

	public void onCreate(){
		//Lectura del AndroidManifest de todos los Bean
		
		MainActivity mainActivity = new MainActivity();
		mainActivity.setContedor(this);
		misBeans.put(MainActivity.class, mainActivity);
		
		SegundaActivity segundaActivity = new SegundaActivity();
		segundaActivity.setContedor(this);
		misBeans.put(SegundaActivity.class, segundaActivity);
	}
	
	public void initApplication(){
		//Interpretar del Manifest quien es la actividad que se arranca (o de inicio)
		Actividad actividadDeInicio = (Actividad) misBeans.get(MainActivity.class);
		actividadDeInicio.onCreate();
	}
	
	public void startActivity(Intent intencion, Actividad origin){
		Actividad invocada = (Actividad) misBeans.get(intencion.getActividad());
		
		origin.onStop();
		
		invocada.onCreate();
		
		
	}
	
	
}
