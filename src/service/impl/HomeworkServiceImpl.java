package service.impl;

import dao.DaoFactory;
import dao.HomeworkDao;
import entity.Homework;
import entity.StudentAnswer;
import service.HomeworkService;

import java.util.List;

/**
 * Creator: DreamBoy
 * Date: 2018/7/11.
 */
public class HomeworkServiceImpl implements HomeworkService {
    private HomeworkDao homeworkDao = DaoFactory.getHomeworkDaoImpl();
    @Override
    public Homework addHomework(Homework homework) {
        return homeworkDao.add(homework);
    }

    @Override
    public Homework deleteHomework(int homeworkId) {
        return homeworkDao.delete(homeworkId);
    }

    @Override
    public Homework updateHomework(Homework homework) {
        return homeworkDao.update(homework);
    }

    @Override
    public Homework getById(int homeworkId) {
        return homeworkDao.get(homeworkId);
    }

    @Override
    public List<Homework> getByCourse(int courseId) {
        return homeworkDao.getByCourse(courseId);
    }

    @Override
    public StudentAnswer doHomework(StudentAnswer studentAnswer) {
        return homeworkDao.addAnswer(studentAnswer);
    }
}
