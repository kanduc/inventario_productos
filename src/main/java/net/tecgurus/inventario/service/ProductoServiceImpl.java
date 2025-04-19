package net.tecgurus.inventario.service;

import net.tecgurus.inventario.dto.ProductoDto;
import net.tecgurus.inventario.entity.ProductoEntity;
import net.tecgurus.inventario.mapper.ProductoMapper;
import net.tecgurus.inventario.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public List<ProductoDto> getAllProductos() {
        return productoRepository.findAll().stream()
                .map(productoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDto getProductoById(Long id) {
        return productoRepository.findById(id)
                .map(productoMapper::toDto)
                .orElse(null);
    }

    @Override
    public ProductoDto createProducto(ProductoDto productoDto) {
        ProductoEntity producto = productoMapper.toEntity(productoDto);
        ProductoEntity savedProducto = productoRepository.save(producto);
        return productoMapper.toDto(savedProducto);
    }

    @Override
    public ProductoDto updateProducto(Long id, ProductoDto productoDto) {
        if (productoRepository.existsById(id)) {
            ProductoEntity producto = productoMapper.toEntity(productoDto);
            producto.setId(id);
            ProductoEntity updatedProducto = productoRepository.save(producto);
            return productoMapper.toDto(updatedProducto);
        }
        return null;
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }
}