package com.ejemplo.contenedores;

public class Intent {

	private Contenedor contexto;
	private Class actividad;
	
	public Intent(Contenedor contexto, Class actividad) {
		super();
		this.contexto = contexto;
		this.actividad = actividad;
	}

	public Contenedor getContexto() {
		return contexto;
	}

	public void setContexto(Contenedor contexto) {
		this.contexto = contexto;
	}

	public Class getActividad() {
		return actividad;
	}

	public void setActividad(Class actividad) {
		this.actividad = actividad;
	}	
}
