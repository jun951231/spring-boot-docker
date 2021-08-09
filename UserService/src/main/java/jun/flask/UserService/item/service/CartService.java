package jun.flask.UserService.item.service;


import jun.flask.UserService.item.entity.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jun.flask.UserService.item.repository.CartRepository;
import jun.flask.UserService.item.repository.ItemRepository;
import reactor.core.publisher.Mono;

@Service @RequiredArgsConstructor
public class CartService {
    Mono<Cart> addToCart(String cartId, String id){
        return null;
    }
}
