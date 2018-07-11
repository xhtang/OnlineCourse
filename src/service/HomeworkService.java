package service;

import entity.Homework;
import entity.StudentAnswer;

import java.util.List;

/**
 * Creator: DreamBoy
 * Date: 2018/7/9.
 */
public interface HomeworkService {
    Homework addHomework(Homework homework);

    Homework deleteHomework(int homeworkId);

    Homework updateHomework(Homework homework);

    Homework getById(int homeworkId);

    List<Homework> getByCourse(int courseId);

    StudentAnswer doHomework(StudentAnswer studentAnswer);
}
