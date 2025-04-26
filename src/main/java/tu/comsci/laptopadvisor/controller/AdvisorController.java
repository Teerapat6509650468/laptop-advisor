package tu.comsci.laptopadvisor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
