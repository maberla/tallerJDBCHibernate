import java.security.acl.Owner;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="facturas", schema ="petclinic")
public class Bill {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Digits(integer = 10, fraction = 0)
	@NotEmpty
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pago")
	@NotEmpty
	private Date fecha_pago;
	
	@Column(name="cuantia")
	@NotEmpty
	private double cuantia;
	
	@ManyToOne
	@JoinColumn(name = "owner")
    private Owner owner;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "bill", cascade = CascadeType.ALL)
	@JoinColumn(name="owner")
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getFecha_pago() {
		return fecha_pago;
	}
	public void setFecha_pago(Date fecha_pago) {
		this.fecha_pago = fecha_pago;
	}
	public double getCuantia() {
		return cuantia;
	}
	public void setCuantia(double cuantia) {
		this.cuantia = cuantia;
	}
	
	
}


