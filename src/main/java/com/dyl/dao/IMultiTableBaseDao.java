package com.dyl.dao;

import java.util.List;

public interface IMultiTableBaseDao<T> {

    /**
     * 根据id list查询数据
     * @param idList
     * @return
     */
    List<T> findByIds(List<?> idList);
}
