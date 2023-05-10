package company.vk.genatulin.internshiptask.repositories;

import company.vk.genatulin.internshiptask.entities.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
    boolean save(Event event);
    @Query("select new company.vk.genatulin.internshiptask.repositories.EventCount(e.name, count(e.name)) from Event e" +
            " where e.date = :date group by e.name")
    List<EventCount> getEventByDateAndGroupedByName(@Param("date") Date date);
    @Query("select new company.vk.genatulin.internshiptask.repositories.EventCount(e.name, count(e.name)) from Event e" +
            " where e.name = :name group by e.name")
    List<EventCount> getEventByNameAndGroupedByName(@Param("name") String name);
    @Query("select new company.vk.genatulin.internshiptask.repositories.EventCount(e.name, count(e.name)) from Event e" +
            " where e.name = :name and e.date = :date group by e.name")
    List<EventCount> getEventByNameAndByDateAndGroupedByName(@Param("name") String name, @Param("date") Date date);
    @Query("select new company.vk.genatulin.internshiptask.repositories.IpAddressCount(e.numericIp, count(e.numericIp)) from Event e" +
            " where e.name = :name group by e.numericIp")
    List<IpAddressCount> getEventByNameAndGroupedByIpAddr(@Param("name") String name);
    @Query("select new company.vk.genatulin.internshiptask.repositories.IpAddressCount(e.numericIp, count(e.numericIp)) from Event e" +
            " where e.date = :date group by e.numericIp")
    List<IpAddressCount> getEventByDateAndGroupedByIpAddr(@Param("date") Date date);
    @Query("select new company.vk.genatulin.internshiptask.repositories.IpAddressCount(e.numericIp, count(e.numericIp)) from Event e" +
            " where e.date = :date and e.name = :name group by e.numericIp")
    List<IpAddressCount> getEventByDateAndNameAndGroupedByIpAddr(@Param("name") String name, @Param("date") Date date);
    @Query("select new company.vk.genatulin.internshiptask.repositories.StatusCount(e.isAuthorised, count(e.isAuthorised)) from Event e" +
            " where e.date = :date group by e.isAuthorised")
    List<StatusCount> getEventByDateAndGroupedByStatus(@Param("date") Date date);
    @Query("select new company.vk.genatulin.internshiptask.repositories.StatusCount(e.isAuthorised, count(e.isAuthorised)) from Event e" +
            " where e.name = :name group by e.isAuthorised")
    List<StatusCount> getEventByNameAndGroupedByStatus(@Param("name") String name);
    @Query("select new company.vk.genatulin.internshiptask.repositories.StatusCount(e.isAuthorised, count(e.isAuthorised)) from Event e" +
            " where e.date = :date and e.name = :name group by e.isAuthorised")
    List<StatusCount> getEventByDateAndNameAndGroupedByStatus(@Param("date") Date date, @Param("name") String name);
    @Query("select new company.vk.genatulin.internshiptask.repositories.EventCount(e.name, count(e.name)) from Event e" +
            " group by e.name")
    List<EventCount> getEventsGroupedByName();
    @Query("select new company.vk.genatulin.internshiptask.repositories.IpAddressCount(e.numericIp, count(e.numericIp)) from Event e" +
            " group by e.numericIp")
    List<IpAddressCount> getEventsGroupedByIpAddr();
    @Query("select new company.vk.genatulin.internshiptask.repositories.StatusCount(e.isAuthorised, count(e.isAuthorised)) from Event e" +
            " group by e.isAuthorised")
    List<StatusCount> getEventsGroupedByStatus();
}
