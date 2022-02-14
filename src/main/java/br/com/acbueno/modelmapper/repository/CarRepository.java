package br.com.acbueno.modelmapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.acbueno.modelmapper.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
