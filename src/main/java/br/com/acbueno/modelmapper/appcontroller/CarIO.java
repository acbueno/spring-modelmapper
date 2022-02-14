package br.com.acbueno.modelmapper.appcontroller;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import br.com.acbueno.modelmapper.dto.input.CarInput;
import br.com.acbueno.modelmapper.model.Car;

@Component("carIO")
public class CarIO {

	private ModelMapper modelMapper;

	final Converter<CarInput, Car> carConverter = new Converter<CarInput, Car>() {

		@Override
		public Car convert(MappingContext<CarInput, Car> context) {
			CarInput carInput = context.getSource();
			Car car = new Car();
			car.setModelName(carInput.getModelName());
			car.setModelVersion(carInput.getModelVersion());
			car.setBrandName(carInput.getBrandName());

			return car;
		}
	};

	public CarIO() {
		modelMapper = new ModelMapper();
		modelMapper.addConverter(carConverter);
	}

	public Car mapTo(CarInput carInput) {
		return this.modelMapper.map(carInput, Car.class);
	}

}
