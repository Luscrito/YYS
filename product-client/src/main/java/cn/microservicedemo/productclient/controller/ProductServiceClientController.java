package cn.microservicedemo.productclient.controller;

import cn.microservicedemo.productclient.model.Product;
import cn.microservicedemo.productclient.Client.ProductServiceClient;
import cn.microservicedemo.productclient.model.Result;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
public class ProductServiceClientController {
    @Autowired
    private final ProductServiceClient prodServiceClient;
    /**
     * 根据商品 id 查询商品
     */
    @GetMapping("/findByProductId/{productId}")                        //todo//
    public Product findByProductId(@PathVariable Long productId) {
        Product product = prodServiceClient.findByProductId(productId);
        log.info("-------------In client findByProductId---------------");
        return product;
    }
    @DeleteMapping("/{id}")
    public Result deleteProduct(@PathVariable long id){
        Result result = prodServiceClient.deleteById(id);
        log.info("--------------In client delete--------------");
        return result;
    }

    @PostMapping("/add")
    Result add(@RequestBody Product product){
        Result add = prodServiceClient.add(product);
        log.info("--------------In client add--------------");
        return add;
    }

    @PutMapping("/update")
    Result update(@RequestBody Product product){
        Result update = prodServiceClient.update(product);
        log.info("--------------In client update--------------");
        return update;
    }
    /**
     * 查询所有商品
     */
    @GetMapping("/queryAllProduct")
    public List<Product> findByProductId() {
        List<Product> productList = prodServiceClient.queryAllProduct();
        log.info("--------------In client queryAllProduct--------------");
        return productList;
    }


}
