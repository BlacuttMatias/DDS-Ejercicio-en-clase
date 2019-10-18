package canchas;

import java.util.Date;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public abstract class Jugador {
	
	@Id	@GeneratedValue
  private Long jugadorId;
	
  private String nombre;
  
  private String apellido;
  
  private String domicilio;
  
  private String telefono;
  
  
  private Date fechaNacimiento;

  @ManyToOne
  private Paleta paleta;

  public Jugador() {}
  
  public Inscripcion crearInscripcion() {
    return new Inscripcion(this, this.paleta);
  }

  public void setPaleta(Paleta paletaB) {
    this.paleta = paleta;
  }
  
}
