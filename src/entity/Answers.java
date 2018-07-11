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
public class Answers {
    private int id;
    private Integer homeworkId;
    private String content;

    public Answers() {}

    public Answers(int id, int homeworkId, String content) {
        this.id = id;
        this.content = content;
        this.homeworkId = homeworkId;
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
    @Column(name = "homeworkId")
    public Integer getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Integer homeworkId) {
        this.homeworkId = homeworkId;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answers answers = (Answers) o;

        if (id != answers.id) return false;
        if (homeworkId != null ? !homeworkId.equals(answers.homeworkId) : answers.homeworkId != null) return false;
        if (content != null ? !content.equals(answers.content) : answers.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (homeworkId != null ? homeworkId.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
