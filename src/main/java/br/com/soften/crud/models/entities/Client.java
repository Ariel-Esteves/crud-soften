package br.com.soften.crud.models.entities;

import br.com.soften.crud.models.enums.States;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length=60, nullable=false)
	private String name;

	@Max(value = 99999999999999l)
	@Column(nullable = false)
	private long cpf;

	@Column(length=14, nullable=false)
	private String ie;

	@Max(value = 99999999l)
	@Column(nullable = false)
	private long cep;

	@Column(length=60, nullable=false)
	private String address;

	@Max(999999)
	@Column(nullable = false)
	private int number;

	@Column(length=60, nullable=false)
	private String district;

	@Column(length=60)
	private String complement;

	@Column(length=60, nullable=false)
	private String city;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private States state;




}
