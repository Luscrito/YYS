package microservicedemo.injournalservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservicedemo.injournalservice.mapper.InJournalMapper;
import microservicedemo.injournalservice.mapper.ProductMapper;
import microservicedemo.injournalservice.po.InJournal;
import microservicedemo.injournalservice.po.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
public class InJournalController {
    @Autowired
    private InJournalMapper inJournalMapper;
    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/queryAllInJournal")
    List<InJournal> getAllInJournal(){
        List<InJournal> allInJournal = inJournalMapper.getAllInJournal();
        log.info("-------------OK queryAllInJournal--------------------");
        return allInJournal;
    }

    @PostMapping("/inJournal/add")
    public void addProduct(@RequestBody InJournal inJournal){
        inJournal.setInTime(LocalDateTime.now());
        log.info("-------------OK add InJournal!-------------");
        inJournalMapper.add(inJournal);
        Product p = productMapper.findByProductId((long) inJournal.getProductId());
        int num = p.getStock()+inJournal.getNumber();
        p.setStock(num);
        System.out.println(p.getStock());
        System.out.println(p.getId());
        productMapper.in(p);
    }

    @PutMapping("/inJournal/update")
    public void update(@RequestBody InJournal inJournal){
        inJournalMapper.update(inJournal);
    }
}
