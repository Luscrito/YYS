package cn.microservicedemo.injournalclient.controller;

import cn.microservicedemo.injournalclient.Client.InJournalServiceClient;
import cn.microservicedemo.injournalclient.model.InJournal;
import cn.microservicedemo.injournalclient.model.Result;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
public class InJournalController {
    @Autowired
    private InJournalServiceClient inJournalServiceClient;

    @GetMapping("/queryAllInJournal")
    public List<InJournal> findAllInJournal(){
        List<InJournal> inJournals = inJournalServiceClient.queryAllInJournal();
        log.info("--------------In client queryAllInJournal--------------");
        return inJournals;
    }
    @PostMapping("/add")
    Result add(@RequestBody InJournal inJournal){
        inJournalServiceClient.add(inJournal);
        log.info("--------------In client add--------------");
        return new Result(1);
    }
    @PutMapping("/update")
    Result update(@RequestBody InJournal inJournal){
        inJournalServiceClient.update(inJournal);
        log.info("--------------In client update--------------");
        return new Result(1);
    }
}
