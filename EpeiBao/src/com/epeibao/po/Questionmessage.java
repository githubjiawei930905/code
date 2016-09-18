package com.epeibao.po;

public class Questionmessage {
    private String questionid;

    private String questiondescribe;

    private String answer;

    private String coursewareid;

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid == null ? null : questionid.trim();
    }

    public String getQuestiondescribe() {
        return questiondescribe;
    }

    public void setQuestiondescribe(String questiondescribe) {
        this.questiondescribe = questiondescribe == null ? null : questiondescribe.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getCoursewareid() {
        return coursewareid;
    }

    public void setCoursewareid(String coursewareid) {
        this.coursewareid = coursewareid == null ? null : coursewareid.trim();
    }
}