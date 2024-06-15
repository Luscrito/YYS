package cn.microservicedemo.productclient.Client;

import cn.microservicedemo.productclient.model.Product;
import cn.microservicedemo.productclient.model.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品服务远程调用客户端
 */
@FeignClient(name="product-service" ,fallback = ProductServiceFallback.class)
public interface ProductServiceClient {
    /**
     * 根据商品 id 获取商品对象
     * @param productId
     * @return
     */
    @GetMapping("/findByProductId/{productId}")
    Product findByProductId(@RequestParam(value = "productId") Long productId);

    @DeleteMapping("/products/{id}")
    Result deleteById(@RequestParam(value = "id") long id);

    @PostMapping("/products/add")
    Result add(@RequestBody Product product);

    @PutMapping("/products/update")
    Result update(@RequestBody Product product);
    /**
     * 获取所有商品集合
     * @return
     */
    @GetMapping("queryAllProduct")
    List<Product> queryAllProduct();
    @GetMapping("queryAllt")
    List<Product> queryAl();




}

