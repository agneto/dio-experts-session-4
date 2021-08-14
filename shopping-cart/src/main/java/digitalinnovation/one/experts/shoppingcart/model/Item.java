package digitalinnovation.one.experts.shoppingcart.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@RedisHash("item")
public class Item {

    private Long productId;
    private Integer amount;
}
