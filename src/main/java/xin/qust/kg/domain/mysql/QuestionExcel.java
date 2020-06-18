package xin.qust.kg.domain.mysql;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "question_excel")
public class QuestionExcel implements Serializable {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;

    private String orgName;

    private String proCatalog;

    private String oneLevelFactor;

    private String twoLevelFactor;

    private String checkContent;

    @Lob @Column(columnDefinition = "text")
    private String questionDesc;

    private String suggest;

    @Column(columnDefinition = "default 1")
    private Boolean isTagged;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getProCatalog() {
        return proCatalog;
    }

    public void setProCatalog(String proCatalog) {
        this.proCatalog = proCatalog;
    }

    public String getOneLevelFactor() {
        return oneLevelFactor;
    }

    public void setOneLevelFactor(String oneLevelFactor) {
        this.oneLevelFactor = oneLevelFactor;
    }

    public String getTwoLevelFactor() {
        return twoLevelFactor;
    }

    public void setTwoLevelFactor(String twoLevelFactor) {
        this.twoLevelFactor = twoLevelFactor;
    }

    public String getCheckContent() {
        return checkContent;
    }

    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent;
    }

    public String getQuestionDesc() {
        return questionDesc;
    }

    public void setQuestionDesc(String questionDesc) {
        this.questionDesc = questionDesc;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public Boolean getTagged() {
        return isTagged;
    }

    public void setTagged(Boolean tagged) {
        isTagged = tagged;
    }
}
