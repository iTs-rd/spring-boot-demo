package in.rudresh.springrestapi.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@NotNull(message = "name must not be null")
//	@NotEmpty(message = "name must not be null")
	@NotBlank(message = "name must not be null")
	private String name;

	private Long age = 0L;

	@Email(message = "please enter valid email")
	private String email;

	private String location;

//	@NotNull(message = "department must not be null")
//	@NotEmpty(message = "department must not be null")
	@NotBlank(message = "department must not be null")
	private String department;

	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updateAt;

}
