package com.innoventes.test.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "company")
@Entity
public class Company extends BaseEntity {



	@Id
	@SequenceGenerator(sequenceName = "company_seq", allocationSize = 1, name = "company_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
	private Long id;

	@Column(name = "company_name")
	@NotNull(message = "Email cannot be NULL")
	private String companyName;

	@Column(name = "email")
    @NotNull(message = "Email cannot be NULL")
	private String email;
	
	@Column(name = "strength")
	@Min(value=0)
	private Integer strength;
	
	@Column(name = "website_url")
	private String webSiteURL;
	
	@Column(name= "company_code", unique = true,length = 5)
	@UniqueElements
	private String companyCode;

	@Override
	public Long getId() {
		
		return id;
	}
}
