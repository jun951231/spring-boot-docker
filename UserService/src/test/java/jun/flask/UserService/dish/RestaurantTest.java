package jun.flask.UserService.dish;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RestaurantTest {
    @Mock
    Restaurant mock;
    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        mock = new Restaurant();
    }

    @DisplayName("PUB-SUB 구독 테스트")
    @Test
    void test_subscribe(){
        mock.subscribe();
    }
}