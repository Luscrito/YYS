package cn.microservicedemo.injournalclient.Client;

import cn.microservicedemo.injournalclient.model.InJournal;

import java.util.List;

public class InJournalServiceFallback implements InJournalServiceClient{

    @Override
    public List<InJournal> queryAllInJournal() {
        return null;
    }

    @Override
    public void add(InJournal inJournal) {

    }

    @Override
    public void update(InJournal inJournal) {

    }
}
