package com.cpucode.service;

import com.cpucode.pojo.CheckGroup;

/**
 * @author : cpucode
 * @date : 2021/4/1
 * @time : 15:02
 * @github : https://github.com/CPU-Code
 * @csdn : https://blog.csdn.net/qq_44226094
 */
public interface CheckGroupService {
    public void add(CheckGroup checkGroup, Integer[] checkitemIds);
}