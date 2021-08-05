package jun.flask.UserService.item.entity;

import lombok.Data;

@Data
public class CartItem {

    private Item item;
    private int quantity;

    private CartItem(){}

    public CartItem(Item item){
        this.item = item;
        this.quantity = 1;
    }
}
