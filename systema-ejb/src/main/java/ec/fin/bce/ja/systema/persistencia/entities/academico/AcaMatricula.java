package ec.fin.bce.ja.systema.persistencia.entities.academico;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the "aca_matricula" database table.
 * 
 */
@Entity
@Table(name="aca_matricula", schema = "academico")
@NamedQuery(name="AcaMatricula.findAll", query="SELECT a FROM AcaMatricula a")
public class AcaMatricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mtc_codigo")
	private int mtcCodigo;

	@Column(name="aln_codigo")
	private int alnCodigo;

	@Column(name="car_codigo")
	private int carCodigo;

	@Column(name="mat_fecha_actualiza")
	private Timestamp matFechaActualiza;

	@Column(name="mtc_estado")
	private String mtcEstado;

	@Column(name="usu_codigo")
	private int usuCodigo;

	//bi-directional many-to-one association to AcaAlumno
	@ManyToOne
	@JoinColumns({
		})
	private AcaAlumno acaAlumno;

	//bi-directional many-to-one association to AcaCarrera
	@ManyToOne
	@JoinColumns({
		})
	private AcaCarrera acaCarrera;

	//bi-directional many-to-one association to AcaNota
	@OneToMany(mappedBy="acaMatricula")
	private List<AcaNota> acaNotas;

	public AcaMatricula() {
	}

	public int getMtcCodigo() {
		return this.mtcCodigo;
	}

	public void setMtcCodigo(int mtcCodigo) {
		this.mtcCodigo = mtcCodigo;
	}

	public int getAlnCodigo() {
		return this.alnCodigo;
	}

	public void setAlnCodigo(int alnCodigo) {
		this.alnCodigo = alnCodigo;
	}

	public int getCarCodigo() {
		return this.carCodigo;
	}

	public void setCarCodigo(int carCodigo) {
		this.carCodigo = carCodigo;
	}

	public Timestamp getMatFechaActualiza() {
		return this.matFechaActualiza;
	}

	public void setMatFechaActualiza(Timestamp matFechaActualiza) {
		this.matFechaActualiza = matFechaActualiza;
	}

	public String getMtcEstado() {
		return this.mtcEstado;
	}

	public void setMtcEstado(String mtcEstado) {
		this.mtcEstado = mtcEstado;
	}

	public int getUsuCodigo() {
		return this.usuCodigo;
	}

	public void setUsuCodigo(int usuCodigo) {
		this.usuCodigo = usuCodigo;
	}

	public AcaAlumno getAcaAlumno() {
		return this.acaAlumno;
	}

	public void setAcaAlumno(AcaAlumno acaAlumno) {
		this.acaAlumno = acaAlumno;
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
		acaNota.setAcaMatricula(this);

		return acaNota;
	}

	public AcaNota removeAcaNota(AcaNota acaNota) {
		getAcaNotas().remove(acaNota);
		acaNota.setAcaMatricula(null);

		return acaNota;
	}

}