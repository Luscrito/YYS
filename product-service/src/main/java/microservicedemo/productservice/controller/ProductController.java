package microservicedemo.productservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservicedemo.productservice.mapper.ProductMapper;
import microservicedemo.productservice.po.Product;
import microservicedemo.productservice.po.Result;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 商品的服务控制层
 */
@AllArgsConstructor
@RestController
@Slf4j
public class ProductController {
    private final ProductMapper productMapper;
    /**
     * 根据商品 id 查询商品
     */
    @GetMapping("/findByProductId/{productId}")
    public Product findByProductId(@PathVariable Long productId) throws InterruptedException {
        Product product = productMapper.findByProductId(productId);
        //Thread.sleep(2000);
        log.info("-------------OK /findByProductId/{productId}--------------------");
        return product;
    }
    /**
     * 查询所有商品
     */
    @GetMapping("/queryAllProduct")
    public List<Product> findByProductId() {
        List<Product> productList = productMapper.queryAllProduct();
        log.info("-------------OK queryAllProduct--------------------");
        return productList;
    }

    @PostMapping("/products/add")
    public Result addProduct(@RequestBody Product product) throws InterruptedException {
        log.info("-------------OK add Product!-------------");
        Thread.sleep(2000);
        productMapper.addProduct(product);
        return new Result(1);
    }

    @PutMapping("/products/update")
    public Result updateProduct(@RequestBody Product product){
        log.info("-------------OK update Product!-------------");
        productMapper.updateProduct(product);
        return new Result(1);
    }

    @DeleteMapping("/products/{id}")
    public Result deleteProduct(@PathVariable long id){
        log.info("Product with ID {} is being deleted.", id);
        productMapper.deleteProduct(id);
        return new Result(1);
    }

}
