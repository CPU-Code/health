package com.cpucode.service;

import com.cpucode.entity.PageResult;
import com.cpucode.pojo.CheckGroup;

import java.util.List;

/**
 * @author : cpucode
 * @date : 2021/4/1
 * @time : 15:02
 * @github : https://github.com/CPU-Code
 * @csdn : https://blog.csdn.net/qq_44226094
 */
public interface CheckGroupService {
    public void add(CheckGroup checkGroup, Integer[] checkitemIds);

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @param queryString
     * @return
     */
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    public CheckGroup findById(Integer id);

    public List<Integer> findCheckItemIdsByCheckGroupId(Integer id);

    public void edit(CheckGroup checkGroup, Integer[] checkitemIds);

    public List<CheckGroup> findAll();
}
