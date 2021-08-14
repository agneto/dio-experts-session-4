package one.digitalinnovation.experts.productcatalog.controller;

import lombok.RequiredArgsConstructor;
import one.digitalinnovation.experts.productcatalog.model.Product;
import one.digitalinnovation.experts.productcatalog.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Product create(@RequestBody Product product) {
        return this.productRepository.save(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Product> findById(@PathVariable Long id) {
        return this.productRepository.findById(id);
    }
}
