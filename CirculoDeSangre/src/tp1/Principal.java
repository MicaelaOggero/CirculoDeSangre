package tp1;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.temporal.*;


public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		ArrayList<Socio> list_socios = new ArrayList<Socio>();
		ArrayList<Donacion> list_donacion = new ArrayList<Donacion>();
		ArrayList<Socio> list_donadores = new ArrayList<Socio>();

		
		int opcion;
		
		boolean salir = false;
		//mientras que yo no le diga salir que siga funcionando
		while(!salir) {
		
		System.out.println("-----Men�-----");
		System.out.println("1. Registrarse");
		System.out.println("2. Registar donacion");
		System.out.println("3. Mostrar datos");
		System.out.println("4. Pedido donadores");
		System.out.println("5. Historial donaciones");
		System.out.println("6. Salir");
		System.out.print("Opci�n: ");
		opcion=teclado.nextInt();
		
			switch(opcion){
				case 1:
					teclado.nextLine();
					String factor;
					System.out.print("Factor: ");
					factor=teclado.nextLine();
					if(factor.equals("RH Negativo")) {
						Socio socio=new Socio();
						Donacion donacion = new Donacion();
						socio.asigCategoria();
						list_socios.add(socio);
						list_donacion.add(donacion);
					}
					
					else System.out.println("Usted no puede registrarse");
					break;
			
				case 2: 
					LocalDate fecha;
					String id;
					int ban=0;
					teclado.nextLine();
					System.out.print("DNI: ");
					id=teclado.nextLine();
					
					boolean resultado=false;
					
					
					do {
						for(int l=0;l<=list_socios.size()-1;l++) {
							if(list_socios.get(l).getDni().equals(id)) {
								resultado=true;
							}
						}
						 
							for(int l=0;l<=list_socios.size()-1;l++) {
								if(id.equals(list_socios.get(l).getDni())) {
									if(list_socios.get(l).getEstadoCategoria().equals("ACTIVO")) {
									
										System.out.println("Fecha Donacion: ");
										System.out.print("D�a: ");
										int k=teclado.nextInt();
										System.out.print("Mes: ");
										int j=teclado.nextInt();
										System.out.print("Año: ");
										int i=teclado.nextInt();
										
										fecha=LocalDate.of(i, j, k);
										
										list_donacion.get(l).registrarDonacion(fecha);
										list_donacion.get(l).actualizarEstadoDonacion();
										list_socios.get(l).agregarDonacion(fecha);
		
										ban=1;
									}
									else {
										System.out.println("Error: El DNI no pertenece a una persona ACTIVA");
										ban=1;
									}
								}			
							}
						
						if(resultado==false) {
								
							System.out.println("Error: El DNI es incorrecto");
							System.out.print("DNI: ");
							id=teclado.nextLine();
						}
						
						
					}while(ban==0);
					break;
			
				case 3:
					
					
					for(int j=0;j<=list_socios.size()-1;j++) {
						System.out.println("----Datos personales:---- ");
						System.out.println("Nombre: "+list_socios.get(j).getNombre());
						System.out.println("Apellido: "+list_socios.get(j).getApellido());
						System.out.println("DNI: "+list_socios.get(j).getDni());
						System.out.println("Fecha nacimiento: "+list_socios.get(j).getFachaNacimiento());
						System.out.println("Domicilio: "+list_socios.get(j).getDomicilio());
						System.out.println("Localidad: "+list_socios.get(j).getLocalidad());
						System.out.println("Tel�fono: "+list_socios.get(j).getTelefono());
						System.out.println("Email: "+list_socios.get(j).getEmail());
						System.out.println("----Datos medicos:---- ");
						System.out.println("Grupo sanguineo: "+list_socios.get(j).grupo.getGrupo());
						System.out.println("Factor: RH Negativo");
						System.out.println("Enfermedad cronica: "+list_socios.get(j).getEnfCronica());
						System.out.println("Medicacion permanente: "+list_socios.get(j).getMedPermanente());
						System.out.println(" Categoria: "+list_socios.get(j).getEstadoCategoria());
						
					}
					
					
					break;			
					
					case 4:
					
					String grupo;
					
					teclado.nextLine();
					
					System.out.println("Grupo sanguineo: A - B - AB - 0");
					grupo=teclado.nextLine();
					int bandera=0;		
					
					do {
					
						
						 
						
						if(grupo.equals("a") || grupo.equals("b") ||
								grupo.equals("ab") || grupo.equals("0")) {
							
							bandera=1;
						}
							else {
								System.out.println("Grupo sanguineo:  A - B - AB - _0");
								grupo=teclado.nextLine();
						}
						
						
					}
					while(bandera==0); 
					System.out.print("Cantidad de donadores: ");
					int i=teclado.nextInt();
					int ban2=0;
					
					while(ban2==0 && i!=0) {	
						
					boolean resultado2=false;
					
					for(int j=0;j<list_socios.size();j++) {
						
						
						if(list_socios.get(j).getEstadoCategoria().equals("ACTIVO") && list_socios.get(j).grupo.getGrupo().equals(grupo)) {
										
								if(list_donacion.get(j).getDono().equals("No dono")) {
									list_donadores.add(list_socios.get(j));
									resultado2=true;
									ban2=1;
									i--;
								}
								else {
									
									if(list_socios.get(j).ultimaDonacion()==true) {
										list_donadores.add(list_socios.get(j));
										System.out.println("Mayor a seis meses");
										resultado2=true;
										ban2=1;
										i--;
								}
									else {
										System.out.println("Menor a seis meses");
										ban2=1;
										i--;
									}
								}
						}		
					}

					if(resultado2==false) {
						System.out.println("No se encontraron donantes");
						ban2=1;
					}
					
					else {
						System.out.println("----Donadores----");
						for(int l=0;l<list_donadores.size();l++) {
							System.out.println("Nombre: "+list_donadores.get(l).getNombre()+" DNI: "
									+list_donadores.get(l).getDni());
						}
						list_donadores.clear();
					}
					}
					break;
					
				case 5:
					int ban1=0;
					String id1;
					teclado.nextLine();
					System.out.print("DNI: ");
					id1=teclado.nextLine();
					boolean resultado1=false;	
					
					do {
						for(int l=0;l<=list_socios.size()-1;l++) {
							if(list_socios.get(l).getDni().equals(id1)) {
								resultado1=true;
							}
						}
						
						for(int l=0;l<=list_socios.size()-1;l++) {
								
								if(list_socios.get(l).getDni().equals(id1)) {
									
									if(list_donacion.get(l).getDono().equals("Dono")) {
										System.out.println("Donaciones: ");
										list_socios.get(l).mostrarDonaciones();
										ban1=1;
									}
									
									else {
										System.out.println("No realizo donaciones");
										ban1=1;
									}
								}
						}
						
						if(resultado1==false) {
							System.out.println("El DNI es incorrecto");
							System.out.print("DNI: ");
							id1=teclado.nextLine();
						}
					}while(ban1==0);
					break;
					
				case 6:
					salir=true;
					break;
			
				default:
					System.out.println("La opcion no es valida");
			}
		
		
		}
		

	}
	
	
}
