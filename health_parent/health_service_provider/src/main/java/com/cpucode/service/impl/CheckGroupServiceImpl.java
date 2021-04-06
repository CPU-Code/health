package com.cpucode.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cpucode.dao.CheckGroupDao;
import com.cpucode.entity.PageResult;
import com.cpucode.pojo.CheckGroup;
import com.cpucode.service.CheckGroupService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 检查组服务
 *
 * @author : cpucode
 * @date : 2021/4/1
 * @time : 16:18
 * @github : https://github.com/CPU-Code
 * @csdn : https://blog.csdn.net/qq_44226094
 */
@Service(interfaceClass = CheckGroupService.class)
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService{
    @Autowired
    private CheckGroupDao checkGroupDao;

    /**
     * 新增检查组，同时需要让检查组关联检查项
     * @param checkGroup
     * @param checkitemIds
     */
    public void add(CheckGroup checkGroup, Integer[] checkitemIds){
        //新增检查组，操作t_checkgroup表
        checkGroupDao.add(checkGroup);

        //设置检查组和检查项的多对多的关联关系，操作 t_checkgroup_checkitem 表
        Integer checkGroupId = checkGroup.getId();

        this.setCheckGroupAndCheckItem(checkGroupId, checkitemIds);
    }

    /**
     * 建立检查组和检查项多对多关系
     * @param checkGroupId
     * @param checkitemIds
     */
    public void setCheckGroupAndCheckItem(Integer checkGroupId, Integer[] checkitemIds){
        if(checkitemIds != null && checkitemIds.length > 0){
            Map<String,Integer> map = null;

            for (Integer checkitemId : checkitemIds){
                map = new HashMap<>();

                map.put("checkgroupId",checkGroupId);
                map.put("checkitemId",checkitemId);

                checkGroupDao.setCheckGroupAndCheckItem(map);
            }
        }
    }

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @param queryString
     * @return
     */
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString){
        PageHelper.startPage(currentPage,pageSize);

        Page<CheckGroup> page = checkGroupDao.selectByCondition(queryString);

        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 根据ID查询检查组
     * @param id
     * @return
     */
    public CheckGroup findById(Integer id) {
        return checkGroupDao.findById(id);
    }

    /**
     * 根据检查组ID查询关联的检查项ID
     * @param id
     * @return
     */
    public List<Integer> findCheckItemIdsByCheckGroupId(Integer id) {
        return checkGroupDao.findCheckItemIdsByCheckGroupId(id);
    }
}
