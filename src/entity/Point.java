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
public class Point {
    private int id;
    private Integer chapterId;
    private String description;

    public Point() {

    }

    public Point(int id, int chapterId, String description) {
        this.id = id;
        this.chapterId = chapterId;
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
    @Column(name = "chapterId")
    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
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

        Point point = (Point) o;

        if (id != point.id) return false;
        if (chapterId != null ? !chapterId.equals(point.chapterId) : point.chapterId != null) return false;
        if (description != null ? !description.equals(point.description) : point.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (chapterId != null ? chapterId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
