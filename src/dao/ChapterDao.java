package dao;

import entity.Chapter;

import java.util.List;

/**
 * Creator: DreamBoy
 * Date: 2018/7/8.
 */
public interface ChapterDao {
    Chapter add(Chapter chapter);

    void delete(int id);

    Chapter update(Chapter chapter);

    Chapter get(int id);

    List<Chapter> getByCourse(int courseId);
}
