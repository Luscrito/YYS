package microservicedemo.injournalservice.mapper;


import microservicedemo.injournalservice.po.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductMapper {
    @Select("select id,p.product_name as productName,p.price as price ,stock from product p where id = #{productId}")
    Product findByProductId(@Param("productId") Long productId);
    @Select("select *  from product p")
    @Result(property = "productName", column = "product_name")
    List<Product> queryAllProduct();
    @Insert("insert into product(product_name, price,stock) values (#{productName},#{price},#{stock})")
    void addProduct(Product product);
    @Update("update product set product_name=#{productName},price=#{price},stock=#{stock} where #{id}=id")
    void updateProduct(Product product);
    @Delete("delete from product where id=#{id}")
    void deleteProduct(long id);
    @Update("update product set stock = #{stock} where id = #{id}")
    void in(Product product);
}
