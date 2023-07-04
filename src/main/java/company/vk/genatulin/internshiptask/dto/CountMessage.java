package company.vk.genatulin.internshiptask.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

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

    @NotBlank
    @NotBlank
    @Size(max = 64)
    private String value;
    @PositiveOrZero
    private Long total;

    public CountMessage(String value, Long total) {
        this.value = value;
        this.total = total;
    }
}
