package ec.fin.bce.ja.systema.persistencia.entities.academico;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the "aca_alumno" database table.
 * 
 */
@Entity
@Table(name="aca_alumno")
@NamedQuery(name="AcaAlumno.findAll", query="SELECT a FROM AcaAlumno a")
public class AcaAlumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="aln_codigo")
	private int alnCodigo;

	@Column(name="aln_apellido")
	private String alnApellido;

	@Column(name="aln_correo")
	private String alnCorreo;

	@Column(name="aln_direccion")
	private String alnDireccion;

	@Column(name="aln_estado")
	private boolean alnEstado;

	@Column(name="aln_fecha_actualiza")
	private Timestamp alnFechaActualiza;

	@Column(name="aln_identificacion")
	private String alnIdentificacion;

	@Column(name="aln_nombre")
	private String alnNombre;

	@Column(name="aln_telefono")
	private String alnTelefono;

	@Column(name="usu_codigo")
	private int usuCodigo;

	//bi-directional many-to-one association to AcaMatricula
	@OneToMany(mappedBy="acaAlumno")
	private List<AcaMatricula> acaMatriculas;

	//bi-directional many-to-one association to AcaNota
	@OneToMany(mappedBy="acaAlumno")
	private List<AcaNota> acaNotas;

	public AcaAlumno() {
	}

	public int getAlnCodigo() {
		return this.alnCodigo;
	}

	public void setAlnCodigo(int alnCodigo) {
		this.alnCodigo = alnCodigo;
	}

	public String getAlnApellido() {
		return this.alnApellido;
	}

	public void setAlnApellido(String alnApellido) {
		this.alnApellido = alnApellido;
	}

	public String getAlnCorreo() {
		return this.alnCorreo;
	}

	public void setAlnCorreo(String alnCorreo) {
		this.alnCorreo = alnCorreo;
	}

	public String getAlnDireccion() {
		return this.alnDireccion;
	}

	public void setAlnDireccion(String alnDireccion) {
		this.alnDireccion = alnDireccion;
	}

	public boolean getAlnEstado() {
		return this.alnEstado;
	}

	public void setAlnEstado(boolean alnEstado) {
		this.alnEstado = alnEstado;
	}

	public Timestamp getAlnFechaActualiza() {
		return this.alnFechaActualiza;
	}

	public void setAlnFechaActualiza(Timestamp alnFechaActualiza) {
		this.alnFechaActualiza = alnFechaActualiza;
	}

	public String getAlnIdentificacion() {
		return this.alnIdentificacion;
	}

	public void setAlnIdentificacion(String alnIdentificacion) {
		this.alnIdentificacion = alnIdentificacion;
	}

	public String getAlnNombre() {
		return this.alnNombre;
	}

	public void setAlnNombre(String alnNombre) {
		this.alnNombre = alnNombre;
	}

	public String getAlnTelefono() {
		return this.alnTelefono;
	}

	public void setAlnTelefono(String alnTelefono) {
		this.alnTelefono = alnTelefono;
	}

	public int getUsuCodigo() {
		return this.usuCodigo;
	}

	public void setUsuCodigo(int usuCodigo) {
		this.usuCodigo = usuCodigo;
	}

	public List<AcaMatricula> getAcaMatriculas() {
		return this.acaMatriculas;
	}

	public void setAcaMatriculas(List<AcaMatricula> acaMatriculas) {
		this.acaMatriculas = acaMatriculas;
	}

	public AcaMatricula addAcaMatricula(AcaMatricula acaMatricula) {
		getAcaMatriculas().add(acaMatricula);
		acaMatricula.setAcaAlumno(this);

		return acaMatricula;
	}

	public AcaMatricula removeAcaMatricula(AcaMatricula acaMatricula) {
		getAcaMatriculas().remove(acaMatricula);
		acaMatricula.setAcaAlumno(null);

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
		acaNota.setAcaAlumno(this);

		return acaNota;
	}

	public AcaNota removeAcaNota(AcaNota acaNota) {
		getAcaNotas().remove(acaNota);
		acaNota.setAcaAlumno(null);

		return acaNota;
	}

}