package jun.flask.UserService.dish;

import reactor.core.publisher.Flux;

public class MapAndFlatMap {
    public Flux<Integer> mapMethod(){
        return Flux.just("a", "bc", "def", "wxyz").map(str -> str.length());
        //문자열을 Integer 값으로 1-1 변환
    }
    public Flux<Integer> flatMapMethod(){
        return Flux.just(1, 2, 3).flatMap(i -> Flux.range(1, i));
        // Integer를 Flux<Integer>로 1-N로 변환
    }

    public Flux<Integer> filterMethod(){
        return Flux.range(1, 10).filter(num -> num % 2 == 0);
    }
}
