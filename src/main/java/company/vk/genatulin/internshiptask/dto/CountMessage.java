package company.vk.genatulin.internshiptask.dto;

public class CountMessage {
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    private String value;
    private Long total;

    public CountMessage(String value, Long total) {
        this.value = value;
        this.total = total;
    }
}
