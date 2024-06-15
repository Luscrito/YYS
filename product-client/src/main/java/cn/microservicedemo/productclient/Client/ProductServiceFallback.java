package cn.microservicedemo.productclient.Client;

import cn.microservicedemo.productclient.model.Product;
import cn.microservicedemo.productclient.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ProductServiceFallback implements ProductServiceClient{
    @Override
    public Product findByProductId(Long productId) {
        log.info("findByProductId callback");
        return null;
    }
    @Override
    public List<Product> queryAllProduct() {
        log.info("queryAllProduct callback");
        return null;
    }
    @Override
    public List<Product> queryAl() {
        return null;
    }

    @Override
    public Result deleteById(long id) {
        return new Result(0);
    }

    @Override
    public Result add(Product product) {
        return new Result(0);
    }

    @Override
    public Result update(Product product) {
        return new Result(0);
    }
}
