package company.vk.genatulin.internshiptask.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ClientEvent {
    private String name;
    private Boolean isAuthorised;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Boolean getIsAuthorised() {
        return isAuthorised;
    }
    public void setIsAuthorised(Boolean isAuthorised) {
        this.isAuthorised = isAuthorised;
    }
}
