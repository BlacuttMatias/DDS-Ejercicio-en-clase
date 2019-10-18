package canchas;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Paleta{
	
	@Id @GeneratedValue
	private Long paletaId;
	
	private String nombre;
	
	private Integer grosor;
	//para que no traiga el color en la consulta de una paleta si no es necesario, por defecto es EAGER (lo trae aunque no lo necesite)
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Color color;
	
	@Embedded
	private Marca marca;
	
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Paleta() {}
  
	public Long getPaletaId() {
		return paletaId;
	}

	public void setPaletaId(Long paletaId) {
		this.paletaId = paletaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getGrosor() {
		return grosor;
	}

	public void setGrosor(Integer grosor) {
		this.grosor = grosor;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Paleta(Color unColor) {
		this.color = unColor;
	}
	
}
