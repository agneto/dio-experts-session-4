package one.digitalinnovation.experts.productcatalog.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "product", type = "catalog")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Product {
    @Id
    private Long id;
    private String name;
    private Integer amount;
}
