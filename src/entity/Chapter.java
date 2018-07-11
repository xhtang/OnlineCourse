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
public class Chapter {
    private int id;
    private Integer courseId;
    private String description;

    public Chapter() {}

    public Chapter(int id, int courseId, String description) {
        this.id = id;
        this.courseId = courseId;
        this.description = description;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chapter chapter = (Chapter) o;

        if (id != chapter.id) return false;
        if (courseId != null ? !courseId.equals(chapter.courseId) : chapter.courseId != null) return false;
        if (description != null ? !description.equals(chapter.description) : chapter.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }


}
