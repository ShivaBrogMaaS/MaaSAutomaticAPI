package com.test.corent.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task implements Serializable
{
private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String projectname;
private String clientname;
private String taskowner;
private String contactno;
private String email;

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

public String getProjectname() {
return projectname;
}

public void setProjectname(String projectname) {
this.projectname = projectname;
}

public String getClientname() {
return clientname;
}

public void setClientname(String clientname) {
this.clientname = clientname;
}

public String getTaskowner() {
return taskowner;
}

public void setTaskowner(String taskowner) {
this.taskowner = taskowner;
}

public String getContactno() {
return contactno;
}

public void setContactno(String contactno) {
this.contactno = contactno;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

}
