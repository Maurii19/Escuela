package modelo;
import java.sql.PreparedStatement;
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
				alumnos.add(alumno);
			}
			return alumnos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
		
	}
	
	public ArrayList<Alumno> matricula(int id){
		ArrayList<Alumno> alumMatricula = new ArrayList<Alumno>();
		try{
			Statement st = super.conexion.createStatement();
			ResultSet rst = st.executeQuery("SELECT * FROM alumnos where id =('" + id + "')");
			while(rst.next()){
				Alumno alumMatriculas = new Alumno();
				alumMatriculas.setId(rst.getInt("id"));
				alumMatriculas.setNombre(rst.getString("nombre"));
				alumMatriculas.setDni(rst.getString("dni"));
				alumMatriculas.setEmail(rst.getString("email"));
				
				alumMatricula.add(alumMatriculas);
			}
			return alumMatricula;
		}catch (SQLException e){
			e.printStackTrace();
		}
		return alumMatricula;
		
	}

	public Alumno selectporID(int id){	
		Alumno alum = new Alumno();
		PreparedStatement pst;
		try {
		     pst = super.conexion.prepareStatement("select * from alumnos where id=?");
		     pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
		    alum.setId(rs.getInt("id"));
		    alum.setNombre(rs.getString("nombre"));
		    alum.setDni(rs.getString("dni"));
		    alum.setEmail(rs.getString("email"));
		   
		    return alum;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alum;
	}




}
