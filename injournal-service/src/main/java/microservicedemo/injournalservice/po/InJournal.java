package microservicedemo.injournalservice.po;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class InJournal {
    int id;
    int productId;
    LocalDateTime inTime;
    int number;
    double cost;

}
