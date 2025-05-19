package com.example.spring6restmvc.bootstrap;

import com.example.spring6restmvc.entities.Beer;
import com.example.spring6restmvc.entities.Customer;
import com.example.spring6restmvc.model.BeerDTO;
import com.example.spring6restmvc.model.BeerStyle;
import com.example.spring6restmvc.model.CustomerDTO;
import com.example.spring6restmvc.repositories.BeerRepository;
import com.example.spring6restmvc.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
        loadCustomerData();
    }

    private void loadBeerData() {
        if (beerRepository.count() > 0) {
            return;
        }

        Beer beer1 = Beer.builder()
                .beerName("Vaquita Marina")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("123456789")
                .price(new BigDecimal("45.00"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer2 = Beer.builder()
                .beerName("Foca Parlante")
                .beerStyle(BeerStyle.STOUT)
                .upc("1234222")
                .price(new BigDecimal("47.00"))
                .quantityOnHand(392)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer3 = Beer.builder()
                .beerName("Perro del Mar")
                .beerStyle(BeerStyle.IPA)
                .upc("112435")
                .price(new BigDecimal("50.00"))
                .quantityOnHand(144)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        beerRepository.save(beer1);
        beerRepository.save(beer2);
        beerRepository.save(beer3);
    }

    private void loadCustomerData() {
        if (customerRepository.count() > 0) {
            return;
        }

        Customer customer1 = Customer.builder()
                .name("John Doe")
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .name("Jane Doe")
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        Customer customer3 = Customer.builder()
                .name("Pedro Rodiguez")
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));
    }

}
