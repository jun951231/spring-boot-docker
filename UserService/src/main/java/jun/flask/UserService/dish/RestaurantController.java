package jun.flask.UserService.dish;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
public class RestaurantController {
    private final KitchenService kitchen;
    @GetMapping(value="/dishes", produces = "application/json; charset=utf8")
    Flux<Dish> serveDishes(){
        return kitchen.getDishes();
    }
}

