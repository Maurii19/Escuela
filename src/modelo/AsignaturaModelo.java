package modelo;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return asignaturas;
	}
}
