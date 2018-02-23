package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MatriculaModelo extends Conector {
	AlumnoModelo alum = new AlumnoModelo();
	AsignaturaModelo asig = new AsignaturaModelo();
	ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
	
	public ArrayList<Matricula> selectAll(){
		

		try {
			Statement st = super.conexion.createStatement();
			ResultSet rst = st.executeQuery("SELECT * FROM matriculas");
			
			while(rst.next()){
				
				Matricula matricula = new Matricula();
				matricula.setAlumno(alum.selectporID(rst.getInt("id_alumnos")));
				matricula.setAsignatura(asig.selectporID(rst.getInt("id_asignaturas")));
				matricula.setFecha(rst.getDate("fecha"));
				matriculas.add(matricula);
			}
			return matriculas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return matriculas;
		
	}
	
	
}
