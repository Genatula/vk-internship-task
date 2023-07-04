package company.vk.genatulin.internshiptask.dto;

import jakarta.validation.constraints.NotNull;

public class SuccessMessage {
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @NotNull
    private Boolean success;

    public SuccessMessage(Boolean success) {
        this.success = success;
    }
}
