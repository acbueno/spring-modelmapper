package br.com.acbueno.modelmapper.dto.output;

import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarOutPut {
	
	@NotEmpty
	@JsonProperty("id")
	private Long id;
	
	@NotEmpty
	@JsonProperty("model-name")
	private String modelName;
	
	@NotEmpty
	@JsonProperty("model-version")
	private String modelVersion;
	
	@NotEmpty
	@JsonProperty("brand-name")
	private String brandName;

}
