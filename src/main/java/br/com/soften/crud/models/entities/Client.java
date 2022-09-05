package br.com.soften.crud.models.entities;

import br.com.soften.crud.models.enums.States;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length=60, nullable=false)
	private String name;

	@Column(nullable = false)
	private long cpf;

	@Column(length=14, nullable=false)
	private String ie;

	@Column(nullable = false)
	private long cep;

	@Column(length=60, nullable=false)
	private String address;

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

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "OrderSaleItems")
	private List<OrderSaleItems> OrderSaleItems;



}
