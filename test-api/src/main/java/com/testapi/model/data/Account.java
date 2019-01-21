package com.testapi.model.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
	@Id
	@JsonView(CREDITIONALS.class)
	@NonNull
	private String login;

	@JsonView(DATA.class)
	@NonNull
	private String firstName;

	@JsonView(DATA.class)
	@NonNull
	private String lastName;

	@EqualsAndHashCode.Exclude
	@JsonView(CREDITIONALS.class)
	@NonNull
	private String password;

	@JsonIgnore
	@EqualsAndHashCode.Exclude
	@OneToOne
	private Token token;


	public static class CREDITIONALS {}

	public static class DATA {}
}
