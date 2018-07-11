package entity;

import javax.persistence.*;

/**
 * Creator: DreamBoy
 * Date: 2018/7/11.
 */
@Entity
@Table(name = "student_answer", schema = "onlinecourse")
public class StudentAnswer {
    private int id;
    private Integer studentId;
    private Integer homeworkId;

    public StudentAnswer() {}

    public StudentAnswer(int id, int studentId, int homeworkId) {
        this.id = id;
        this.studentId = studentId;
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
    @Column(name = "studentId")
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "homeworkId")
    public Integer getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Integer homeworkId) {
        this.homeworkId = homeworkId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentAnswer that = (StudentAnswer) o;

        if (id != that.id) return false;
        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (homeworkId != null ? !homeworkId.equals(that.homeworkId) : that.homeworkId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        result = 31 * result + (homeworkId != null ? homeworkId.hashCode() : 0);
        return result;
    }
}
