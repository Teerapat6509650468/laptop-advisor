package tu.comsci.laptopadvisor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import tu.comsci.laptopadvisor.model.Laptop;
import tu.comsci.laptopadvisor.service.LaptopStoreClient;

import java.util.List;

@RestController
@RequestMapping("/advisor")
public class AdvisorController {

    private final LaptopStoreClient laptopStoreClient;

    public AdvisorController(LaptopStoreClient laptopStoreClient) {
        this.laptopStoreClient = laptopStoreClient;
    }

    @GetMapping("/laptops")
    public List<Laptop> getAllLaptops() {
        return laptopStoreClient.getAllLaptops();
    }

    @PostMapping("/laptops/{id}/reserve")
    public ResponseEntity<String> orderLaptop(@PathVariable Long id) {
        try {
            boolean success = laptopStoreClient.reserveLaptop(id);
            
            if (success) {
                return ResponseEntity.status(HttpStatus.OK).body("Laptop reserved successfully!");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Laptop is already reserved or not found.");
            }
        } catch (HttpClientErrorException.BadRequest e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Laptop is already reserved or not found.");
        } catch (RestClientException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while reserving the laptop.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred.");
        }
    }
}
