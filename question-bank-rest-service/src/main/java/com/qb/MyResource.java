package com.qb;
 
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.qb.dao.Question;
import com.qb.dao.Subject;
import com.qb.dao.SubjectDAO;
import com.qb.dao.Topic;
 
 
@Path("/qb")
public class MyResource {
 
    @GET
    @Path("/subjects/list")
    @Produces("application/json")
    public List<Subject> getSubjects() {
        SubjectDAO dao = new SubjectDAO();
        List<Subject> subjects = dao.getSubjects();
        return subjects;
    }
    
    @GET
    @Path("/topics/list")
    @Produces("application/json")
    public List<Topic> getTopics() {
        TopicDAO dao = new TopicDAO();
        List<Topic> topics = dao.getTopics();
        return topics;
    }
    
    @GET
    @Path("/topics")
    @Produces("application/json")
    public List<Topic> getTopics(@QueryParam("subject-id") int id) {
        TopicDAO dao = new TopicDAO();
        List<Topic> topics = dao.getTopics(id);
        return topics;
    }
    
    @GET
    @Path("/questions")
    @Produces("application/json")
    public List<Question> getQuestions(@QueryParam("topic-id") int id) {
    		QuestionDAO dao = new QuestionDAO();
        List<Question> questions = dao.getQuestions(id);
        return questions;
    }
    
    @GET
    @Path("/questions/list")
    @Produces("application/json")
    public List<Question> getQuestions() {
    		QuestionDAO dao = new QuestionDAO();
        List<Question> questions = dao.getQuestions();
        return questions;
    }
 
    @POST
    @Path("/subjects/create")
    @Consumes("application/json")
    public Response addSubject(Subject subject) {
        SubjectDAO dao = new SubjectDAO();
        dao.addSubject(subject);
        return Response.ok().build();
    }
   
}