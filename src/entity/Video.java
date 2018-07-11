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
public class Video {
    private int id;
    private Integer pointId;
    private String path;

    public Video() {}

    public Video(int id, int pointId, String path) {
        this.id = id;
        this.pointId = pointId;
        this.path = path;
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
    @Column(name = "pointId")
    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    @Basic
    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Video video = (Video) o;

        if (id != video.id) return false;
        if (pointId != null ? !pointId.equals(video.pointId) : video.pointId != null) return false;
        if (path != null ? !path.equals(video.path) : video.path != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (pointId != null ? pointId.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        return result;
    }
}
