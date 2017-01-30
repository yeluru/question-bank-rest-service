package com.qb;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qb.dao.SessionUtil;
import com.qb.dao.Question;

public class QuestionDAO {

	public List<Question> getQuestions(int id) {
		System.out.println("id received: " + id);
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Question where topic_id = :id");
		query.setInteger("id", id);
		List<Question> Questions = query.list();
		System.out.println(Questions);
		session.close();
		return Questions;
	}

	public void addQuestion(Question Question) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addQuestion(session, Question);
		tx.commit();
		session.close();

	}

	private void addQuestion(Session session, Question question) {
		System.out.println(question);
		Question s = new Question();
		s.setId(question.getId());
		s.setName(question.getName());
		session.save(s);
	}

	public List<Question> getQuestions() {
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Question");
		List<Question> Questions = query.list();
		session.close();
		return Questions;
	}
}
