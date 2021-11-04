package org.springframework.samples.petclinic.repository.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@Primary
public class RestVetRepository implements VetRepository {

    private static final Logger logger = LoggerFactory.getLogger(RestVetRepository.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${rest.url.vets}")
    private String vetUrl;

    @Override
    public Collection<Vet> findAll() {

        ArrayList<Vet> vetList = new ArrayList<Vet>();

        // Call Vets REST service
        logger.info("Calling Vets REST API at: {}",vetUrl);
        ResponseEntity<Vet[]> response = restTemplate.getForEntity(
            vetUrl,
            Vet[].class);

        logger.info("Vets REST API responded with: {}",response.getStatusCode());

        // If the response was successful, converst to List.
        if (response.getStatusCode().is2xxSuccessful()) {
            vetList.addAll(Arrays.asList(response.getBody()));
        }
        return vetList;
    }

}
