package entity;

import javax.persistence.*;

/**
 * Creator: DreamBoy
 * Date: 2018/7/9.
 */
@Entity
@Table(name = "teach_course", schema = "onlinecourse")
public class TeachCourse {
    private int id;
    private Integer userId;
    private Integer courseId;

    public TeachCourse() {}

    public TeachCourse(int id, int userId, int courseId) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
    }

    @Id
    @Column(name = "tcId")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userId")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "courseId")
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeachCourse that = (TeachCourse) o;

        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        return result;
    }
}
