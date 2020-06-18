package xin.qust.kg.domain.vo;

public class QuestionGuideFormVo {

    private int questionId;
    private String name;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "QuestionGuideFormVo{" +
                "questionId=" + questionId +
                ", name='" + name + '\'' +
                '}';
    }
}
