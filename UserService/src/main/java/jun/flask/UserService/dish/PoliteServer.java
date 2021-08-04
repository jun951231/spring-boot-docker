package jun.flask.UserService.dish;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
/**
 * 주방장의 생성자 주입으로 받는다(연관관계)
 * kitchen.getDishes() 는 알바가 주방에 가서 가져오는 모습이다.
 * 요리가 완성되면 즉시 손님에게 전달한다....map()
 * Reactive Consumer 는 다른 Reactive Service 를 호출하고 결과를 변환(transform)한다
 * 서빙 점원의 역할은 웹 컨트롤이다.
 * */
@RequiredArgsConstructor
public class PoliteServer {

    private final KitchenService kitchen;

    Flux<Dish> doingMyJob(){
        return kitchen.getDishes()
                .doOnNext(dish -> System.out.println("감사합니다." + dish))
                .doOnError(error -> System.out.println(error.getMessage()+ "때문에 죄송합니다."))
                .doOnComplete(() -> System.out.println("모든 것이 감사합니다."))
                .map(Dish::deliver);
    }
}
