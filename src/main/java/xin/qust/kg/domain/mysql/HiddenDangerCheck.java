package xin.qust.kg.domain.mysql;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hidden_danger_check")
public class HiddenDangerCheck implements Serializable {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;

    private String checkName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }
}
