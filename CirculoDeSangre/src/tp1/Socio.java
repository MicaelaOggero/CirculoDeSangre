package tp1;
import java.time.*;
import java.util.*;
import java.time.temporal.*;


public class Socio {
	private Scanner teclado = new Scanner(System.in);
	private String nombre;
	private String apellido;
	private String dni;
	private LocalDate fechaNacimiento;
	private String domicilio;
	private String localidad;
	private int telefono;
	private String email; 
	grupoSanguineo grupo;
	private String entrada;
	private int ban=0;
	private boolean enfCronica;
	private boolean medPermanente;
	private String estCategoria;
	private String resp;
	ArrayList<LocalDate> list_donaciones = new ArrayList<LocalDate>();

	
	public Socio() {
		System.out.print("Nombre: ");
		nombre=teclado.nextLine();
		System.out.print("Apellido: ");
		apellido=teclado.nextLine();
		System.out.print("DNI: ");
		dni=teclado.nextLine();
		int dia, mes, anio;
		System.out.println("Fecha de nacimiento: ");
		System.out.print("D�a: ");
		dia=teclado.nextInt();
		System.out.print("Mes: ");
		mes=teclado.nextInt();
		System.out.print("A�o: ");
		anio=teclado.nextInt();
		fechaNacimiento = LocalDate.of(anio, mes, dia);
		teclado.nextLine();
		System.out.print("Domicilio: ");
		domicilio=teclado.nextLine();
		System.out.print("Localidad: ");
		localidad=teclado.nextLine();
		System.out.print("Teléfono: ");
		telefono=teclado.nextInt();
		teclado.nextLine();
		System.out.print("Email: ");
		email=teclado.nextLine();
		
		while(ban==0) {
			
			System.out.println("Ingrese su grupo sanguineo:  A - B - AB - _0");
			entrada=teclado.nextLine().toUpperCase(); 

			
			if(entrada.compareTo("A")==0 || entrada.compareTo("B")==0 ||
			entrada.compareTo("AB")==0 ||entrada.compareTo("_0")==0) {
				ban=1;
			}
		}
		
		grupo = Enum.valueOf(grupoSanguineo.class, entrada); 
		
		System.out.println("¿Tiene una enfermedad crónica? (SI - NO)");
		resp=teclado.nextLine();
		if(resp.equals("SI")) {
		enfCronica=true;
		}
		else {
			if(resp.equals("NO")) {
				enfCronica=false;
			}
		}
		System.out.println("¿Toma medicación permanente? (SI - NO)");
		resp=teclado.nextLine();
		if(resp.equals("SI")) {
			medPermanente=true;
		}
		else {
			if(resp.equals("NO")) {
				medPermanente=false;
			}
		}
		
		
	}
	
	enum grupoSanguineo { //subclase
		
		AB("ab"), A("a"), B("b"), _0("0"); //declaro los valores que acepta
		
		private String grupo;
		
		private grupoSanguineo(String grupo) { //constructor de la subclase
			this.grupo=grupo;
		}
		
		public String getGrupo() {
			return grupo;
		}
		
		private boolean compareGrupo() {
			if(grupo.compareTo("A")==0) {
				return true;
			}
			else return false;
		}
}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getDni() {
		return dni;
	}
	
	public LocalDate getFachaNacimiento() {
		return fechaNacimiento;
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public String getLocalidad() {
		return localidad;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public String getEmail() {
		return email;
	}
	
	/*public String getGrupoSanguineo() {
		return grupoSanguineo;
	}*/
	
	public String getEnfCronica() {
		
		String enfermedad;
		if(enfCronica) {
			enfermedad= "SI";
		}
		else enfermedad="NO";
		
		return enfermedad;
	}
	
	public String getMedPermanente() {
		
		String medicacion;
		if(medPermanente) {
			medicacion="SI";
		}
		else medicacion="NO";
		
		return medicacion;
	}
	
	public String getEstadoCategoria() {
		return estCategoria;
	}
	
	public void agregarDonacion(LocalDate fecha) {
		list_donaciones.add(fecha);
	}
	
	public void mostrarDonaciones() {
		for(int i=0;i<list_donaciones.size();i++) {
			System.out.println(list_donaciones.get(i));
		}
	}
	
	public boolean ultimaDonacion() {
		int ban=0;
		for(int i=0;i<list_donaciones.size();i++) {
			if(ChronoUnit.YEARS.MONTHS.DAYS.between(list_donaciones.get(i), LocalDate.now())>6) {
				ban=1;
			}
		}
		if(ban==0) {
			return false;
		}
		
		else return true;
	}
	
	
	public void asigCategoria() {
		
		if(ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now())>17 && ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now())<57 && 
			medPermanente==false && enfCronica==false) {
				estCategoria= "ACTIVO";
		}
		else {
				estCategoria="PASIVO";
		}
	}

	
	
}
