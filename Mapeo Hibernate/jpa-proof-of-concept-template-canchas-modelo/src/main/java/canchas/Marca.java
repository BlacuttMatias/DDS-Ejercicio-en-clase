package canchas;

import javax.persistence.Embeddable;

//para guardar los atributos de la marca en la tabla paleta

@Embeddable
public class Marca {
	private String descripcion;
	private String telefono;
}
