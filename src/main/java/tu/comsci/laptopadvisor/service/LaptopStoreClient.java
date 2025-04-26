package tu.comsci.laptopadvisor.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import tu.comsci.laptopadvisor.model.Laptop;

import java.util.List;

@Service
public class LaptopStoreClient {

    private final RestClient restClient;

    public LaptopStoreClient(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("http://localhost:8080") // LaptopStore running on port 8080
                .build();
    }

    public List<Laptop> getAllLaptops() {
        return restClient.get()
                .uri("/laptops") // This must match LaptopStore API
                .retrieve()
                .body(new ParameterizedTypeReference<List<Laptop>>() {});
    }
}
