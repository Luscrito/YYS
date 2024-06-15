package cn.microservicedemo.injournalclient.Client;

import cn.microservicedemo.injournalclient.model.InJournal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="injournal-service")
public interface InJournalServiceClient {
    @GetMapping("queryAllInJournal")
    List<InJournal> queryAllInJournal();

    @PostMapping("/inJournal/add")
    void add(@RequestBody InJournal inJournal);

    @PutMapping("/inJournal/update")
    void update(@RequestBody InJournal inJournal);
}
