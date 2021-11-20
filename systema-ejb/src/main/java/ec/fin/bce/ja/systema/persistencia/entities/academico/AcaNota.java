package ec.fin.bce.ja.systema.persistencia.entities.academico;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the "aca_notas" database table.
 * 
 */
@Entity
@Table(name="aca_notas", schema = "academico")
@NamedQuery(name="AcaNota.findAll", query="SELECT a FROM AcaNota a")
public class AcaNota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="not_codigo")
	private int notCodigo;

	@Column(name="aln_codigo")
	private int alnCodigo;

	@Column(name="car_codigo")
	private int carCodigo;

	@Column(name="mat_codigo")
	private int matCodigo;

	@Column(name="mtc_codigo")
	private int mtcCodigo;

	@Column(name="not_fecha_actualiza")
	private Timestamp notFechaActualiza;

	@Column(name="not_nota_parcial")
	private BigDecimal notNotaParcial;

	@Column(name="not_tipo_parcial")
	private int notTipoParcial;

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

	//bi-directional many-to-one association to AcaMateria
	@ManyToOne
	@JoinColumns({
		})
	private AcaMateria acaMateria;

	//bi-directional many-to-one association to AcaMatricula
	@ManyToOne
	@JoinColumns({
		})
	private AcaMatricula acaMatricula;

	public AcaNota() {
	}

	public int getNotCodigo() {
		return this.notCodigo;
	}

	public void setNotCodigo(int notCodigo) {
		this.notCodigo = notCodigo;
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

	public int getMatCodigo() {
		return this.matCodigo;
	}

	public void setMatCodigo(int matCodigo) {
		this.matCodigo = matCodigo;
	}

	public int getMtcCodigo() {
		return this.mtcCodigo;
	}

	public void setMtcCodigo(int mtcCodigo) {
		this.mtcCodigo = mtcCodigo;
	}

	public Timestamp getNotFechaActualiza() {
		return this.notFechaActualiza;
	}

	public void setNotFechaActualiza(Timestamp notFechaActualiza) {
		this.notFechaActualiza = notFechaActualiza;
	}

	public BigDecimal getNotNotaParcial() {
		return this.notNotaParcial;
	}

	public void setNotNotaParcial(BigDecimal notNotaParcial) {
		this.notNotaParcial = notNotaParcial;
	}

	public int getNotTipoParcial() {
		return this.notTipoParcial;
	}

	public void setNotTipoParcial(int notTipoParcial) {
		this.notTipoParcial = notTipoParcial;
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

	public AcaMateria getAcaMateria() {
		return this.acaMateria;
	}

	public void setAcaMateria(AcaMateria acaMateria) {
		this.acaMateria = acaMateria;
	}

	public AcaMatricula getAcaMatricula() {
		return this.acaMatricula;
	}

	public void setAcaMatricula(AcaMatricula acaMatricula) {
		this.acaMatricula = acaMatricula;
	}

}