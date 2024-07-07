package com.example.online_store.mapper;

import com.example.online_store.dto.ProductAvailabilityDTO;
import com.example.online_store.dto.ProductCheckAvailabilityDTO;
import com.example.online_store.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "partNumberId", source = "partNumberId")
    @Mapping(target = "storeAddress", source = "address")
    ProductAvailabilityDTO toAvailabilityDTO(Product product);

    @Mapping(target = "address", source = "address")
    @Mapping(target = "partNumberId", expression = "java(Long.parseLong(dto.getPartNumber()))")
    @Mapping(target = "cost", source = "cost")
    Product toProduct(ProductCheckAvailabilityDTO dto);
}

