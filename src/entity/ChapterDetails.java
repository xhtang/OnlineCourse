package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Creator: DreamBoy
 * Date: 2018/7/11.
 */
public class ChapterDetails {
    private Chapter chapter;
    private List<Point> points;

    public List<Point> getPoints() {
        if (points == null)
            points = new ArrayList<>();
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }
}
