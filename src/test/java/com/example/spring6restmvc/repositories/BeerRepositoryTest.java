package com.example.spring6restmvc.repositories;

import com.example.spring6restmvc.entities.Beer;
import com.example.spring6restmvc.model.BeerStyle;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testSaveBeer() {
        Beer savedBeer = beerRepository.save(Beer.builder()
                .beerName("My Beer")
                        .beerStyle(BeerStyle.PALE_ALE)
                        .upc("1595911365 ")
                        .price(new BigDecimal("105.00"))
                .build());

        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }

    @Test
    void testSaveBeerNameTooLong() {

        assertThrows(ConstraintViolationException.class, () -> {
            Beer savedBeer = beerRepository.save(Beer.builder()
                    .beerName("My Beer eibcccunbtiefiudufbhvldjdvfbdbfebgludrdtblndeibcccunbtieiktivilefejuhhvfdfrtehnfuirhilnj")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("1595911365 ")
                    .price(new BigDecimal("105.00"))
                    .build());

            beerRepository.flush();
        });
    }
}