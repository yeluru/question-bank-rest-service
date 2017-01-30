package com.qb.dao;
 
import java.util.List;
 
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
public class SubjectDAO {
     
    public List<Subject> getSubjects(){
        Session session = SessionUtil.getSession();    
        Query query = session.createQuery("from Subject");
        List<Subject> subjects =  query.list();
        session.close();
        return subjects;
    }

	public void addSubject(Subject subject) {
		Session session = SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        addSubject(session,subject);        
        tx.commit();
        session.close();
		
	}

	private void addSubject(Session session, Subject subject) {
		System.out.println(subject);
		Subject s = new Subject();
		s.setId(subject.getId());
		s.setName(subject.getName());
		session.save(s);
	}
}
 