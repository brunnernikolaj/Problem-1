package entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nikolaj
 */
public class GroupInfo {
    private String authors;
    
    private String classLetter;
    
    private String groupName;

    public GroupInfo(String authors, String classLetter, String groupName) {
        this.authors = authors;
        this.classLetter = classLetter;
        this.groupName = groupName;
    }
    
    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getClassLetter() {
        return classLetter;
    }

    public void setClassLetter(String classLetter) {
        this.classLetter = classLetter;
    }

    public String getGroupNumber() {
        return groupName;
    }

    public void setGroupNumber(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return String.format("Authors: %s \n GroupName: %s \n Class: %s", authors, groupName, classLetter); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
