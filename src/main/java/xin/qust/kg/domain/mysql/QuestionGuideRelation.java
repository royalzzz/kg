package xin.qust.kg.domain.mysql;

import javax.persistence.*;

@Entity
@Table(name = "question_guide_relation")
public class QuestionGuideRelation {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;

    private Long questionId;

    private Long checkItemId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getCheckItemId() {
        return checkItemId;
    }

    public void setCheckItemId(Long checkItemId) {
        this.checkItemId = checkItemId;
    }
}
