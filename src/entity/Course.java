package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Creator: DreamBoy
 * Date: 2018/7/12.
 */
@Entity
public class Course {
    private int id;
    private String coursename;
    private String img;
    private String description;
    private Integer studentnum;

    public Course() {}

    public Course(int id, String coursename, String img, String description, int studentnum) {
        this.id = id;
        this.coursename = coursename;
        this.img = img;
        this.description = description;
        this.studentnum = studentnum;
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
    @Column(name = "coursename")
    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    @Basic
    @Column(name = "img")
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "studentnum")
    public Integer getStudentnum() {
        return studentnum;
    }

    public void setStudentnum(Integer studentnum) {
        this.studentnum = studentnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (id != course.id) return false;
        if (coursename != null ? !coursename.equals(course.coursename) : course.coursename != null) return false;
        if (img != null ? !img.equals(course.img) : course.img != null) return false;
        if (description != null ? !description.equals(course.description) : course.description != null) return false;
        if (studentnum != null ? !studentnum.equals(course.studentnum) : course.studentnum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (coursename != null ? coursename.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (studentnum != null ? studentnum.hashCode() : 0);
        return result;
    }
}
