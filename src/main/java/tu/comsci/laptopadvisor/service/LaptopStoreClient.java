package tu.comsci.laptopadvisor.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tu.comsci.laptopadvisor.model.Laptop;

import java.util.List;

@Service
public class LaptopStoreClient {

    private final RestTemplate restTemplate;

    public LaptopStoreClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Laptop> getAllLaptops() {
        String url = "http://localhost:8080/laptops"; 

        ResponseEntity<List<Laptop>> response = restTemplate.exchange(
                url, 
                org.springframework.http.HttpMethod.GET, 
                null, 
                new org.springframework.core.ParameterizedTypeReference<List<Laptop>>() {}
        );

        return response.getBody();
    }
    
    public boolean reserveLaptop(Long id) {
        String url = "http://localhost:8080/laptops/" + id + "/reserve"; 

        ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class);

        return response.getStatusCode().is2xxSuccessful();
    }
}
