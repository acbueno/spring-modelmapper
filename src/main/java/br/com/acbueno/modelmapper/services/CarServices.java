package br.com.acbueno.modelmapper.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.acbueno.modelmapper.model.Car;
import br.com.acbueno.modelmapper.repository.CarRepository;

@Service
public class CarServices {
	
	@Autowired
	private CarRepository carRepository;
	
	public List<Car> findAll(){
		return carRepository.findAll();
	}
	
	public Optional<Car> findById(Long id) {
		return carRepository.findById(id);
	}
	
	public Car create(Car car) {
		return carRepository.save(car);
	}
	
	public Car update(Long id, Car newCar) throws Exception {
		Car car = carRepository.getOne(id);
		if(car == null) {
			throw new Exception();
		}
		
		if(car.getId() != id) {
			throw new IllegalArgumentException();
		}
		
		newCar.setId(id);
		Car carDb = carRepository.save(newCar);
		
		return carDb;
	}
	
	public void delete(Long id) {
		carRepository.deleteById(id);
	}

}
