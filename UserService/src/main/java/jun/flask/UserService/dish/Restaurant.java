package jun.flask.UserService.dish;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import lombok.Data;


@Data final class Dish {
    private String description;
    private boolean delivered = false;

    Dish(String description){
        this.description = description;
    }

    public static Dish deliver(Dish dish){
        Dish deliveredDish = new Dish(dish.description);
        deliveredDish.delivered = true;
        return deliveredDish;
    }
    @Override
    public String toString(){
        return delivered ? description + " 먹는다" : description +" 기다린다";
    }
}
@Service final class KitchenService {
    Flux<Dish> getDishes() {
        return Flux.just(
                new Dish("김치찌개"),
                new Dish("떡볶이"),
                new Dish("삼계탕"));
    }
}
@Data class PrototypeServer {
    private final KitchenService kitchen;
    Flux<Dish> doingMyJob() {
        return kitchen.getDishes().map(dish -> Dish.deliver((dish)));
    }
}
@Data class AdvancedServer{
    private final KitchenService kitchen;
    Flux<Dish> doingMyJob(){
        return kitchen.getDishes()
                .doOnNext(dish -> System.out.println(dish))
                .doOnError(error -> System.out.println(error.getMessage()))
                .doOnComplete(() -> System.out.println("모든 주문이 완료되었다."))
                .map(Dish::deliver);
    }
}
public final class Restaurant {
    public void subscribe(){
        AdvancedServer server = new AdvancedServer(new KitchenService());
        server.doingMyJob().subscribe(
                dish -> System.out.println(dish),
                throwable -> System.out.println(throwable)
        );
    }
}



