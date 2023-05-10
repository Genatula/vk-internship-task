package company.vk.genatulin.internshiptask.dto;

public class CountMessage {
    private String value;
    private Long total;

    public CountMessage(String value, Long total) {
        this.value = value;
        this.total = total;
    }
}
