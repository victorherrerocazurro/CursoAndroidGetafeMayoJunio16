package com.ejemplo.contenedores;

public abstract class Actividad implements BeanManejado{

	private Contenedor contenedor;
	
	public Contenedor getContenedor() {
		return contenedor;
	}

	public void setContenedor(Contenedor contenedor) {
		this.contenedor = contenedor;
	}

	public void setContedor(Contenedor contenedor) {
		this.contenedor = contenedor;
	}

	public void startActivity(Intent intencion){
		contenedor.startActivity(intencion, this);
	}
	
	public abstract void onCreate();

	public abstract void onStop();
	
	
}
