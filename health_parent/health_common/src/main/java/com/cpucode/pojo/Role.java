package com.cpucode.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 角色
 *
 * @author : cpucode
 * @date : 2021/3/25
 * @time : 15:34
 * @github : https://github.com/CPU-Code
 * @csdn : https://blog.csdn.net/qq_44226094
 */
public class Role implements Serializable {
    private Integer id;
    /**
     *  角色名称
     */
    private String name;
    /**
     * 角色关键字，用于权限控制
     */
    private String keyword;
    /**
     * 描述
     */
    private String description;

    private Set<User> users = new HashSet<User>(0);
    private Set<Permission> permissions = new HashSet<Permission>(0);

    private LinkedHashSet<Menu> menus = new LinkedHashSet<Menu>(0);

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
        this.name = name;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public LinkedHashSet<Menu> getMenus() {
        return menus;
    }

    public void setMenus(LinkedHashSet<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keyword='" + keyword + '\'' +
                ", description='" + description + '\'' +
                ", users=" + users +
                ", permissions=" + permissions +
                ", menus=" + menus +
                '}';
    }
}
