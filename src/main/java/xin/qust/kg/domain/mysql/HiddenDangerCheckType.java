package xin.qust.kg.domain.mysql;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hidden_danger_check_type")
public class HiddenDangerCheckType implements Serializable {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;

    private Long checkId;

    private String checkTypeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCheckTypeName() {
        return checkTypeName;
    }

    public void setCheckTypeName(String checkTypeName) {
        this.checkTypeName = checkTypeName;
    }

    public Long getCheckId() {
        return checkId;
    }

    public void setCheckId(Long checkId) {
        this.checkId = checkId;
    }

    @Override
    public String toString() {
        return "HiddenDangerCheckType{" +
                "id=" + id +
                ", checkId=" + checkId +
                ", checkTypeName='" + checkTypeName + '\'' +
                '}';
    }
}
