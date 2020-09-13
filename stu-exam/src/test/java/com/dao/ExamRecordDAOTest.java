package com.dao;

import com.model.ExamRecord;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ExamRecordDAOTest {

    @Test
    public void insert() {
        ExamRecord er = new ExamRecord();
        er.setExamId(1);
        er.setStudentId(3);
        er.setScore(new BigDecimal(77));
        ExamRecordDAO.insert(er);
    }

    @Test
    public void delete() {
        String[]ids  =  {"1","2"};
        ExamRecordDAO.delete(ids);
    }

    @Test
    public void update() {
        ExamRecord er = new ExamRecord();
        er.setId(13);
        er.setStudentId(3);
        er.setExamId(2);
        er.setScore(new BigDecimal(100));
        ExamRecordDAO.update(er);

    }
}