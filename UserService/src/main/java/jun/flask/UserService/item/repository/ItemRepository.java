package jun.flask.UserService.item.repository;

import jun.flask.UserService.item.entity.Item;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ItemRepository extends ReactiveCrudRepository<Item, String> {
}
