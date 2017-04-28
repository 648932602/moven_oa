package com.moven.model;

public class Role extends BaseModel{
	private static final long serialVersionUID = 9017285676486714890L;
	private Integer id;
    private String name;
    private Integer status;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
}