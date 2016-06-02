package com.ejemplo.contenedores;

public class MainActivity extends Actividad{

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		
		System.out.println("Estoy en Main Activity");
		
		Intent intent = new Intent(getContenedor(), SegundaActivity.class);
		
		startActivity(intent);
		
	}

	@Override
	public void onStop() {
		System.out.println("Parando MainActivity");
		
	}

}
