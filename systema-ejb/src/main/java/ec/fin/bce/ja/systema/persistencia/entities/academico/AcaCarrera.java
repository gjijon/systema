package ec.fin.bce.ja.systema.persistencia.entities.academico;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the "aca_carrera" database table.
 * 
 */
@Entity
@Table(name="aca_carrera")
@NamedQuery(name="AcaCarrera.findAll", query="SELECT a FROM AcaCarrera a")
public class AcaCarrera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="car_codigo")
	private int carCodigo;

	@Column(name="car_descripcion")
	private String carDescripcion;

	@Column(name="car_estado")
	private boolean carEstado;

	@Column(name="car_fecha_actualiza")
	private Timestamp carFechaActualiza;

	@Column(name="car_nivel")
	private String carNivel;

	@Column(name="usu_codigo")
	private int usuCodigo;

	//bi-directional many-to-one association to AcaMateria
	@OneToMany(mappedBy="acaCarrera")
	private List<AcaMateria> acaMaterias;

	//bi-directional many-to-one association to AcaMatricula
	@OneToMany(mappedBy="acaCarrera")
	private List<AcaMatricula> acaMatriculas;

	//bi-directional many-to-one association to AcaNota
	@OneToMany(mappedBy="acaCarrera")
	private List<AcaNota> acaNotas;

	public AcaCarrera() {
	}

	public int getCarCodigo() {
		return this.carCodigo;
	}

	public void setCarCodigo(int carCodigo) {
		this.carCodigo = carCodigo;
	}

	public String getCarDescripcion() {
		return this.carDescripcion;
	}

	public void setCarDescripcion(String carDescripcion) {
		this.carDescripcion = carDescripcion;
	}

	public boolean getCarEstado() {
		return this.carEstado;
	}

	public void setCarEstado(boolean carEstado) {
		this.carEstado = carEstado;
	}

	public Timestamp getCarFechaActualiza() {
		return this.carFechaActualiza;
	}

	public void setCarFechaActualiza(Timestamp carFechaActualiza) {
		this.carFechaActualiza = carFechaActualiza;
	}

	public String getCarNivel() {
		return this.carNivel;
	}

	public void setCarNivel(String carNivel) {
		this.carNivel = carNivel;
	}

	public int getUsuCodigo() {
		return this.usuCodigo;
	}

	public void setUsuCodigo(int usuCodigo) {
		this.usuCodigo = usuCodigo;
	}

	public List<AcaMateria> getAcaMaterias() {
		return this.acaMaterias;
	}

	public void setAcaMaterias(List<AcaMateria> acaMaterias) {
		this.acaMaterias = acaMaterias;
	}

	public AcaMateria addAcaMateria(AcaMateria acaMateria) {
		getAcaMaterias().add(acaMateria);
		acaMateria.setAcaCarrera(this);

		return acaMateria;
	}

	public AcaMateria removeAcaMateria(AcaMateria acaMateria) {
		getAcaMaterias().remove(acaMateria);
		acaMateria.setAcaCarrera(null);

		return acaMateria;
	}

	public List<AcaMatricula> getAcaMatriculas() {
		return this.acaMatriculas;
	}

	public void setAcaMatriculas(List<AcaMatricula> acaMatriculas) {
		this.acaMatriculas = acaMatriculas;
	}

	public AcaMatricula addAcaMatricula(AcaMatricula acaMatricula) {
		getAcaMatriculas().add(acaMatricula);
		acaMatricula.setAcaCarrera(this);

		return acaMatricula;
	}

	public AcaMatricula removeAcaMatricula(AcaMatricula acaMatricula) {
		getAcaMatriculas().remove(acaMatricula);
		acaMatricula.setAcaCarrera(null);

		return acaMatricula;
	}

	public List<AcaNota> getAcaNotas() {
		return this.acaNotas;
	}

	public void setAcaNotas(List<AcaNota> acaNotas) {
		this.acaNotas = acaNotas;
	}

	public AcaNota addAcaNota(AcaNota acaNota) {
		getAcaNotas().add(acaNota);
		acaNota.setAcaCarrera(this);

		return acaNota;
	}

	public AcaNota removeAcaNota(AcaNota acaNota) {
		getAcaNotas().remove(acaNota);
		acaNota.setAcaCarrera(null);

		return acaNota;
	}

}