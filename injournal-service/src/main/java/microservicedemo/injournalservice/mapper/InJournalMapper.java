package microservicedemo.injournalservice.mapper;

import microservicedemo.injournalservice.po.InJournal;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InJournalMapper {
    @Select("select * from in_journal")
    @Result(property = "productId", column = "product_id")
    @Result(property = "inTime", column = "in_time")
    List<InJournal> getAllInJournal();

    @Insert("insert into in_journal(product_id, in_time, number, cost) VALUES (#{productId},#{inTime},#{number},#{cost})")
    void add(InJournal inJournal);

    @Update("update tb_product.in_journal set product_id=#{productId},in_time=#{inTime},number=#{number},cost=#{cost} where id = #{id}")
    void update(InJournal inJournal);

}
