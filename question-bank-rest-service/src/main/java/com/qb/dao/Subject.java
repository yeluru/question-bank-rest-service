package com.qb.dao;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
 
@Entity
public class Subject {
 
    @Id
    private int id;
    
    @Column
    private String name;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + "]";
	}
}