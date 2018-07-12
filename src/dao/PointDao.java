package dao;

import entity.Point;

import java.util.List;

/**
 * Creator: DreamBoy
 * Date: 2018/7/11.
 */
public interface PointDao {
    Point add(Point point);

    void delete(int pointId);

    Point update(Point point);

    Point get(int pointId);

    List<Point> getPointsByChapter(int chapterId);

    Point exist(int chapterId, String description);
}
