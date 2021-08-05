package jun.flask.UserService.item.repository;

import jun.flask.UserService.item.entity.Cart;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CartRepository extends ReactiveCrudRepository<Cart, String>{
}
