package company.vk.genatulin.internshiptask.repositories;

public class StatusCount {
    private Boolean status;
    private Long total;

    public StatusCount(Boolean status, Long total) {
        this.status = status;
        this.total = total;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
