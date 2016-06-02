package com.ejemplo.contenedores;

public class SegundaActivity extends Actividad{

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		
		System.out.println("Soy Segunda Activity: Me han invocado");
		
//		Intent intent = new Intent(getContenedor(), MainActivity.class);
//		
//		startActivity(intent);
		
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		System.out.println("Parando SegundaActivity");
		
	}

	

}
