package company.vk.genatulin.internshiptask.services;

import java.util.Date;
import java.util.List;

import company.vk.genatulin.internshiptask.dto.CountMessage;
import org.springframework.stereotype.Service;

import company.vk.genatulin.internshiptask.dto.ClientEvent;

@Service
public interface EventService {
    public Boolean addEvent(ClientEvent event, String ip, Date date);

    List<CountMessage> aggregateByNameAndFilterByNameAndDate(String name, String date);

    List<CountMessage> aggregateByNameAndFilterByName(String name);

    List<CountMessage> aggregateByNameAndFilterByDate(String date);

    List<CountMessage> aggregateByName();

    List<CountMessage> aggregateByUserAndFilterByNameAndDate(String name, String date);

    List<CountMessage> aggregateByUserAndFilterByName(String name);

    List<CountMessage> aggregateByUserAndFilterByDate(String date);

    List<CountMessage> aggregateByUser();

    List<CountMessage> aggregateByStatusAndFilterByNameAndDate(String name, String date);

    List<CountMessage> aggregateByStatusAndFilterByName(String name);

    List<CountMessage> aggregateByStatusAndFilterByDate(String date);

    List<CountMessage> aggregateByStatus();
}
