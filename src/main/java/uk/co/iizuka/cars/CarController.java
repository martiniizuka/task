package uk.co.iizuka.cars;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {
  private CarManager carManager;

  public CarController(final CarManager carManager) {
    this.carManager = carManager;
  }

  @GetMapping
  public List<Car> getAllCars() {
    return carManager.getAll();
  }
}
