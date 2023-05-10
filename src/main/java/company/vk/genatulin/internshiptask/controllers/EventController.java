package company.vk.genatulin.internshiptask.controllers;

import company.vk.genatulin.internshiptask.dto.ClientEvent;
import company.vk.genatulin.internshiptask.dto.CountMessage;
import company.vk.genatulin.internshiptask.dto.SuccessMessage;
import company.vk.genatulin.internshiptask.services.EventService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SuccessMessage createEvent(@RequestBody ClientEvent event, HttpServletRequest request) {
        Boolean success = eventService.addEvent(event, request.getRemoteAddr(), new Date());

        return new SuccessMessage(success);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CountMessage> getEvents(@RequestParam Optional<String> name,
                                        @RequestParam Optional<String> date,
                                        @RequestParam Optional<String> aggregate) {
        List<CountMessage> response;
        if (aggregate.isPresent()) {
            String aggregateValue = aggregate.get();
            switch (aggregateValue) {
                case "name":
                    if (name.isPresent() && date.isPresent())
                        response = eventService.aggregateByNameAndFilterByNameAndDate(name.get(), date.get());
                    else if (name.isPresent()) response = eventService.aggregateByNameAndFilterByName(name.get());
                    else if (date.isPresent()) response = eventService.aggregateByNameAndFilterByDate(date.get());
                    else response = eventService.aggregateByName();
                    break;
                case "user":
                    if (name.isPresent() && date.isPresent())
                        response = eventService.aggregateByUserAndFilterByNameAndDate(name.get(), date.get());
                    else if (name.isPresent()) response = eventService.aggregateByUserAndFilterByName(name.get());
                    else if (date.isPresent()) response = eventService.aggregateByUserAndFilterByDate(date.get());
                    else response = eventService.aggregateByUser();
                    break;
                case "status":
                    if (name.isPresent() && date.isPresent())
                        response = eventService.aggregateByStatusAndFilterByNameAndDate(name.get(), date.get());
                    else if (name.isPresent()) response = eventService.aggregateByStatusAndFilterByName(name.get());
                    else if (date.isPresent()) response = eventService.aggregateByStatusAndFilterByDate(date.get());
                    else response = eventService.aggregateByStatus();
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        else {
            response = new ArrayList<>();
        }
        return response;
    }
}
