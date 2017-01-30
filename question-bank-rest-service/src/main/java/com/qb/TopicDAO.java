package com.qb;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qb.dao.SessionUtil;
import com.qb.dao.Topic;

public class TopicDAO {

	public List<Topic> getTopics(int id){
        Session session = SessionUtil.getSession();    
        Query query = session.createQuery("from Topic where subject_id = :id");
        query.setInteger("id", id);
        List<Topic> topics =  query.list();
        System.out.println(topics);
        session.close();
        return topics;
    }

	public void addTopic(Topic topic) {
		Session session = SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        addTopic(session,topic);        
        tx.commit();
        session.close();
		
	}

	private void addTopic(Session session, Topic topic) {
		System.out.println(topic);
		Topic s = new Topic();
		s.setId(topic.getId());
		s.setName(topic.getName());
		session.save(s);
	}

	public List<Topic> getTopics() {
		Session session = SessionUtil.getSession();    
        Query query = session.createQuery("from Topic");
        List<Topic> topics =  query.list();
        System.out.println(topics);
        session.close();
        return topics;
	}
}
