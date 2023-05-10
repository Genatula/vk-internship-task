package company.vk.genatulin.internshiptask.dto;

public class SuccessMessage {
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    private Boolean success;

    public SuccessMessage(Boolean success) {
        this.success = success;
    }
}
