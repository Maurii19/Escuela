package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class AlumnoModelo extends Conector {

	public ArrayList <Alumno> selectAll(){
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rst = st.executeQuery("SELECT * FROM alumnos");
			
			while(rst.next()){
				Alumno alumno = new Alumno();
				alumno.setId(rst.getInt("id"));
				alumno.setNombre(rst.getString("nombre"));
				alumno.setDni(rst.getString("dni"));
				alumno.setEmail(rst.getString("email"));
			}
			return alumnos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
		
	}
	
	

}
