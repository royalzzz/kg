package xin.qust.kg.domain.mysql;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hidden_danger_check_item")
public class HiddenDangerCheckItem implements Serializable {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;

    private Long checkId;

    private Long checkTypeId;

    @Lob @Column(columnDefinition = "text")
    private String checkItemName;

    @Lob @Column(columnDefinition = "text")
    private String according;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCheckItemName() {
        return checkItemName;
    }

    public void setCheckItemName(String checkItemName) {
        this.checkItemName = checkItemName;
    }

    public String getAccording() {
        return according;
    }

    public void setAccording(String according) {
        this.according = according;
    }

    public Long getCheckId() {
        return checkId;
    }

    public void setCheckId(Long checkId) {
        this.checkId = checkId;
    }

    public Long getCheckTypeId() {
        return checkTypeId;
    }

    public void setCheckTypeId(Long checkTypeId) {
        this.checkTypeId = checkTypeId;
    }
}
