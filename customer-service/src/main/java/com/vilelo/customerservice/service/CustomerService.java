package com.vilelo.customerservice.service;

import com.vilelo.customerservice.client.MovieClient;
import com.vilelo.customerservice.dto.CustomerDto;
import com.vilelo.customerservice.dto.GenreUpdateRequest;
import com.vilelo.customerservice.exceptions.CustomerNotFoundException;
import com.vilelo.customerservice.mapper.EntityDtoMapper;
import com.vilelo.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final MovieClient movieClient;
    private final CustomerRepository repository;

    public CustomerService(MovieClient movieClient, CustomerRepository repository) {
        this.movieClient = movieClient;
        this.repository = repository;
    }

    public CustomerDto getCustomer(Integer id) {
        var customer = this.repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        var movies = this.movieClient.getMovies(customer.getFavoriteGenre());
        return EntityDtoMapper.toDto(customer, movies);
    }

    public void updateCustomerGenre(Integer id, GenreUpdateRequest request) {
        var customer = this.repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        customer.setFavoriteGenre(request.favoriteGenre());
        this.repository.save(customer);
    }


}
