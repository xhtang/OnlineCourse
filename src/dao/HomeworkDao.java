package dao;

import entity.Homework;
import entity.StudentAnswer;

import java.util.List;

/**
 * Creator: DreamBoy
 * Date: 2018/7/9.
 */
public interface HomeworkDao {
    Homework add(Homework homework);

    Homework delete(int homeworkId);

    Homework update(Homework homework);

    Homework get(int homeworkId);

    List<Homework> getByCourse(int courseId);

    Homework existHomework(int courseId, String type, String content);

    StudentAnswer addAnswer(StudentAnswer studentAnswer);

    StudentAnswer existAnswer(int studentId, int homeworkId);

    StudentAnswer updateAnswer(StudentAnswer studentAnswer);
}
