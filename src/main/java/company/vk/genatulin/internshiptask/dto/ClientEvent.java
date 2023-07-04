package company.vk.genatulin.internshiptask.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ClientEvent {
    @NotEmpty
    @NotBlank
    @Size(max = 64)
    private String name;
    @NotNull
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
