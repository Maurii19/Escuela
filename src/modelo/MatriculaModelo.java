package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MatriculaModelo extends Conector {

	public ArrayList <Matricula> selectAll(){
		ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rst = st.executeQuery("SELECT * FROM matriculas");
			
			while(rst.next()){
				Matricula matricula = new Matricula();
				matricula.setId_alumnos(rst.getInt("id_alumnos"));
				matricula.setId_asignaturas(rst.getInt("id_asignaturas"));
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
