package jun.flask.UserService.dish;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

class MapAndFlatMapTest {
    @Mock
    MapAndFlatMap mock;
    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        mock = new MapAndFlatMap();
    }

    @DisplayName("map() vs flatMap() 테스트")
    @Test
    void subscirbe(){
        System.out.println("\n # mapMethod");
        mock.mapMethod().subscribe(len -> System.out.println(len+"\t"));
        System.out.println("\n # flatMapMethod");
        mock.flatMapMethod().subscribe(System.out::println);
        System.out.println("\n # filterMethod");
        mock.filterMethod().subscribe(x -> System.out.println(x + " -> "));
    }
}