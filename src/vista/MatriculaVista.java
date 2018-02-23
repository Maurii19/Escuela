package vista;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.Alumno;
import modelo.AlumnoModelo;
import modelo.Asignatura;
import modelo.AsignaturaModelo;
import modelo.Matricula;
import modelo.MatriculaModelo;


public class MatriculaVista {

	static final int LISTAR_MATRICULAS = 1;
	static final int ALUMNOS_MATRICULAS = 2;
	static final int SALIR = 0;
	
	public void menuMatricula(){
		Scanner lector = new Scanner(System.in);
		MatriculaModelo matriculaModelo = new MatriculaModelo();
		int opcion;
		
		do{
			System.out.println("---- MENU ----");
			System.out.println(LISTAR_MATRICULAS + "- Listar las matriculas de la BBDD.");
			System.out.println(ALUMNOS_MATRICULAS +"- Listar alumnos.");
			System.out.println(SALIR + "- Finalizar programa.");
			
			opcion = Integer.parseInt(lector.nextLine());
			
			switch(opcion){
			
			case LISTAR_MATRICULAS:
				ArrayList<Matricula> matri = matriculaModelo.selectAll();
				this.mostarMatricula(matri);
				
			break;
			
			case ALUMNOS_MATRICULAS:
				AlumnoModelo alumnoModelo = new AlumnoModelo();
				//ArrayList<Alumno> alumnos = alumnoModelo.selectAllconMatricula();
				
				
				//this.mostrarAlumnos(alumnos);
				break;
			
			case SALIR:
			System.out.println("Finalizando programa...");
			break;
			
			
			
			default:
			System.out.println("Opcion mal.");
			
			}
			
			
		}while(opcion != SALIR);
	}

	public  void mostarMatricula(ArrayList<Matricula> matriculas) {
		Iterator <Matricula> i = matriculas.iterator();
		while (i.hasNext()){
			Matricula matri = i.next();
			mostrarMatriculas(matri);
			
		}
		
		
	}

	public void mostrarMatriculas(Matricula matricula) {
		java.util.Date fecha = matricula.getFecha();
		String fechas = "";
		
		if (fecha == null){
			fechas = "fecha vacio";
	
		}else{
			fechas = new SimpleDateFormat("dd/MM/yyyy").format(matricula.getFecha());
		}
		System.out.println("Nombre del Alumno: " + matricula.getAlumno().getNombre() + " Asignatura: " + matricula.getAsignatura().getNombre() + " Horas: " + matricula.getAsignatura().getHoras() + "  Fecha: " + matricula.getFecha());
		
		
		
	}
}
