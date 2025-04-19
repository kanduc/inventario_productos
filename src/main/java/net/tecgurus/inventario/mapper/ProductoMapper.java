package net.tecgurus.inventario.mapper;

import net.tecgurus.inventario.dto.ProductoDto;
import net.tecgurus.inventario.entity.ProductoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ProductoDto toDto(ProductoEntity entity){
        return modelMapper.map(entity, ProductoDto.class);
    }

    public ProductoEntity toEntity(ProductoDto dto){
        return modelMapper.map(dto, ProductoEntity.class);
    }
}
