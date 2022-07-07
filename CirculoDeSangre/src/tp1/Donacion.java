package tp1;

import java.util.*;
import java.time.*;

public class Donacion {
	private LocalDate fechaDonacion;
	private boolean dono=false;

	public Donacion() {
		fechaDonacion = LocalDate.now();
		dono=false;
	}
	
	
	public LocalDate getFechaDonacion() {
		
		return fechaDonacion;
	}
	
	public String getDono() {
		String estadoDonacion;
		
		if(dono==true) {
			estadoDonacion="Dono";
		}
		else estadoDonacion="No dono";
		
		return estadoDonacion;
	}
	
	
	
	public void registrarDonacion(LocalDate fecha) {

		
		fechaDonacion=fecha;
		
		
				
	}
	
	public void actualizarEstadoDonacion() {
		
		dono=true;
		
	}
	
	
}
