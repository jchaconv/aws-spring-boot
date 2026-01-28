package com.vilelo.customerservice.mapper;

import com.vilelo.customerservice.dto.CustomerDto;
import com.vilelo.customerservice.dto.MovieDto;
import com.vilelo.customerservice.entity.Customer;

import java.util.List;

public class EntityDtoMapper {

    public static CustomerDto toDto(Customer customer, List<MovieDto> movies){
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getFavoriteGenre(),
                movies
        );
    }

}
