package digitalinnovation.one.experts.shoppingcart.controller;

import digitalinnovation.one.experts.shoppingcart.model.Cart;
import digitalinnovation.one.experts.shoppingcart.model.Item;
import digitalinnovation.one.experts.shoppingcart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartRepository cartRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Cart addItems(@PathVariable("id") Long id, @RequestBody Item item) {
        Optional<Cart> savedCart = this.cartRepository.findById(id);

        Cart cart = savedCart.equals(Optional.empty()) ? new Cart(id) : savedCart.get();

        cart.getItems().add(item);
        return this.cartRepository.save(cart);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Cart> findById(@PathVariable("id") Long id) {
        return this.cartRepository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void clear(@PathVariable Long id) {
        this.cartRepository.deleteById(id);
    }

}
