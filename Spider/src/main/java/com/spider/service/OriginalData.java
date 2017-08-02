package com.spider.service;

import com.spider.vo.ConditionVo;

/**
 * Created by Gene on 2017/7/27.
 */
public interface OriginalData {
    public boolean saveOriginalData();
    public OriginalData getOriginalData(ConditionVo cv);
}
