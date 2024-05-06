package harshal.temkar.reservation_service.model;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "RESERVATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation implements Serializable {

	@Id
	@GeneratedValue
    @UuidGenerator(style = Style.TIME)
	@Column(name = "ID")
	private String id;

	@NotBlank
	@Column(name = "CUSTOMER_ID")
    private String customerid;
	
	@NotBlank
	@Column(name = "HOTEL_ID")
    private String hotelid;
	
	@Column(name = "CHECK_IN_DATE")
    private Date checkindate;
	
	@Column(name = "CHECK_OUT_DATE")
    private Date checkoutdate;
}
