package br.com.acbueno.modelmapper.controller;

import java.lang.reflect.Type;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.acbueno.modelmapper.appcontroller.AppControllerBase;
import br.com.acbueno.modelmapper.appcontroller.CarIO;
import br.com.acbueno.modelmapper.dto.input.CarInput;
import br.com.acbueno.modelmapper.dto.output.CarOutPut;
import br.com.acbueno.modelmapper.model.Car;
import br.com.acbueno.modelmapper.services.CarServices;

@RestController
@RequestMapping(path = "/api/cars")
@CrossOrigin
public class CarController {
	
	@Autowired
	private CarServices carServices;
	
	@Autowired
	private AppControllerBase appControllerBase;
	
	@Autowired
	private CarIO carIO;
	
	@PostMapping({ "/", "" })
	public ResponseEntity<Object> createCar(@Valid @RequestBody CarInput car) {
		Car carModel = carIO.mapTo(car);
		Car savedCard = carServices.create(carModel);

		//@// @formatter:off
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedCard.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
		// @formatter:on
	}
	
	@GetMapping({"/", ""})
	public ResponseEntity<?> getAllPost() {
		Type type = new TypeToken<List<CarOutPut>>() {}.getType();
		List<CarOutPut> result = appControllerBase.toList(carServices.findAll(), type);
		
		return ResponseEntity.ok(result);
	}
	
	@PutMapping({"/{id}", "/{id}"})
	public ResponseEntity<?> updateCar(@Min(value = 1) @PathVariable("id") Long id, @RequestBody CarInput car)
			throws Exception {
		Car value = carIO.mapTo(car);
		carServices.update(id, value);

		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping({"/{id}", "/{id}"})
	public ResponseEntity<?> deleteCar(@PathVariable("id") Long id) {
		carServices.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping({"/{id}", "/{id}"})
	public CarOutPut findCarById(@PathVariable("id") Long id) {
		return appControllerBase.mapTo(carServices.findById(id), CarOutPut.class);
	}

}
