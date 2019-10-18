package canchas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Color {

	@Id @GeneratedValue
	private Long id;

	
	private String descripcion;
	
	private String otraCosa;
	public String getOtraCosa() {
		return otraCosa;
	}
	public void setOtraCosa(String otraCosa) {
		this.otraCosa = otraCosa;
	}

	private String hexa;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHexa() {
		return hexa;
	}
	public void setHexa(String hexa) {
		this.hexa = hexa;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	private Color() {}
	public Color(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}

}
