package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AsignaturaModelo extends Conector {

	public ArrayList <Asignatura> selectAll(){
		 ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
		 
		 try {
			Statement st = super.conexion.createStatement();
			ResultSet rst = st.executeQuery("select * from asignaturas");
			
			while(rst.next()){
				Asignatura asignatura = new Asignatura();
				asignatura.setId(rst.getInt("id"));
				asignatura.setNombre(rst.getString("nombre"));
				asignatura.setHoras(rst.getInt("horas"));
				asignaturas.add(asignatura);
				
				return asignaturas;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return asignaturas;
	}
	
	public Asignatura selectporID(int id){	
		Asignatura asig = new Asignatura();
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("select * from asignaturas where id=?");
			pst.setInt(1, id);
			ResultSet rst = pst.executeQuery();
			
			if(rst.next()){
				asig.setId(rst.getInt("id"));
				asig.setNombre(rst.getString("nombre"));
				asig.setHoras(rst.getInt("horas"));
				
				return asig;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return asig;
	}
}
