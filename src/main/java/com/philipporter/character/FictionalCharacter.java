package com.philipporter.character;

import java.io.Serializable;

/**
 * @author Philip Porter
 * @version 0.0.0
 */
public class FictionalCharacter implements Serializable {
    
    private long id;
    private String name;
    private String role;

    public FictionalCharacter(){
        
    }
    
    public FictionalCharacter(long id, String name, String role){
        this.id = id;
        this.name = name;
        this.role = role;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
