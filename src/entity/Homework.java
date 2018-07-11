package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Creator: DreamBoy
 * Date: 2018/7/9.
 */
@Entity
public class Homework {
    private int id;
    private Integer courseId;
    private String type;
    private String content;
    private String correctAnswer;

    public Homework() {}

    public Homework(int id, int courseId, String type, String content, String correctAnswer) {
        this.id = id;
        this.content = content;
        this.courseId = courseId;
        this.type = type;
        this.correctAnswer = correctAnswer;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "courseId")
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "correctAnswer")
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Homework homework = (Homework) o;

        if (id != homework.id) return false;
        if (courseId != null ? !courseId.equals(homework.courseId) : homework.courseId != null) return false;
        if (type != null ? !type.equals(homework.type) : homework.type != null) return false;
        if (content != null ? !content.equals(homework.content) : homework.content != null) return false;
        if (correctAnswer != null ? !correctAnswer.equals(homework.correctAnswer) : homework.correctAnswer != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (correctAnswer != null ? correctAnswer.hashCode() : 0);
        return result;
    }
}
