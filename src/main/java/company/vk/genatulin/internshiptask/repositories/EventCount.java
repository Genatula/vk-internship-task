package company.vk.genatulin.internshiptask.repositories;

public class EventCount {
    private String name;
    private Long total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public EventCount(String name, Long total) {
        this.name = name;
        this.total = total;
    }
}
