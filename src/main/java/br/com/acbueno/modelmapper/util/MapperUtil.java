package br.com.acbueno.modelmapper.util;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.lang.reflect.Type;

@Component("mapperutil")
public class MapperUtil {
	
	protected ModelMapper modelMapper;
	
	public MapperUtil() {
		this.modelMapper = new ModelMapper();
	}
	
	public <S,D> List<D> toList(List<S> source, Type destClass) {
		return this.modelMapper.map(source, destClass);
	}
	
	public <S,D> D mapTo(S source, Class<D> destClass){
		return this.modelMapper.map(source, destClass);
	}

}
