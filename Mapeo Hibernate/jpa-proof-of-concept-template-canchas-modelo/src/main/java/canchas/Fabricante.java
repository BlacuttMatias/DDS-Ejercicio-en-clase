package canchas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Fabricante {
	
	@Id	@GeneratedValue
	private Long idFabricante;
	
	private String nombreFabricante;
	
	private Fabricante() {}

}
