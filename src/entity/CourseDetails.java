package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Creator: DreamBoy
 * Date: 2018/7/11.
 */
public class CourseDetails {
    private Course course;
    private List<ChapterDetails> chapterDetailsList;

    public List<ChapterDetails> getChapterDetailsList() {
        return chapterDetailsList;
    }

    public void setChapterDetailsList(List<ChapterDetails> chapterDetailsList) {
        this.chapterDetailsList = chapterDetailsList;
    }

    public Course getCourse() {
        if (chapterDetailsList == null)
            chapterDetailsList = new ArrayList<>();
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
