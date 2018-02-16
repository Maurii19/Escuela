package modelo;

import java.util.Date;

public class Matricula {

	private int id_alumnos;
	private int id_asignaturas;
	private Date fecha;
	
	public int getId_alumnos() {
		return id_alumnos;
	}
	public void setId_alumnos(int id_alumnos) {
		this.id_alumnos = id_alumnos;
	}
	public int getId_asignaturas() {
		return id_asignaturas;
	}
	public void setId_asignaturas(int id_asignaturas) {
		this.id_asignaturas = id_asignaturas;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
