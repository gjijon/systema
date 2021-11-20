package ec.fin.bce.ja.systema.persistencia.entities.academico;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the "aca_materia" database table.
 * 
 */
@Entity
@Table(name="aca_materia", schema = "academico")
@NamedQuery(name="AcaMateria.findAll", query="SELECT a FROM AcaMateria a")
public class AcaMateria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mat_codigo")
	private int matCodigo;

	@Column(name="car_codigo")
	private int carCodigo;

	@Column(name="mat_descripcion")
	private String matDescripcion;

	@Column(name="mat_estado")
	private boolean matEstado;

	@Column(name="mat_fecha_actualiza")
	private Timestamp matFechaActualiza;

	@Column(name="mat_nivel")
	private String matNivel;

	@Column(name="usu_codigo")
	private int usuCodigo;

	//bi-directional many-to-one association to AcaCarrera
	@ManyToOne
	@JoinColumns({
		})
	private AcaCarrera acaCarrera;

	//bi-directional many-to-one association to AcaNota
	@OneToMany(mappedBy="acaMateria")
	private List<AcaNota> acaNotas;

	public AcaMateria() {
	}

	public int getMatCodigo() {
		return this.matCodigo;
	}

	public void setMatCodigo(int matCodigo) {
		this.matCodigo = matCodigo;
	}

	public int getCarCodigo() {
		return this.carCodigo;
	}

	public void setCarCodigo(int carCodigo) {
		this.carCodigo = carCodigo;
	}

	public String getMatDescripcion() {
		return this.matDescripcion;
	}

	public void setMatDescripcion(String matDescripcion) {
		this.matDescripcion = matDescripcion;
	}

	public boolean getMatEstado() {
		return this.matEstado;
	}

	public void setMatEstado(boolean matEstado) {
		this.matEstado = matEstado;
	}

	public Timestamp getMatFechaActualiza() {
		return this.matFechaActualiza;
	}

	public void setMatFechaActualiza(Timestamp matFechaActualiza) {
		this.matFechaActualiza = matFechaActualiza;
	}

	public String getMatNivel() {
		return this.matNivel;
	}

	public void setMatNivel(String matNivel) {
		this.matNivel = matNivel;
	}

	public int getUsuCodigo() {
		return this.usuCodigo;
	}

	public void setUsuCodigo(int usuCodigo) {
		this.usuCodigo = usuCodigo;
	}

	public AcaCarrera getAcaCarrera() {
		return this.acaCarrera;
	}

	public void setAcaCarrera(AcaCarrera acaCarrera) {
		this.acaCarrera = acaCarrera;
	}

	public List<AcaNota> getAcaNotas() {
		return this.acaNotas;
	}

	public void setAcaNotas(List<AcaNota> acaNotas) {
		this.acaNotas = acaNotas;
	}

	public AcaNota addAcaNota(AcaNota acaNota) {
		getAcaNotas().add(acaNota);
		acaNota.setAcaMateria(this);

		return acaNota;
	}

	public AcaNota removeAcaNota(AcaNota acaNota) {
		getAcaNotas().remove(acaNota);
		acaNota.setAcaMateria(null);

		return acaNota;
	}

}