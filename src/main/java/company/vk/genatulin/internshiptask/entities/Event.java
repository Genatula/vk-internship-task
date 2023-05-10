package company.vk.genatulin.internshiptask.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "is_authorised", nullable = false)
    private Boolean isAuthorised = false;

    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private Date date;

    @Column(name = "numeric_ip", nullable = false)
    private Long numericIp;

    public Long getNumericIp() {
        return numericIp;
    }

    public void setNumericIp(Long numericIp) {
        this.numericIp = numericIp;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getIsAuthorised() {
        return isAuthorised;
    }

    public void setIsAuthorised(Boolean isAuthorised) {
        this.isAuthorised = isAuthorised;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
