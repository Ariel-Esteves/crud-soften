package br.com.soften.crud.models.entities;

import br.com.soften.crud.models.enums.States;
import lombok.*;
import javax.persistence.*;
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

	@Column(length = 14 ,nullable = false)
	private String cpf;

	@Column(length=14, nullable=false)
	private String ie;

	@Column(length=8)
	private String cep;

	@Column(length=60, nullable=false)
	private String address;

	@Column(length=6, nullable = false)
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
