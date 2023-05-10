package company.vk.genatulin.internshiptask.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import company.vk.genatulin.internshiptask.converters.BooleanToStatusConverter;
import company.vk.genatulin.internshiptask.converters.NumericToStringIpConverter;
import company.vk.genatulin.internshiptask.converters.StringToDateConverter;
import company.vk.genatulin.internshiptask.converters.StringToNumericIpConverter;
import company.vk.genatulin.internshiptask.dto.CountMessage;
import org.springframework.beans.factory.annotation.Autowired;

import company.vk.genatulin.internshiptask.dto.ClientEvent;
import company.vk.genatulin.internshiptask.entities.Event;
import company.vk.genatulin.internshiptask.repositories.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final StringToNumericIpConverter ipConvertor;
    private final StringToDateConverter stringToDateConverter;
    private final NumericToStringIpConverter numericToStringIpConverter;
    private final BooleanToStatusConverter booleanToStatusConverter;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, StringToNumericIpConverter ipConvertor, StringToDateConverter stringToDateConverter, NumericToStringIpConverter numericToStringIpConverter, BooleanToStatusConverter booleanToStatusConverter) {
        this.eventRepository = eventRepository;
        this.ipConvertor = ipConvertor;
        this.stringToDateConverter = stringToDateConverter;
        this.numericToStringIpConverter = numericToStringIpConverter;
        this.booleanToStatusConverter = booleanToStatusConverter;
    }

    @Override
    public Boolean addEvent(ClientEvent event, String ip, Date date) {
        Event eventToSave = new Event();

        eventToSave.setName(event.getName());
        eventToSave.setIsAuthorised(event.getIsAuthorised());
        eventToSave.setNumericIp(ipConvertor.convert(ip));
        eventToSave.setDate(date);

        return eventRepository.save(eventToSave);
    }

    @Override
    public List<CountMessage> aggregateByNameAndFilterByNameAndDate(String name, String date) {
        return eventRepository.getEventByNameAndByDateAndGroupedByName(name, stringToDateConverter.convert(date))
                .stream()
                .map(eventCount -> new CountMessage(eventCount.getName(), eventCount.getTotal()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CountMessage> aggregateByNameAndFilterByName(String name) {
        return eventRepository.getEventByNameAndGroupedByName(name)
                .stream()
                .map(eventCount -> new CountMessage(eventCount.getName(), eventCount.getTotal()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CountMessage> aggregateByNameAndFilterByDate(String date) {
        return eventRepository.getEventByDateAndGroupedByName(stringToDateConverter.convert(date))
                .stream()
                .map(eventCount -> new CountMessage(eventCount.getName(), eventCount.getTotal()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CountMessage> aggregateByName() {
        return eventRepository.getEventsGroupedByName()
                .stream()
                .map(eventCount -> new CountMessage(eventCount.getName(), eventCount.getTotal()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CountMessage> aggregateByUserAndFilterByNameAndDate(String name, String date) {
        return eventRepository.getEventByDateAndNameAndGroupedByIpAddr(name, stringToDateConverter.convert(date))
                .stream()
                .map(ipAddressCount -> new CountMessage(numericToStringIpConverter.convert(ipAddressCount.getIpAddr()), ipAddressCount.getTotal()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CountMessage> aggregateByUserAndFilterByName(String name) {
        return eventRepository.getEventByNameAndGroupedByIpAddr(name)
                .stream()
                .map(ipAddressCount -> new CountMessage(numericToStringIpConverter.convert(ipAddressCount.getIpAddr()), ipAddressCount.getTotal()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CountMessage> aggregateByUserAndFilterByDate(String date) {
        return eventRepository.getEventByDateAndGroupedByIpAddr(stringToDateConverter.convert(date))
                .stream()
                .map(ipAddressCount -> new CountMessage(numericToStringIpConverter.convert(ipAddressCount.getIpAddr()), ipAddressCount.getTotal()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CountMessage> aggregateByUser() {
        return eventRepository.getEventsGroupedByIpAddr()
                .stream()
                .map(ipAddressCount -> new CountMessage(numericToStringIpConverter.convert(ipAddressCount.getIpAddr()), ipAddressCount.getTotal()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CountMessage> aggregateByStatusAndFilterByNameAndDate(String name, String date) {
        return eventRepository.getEventByDateAndNameAndGroupedByStatus(stringToDateConverter.convert(date), name)
                .stream()
                .map(statusCount -> new CountMessage(booleanToStatusConverter.convert(statusCount.getStatus()), statusCount.getTotal()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CountMessage> aggregateByStatusAndFilterByName(String name) {
        return eventRepository.getEventByNameAndGroupedByStatus(name)
                .stream()
                .map(statusCount -> new CountMessage(booleanToStatusConverter.convert(statusCount.getStatus()), statusCount.getTotal()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CountMessage> aggregateByStatusAndFilterByDate(String date) {
        return eventRepository.getEventByDateAndGroupedByStatus(stringToDateConverter.convert(date))
                .stream()
                .map(statusCount -> new CountMessage(booleanToStatusConverter.convert(statusCount.getStatus()), statusCount.getTotal()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CountMessage> aggregateByStatus() {
        return eventRepository.getEventsGroupedByStatus()
                .stream()
                .map(statusCount -> new CountMessage(booleanToStatusConverter.convert(statusCount.getStatus()), statusCount.getTotal()))
                .collect(Collectors.toList());
    }

}
