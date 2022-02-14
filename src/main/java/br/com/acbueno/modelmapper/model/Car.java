package br.com.acbueno.modelmapper.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "car")
@Data
public class Car implements Serializable {
	
	private static final long serialVersionUID = -7363236779847259091L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "model_name")
	private String modelName;
	
	@Column(name = "model_version")
	private String modelVersion;
	
	@Column(name = "brand_name")
	private String brandName;

}
