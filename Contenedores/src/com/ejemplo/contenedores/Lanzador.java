package com.ejemplo.contenedores;

public class Lanzador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Contenedor instance = Contenedor.getInstance();
		
		Contenedor instance2 = Contenedor.getInstance();
		
		if(instance == instance2){
			System.out.println("Por supuesto, es un singleton");
		}
		
		//inicializamos la Aplicacion
		instance.onCreate();
		
		//Y ahora simulamos que el usuario pulsa con el dedo sobre el launcher
		instance.initApplication();
		
	}
}