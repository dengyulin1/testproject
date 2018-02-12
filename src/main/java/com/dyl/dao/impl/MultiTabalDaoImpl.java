package com.dyl.dao.impl;

import com.dyl.annotation.MultiTablePrefix;
import com.dyl.consts.GlobalConsts;
import com.dyl.dao.IMultiTableBaseDao;
import com.dyl.utils.CommonUtils;
import com.dyl.utils.SqlComputerTask;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MultiTabalDaoImpl<T> implements IMultiTableBaseDao<T> {

    @PersistenceContext
    EntityManager entityManager;

    private Class<T> entityClass;

    private String tableName;
    private String tableShortName;

    public MultiTabalDaoImpl() {

        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class)params[0];
        MultiTablePrefix multiTablePrefix = entityClass.getAnnotation(MultiTablePrefix.class);
        tableShortName = multiTablePrefix.shortName();
        tableName = multiTablePrefix.schema()+"."+multiTablePrefix.shortName();
    }

    @Override
    public List<T> findByIds(List<?> idList) {

        List<T> respList = new ArrayList<>();
        if (null == idList || idList.isEmpty()){
            return respList;
        }

        Map<Long,String> codeMap = new HashMap<>();

        for (Object id: idList){
            long codeId = 0L;
            if (id instanceof Long){
                codeId = (long)id;
            }
            else if(id instanceof BigInteger){
                codeId = ((BigInteger)id).longValue();
            }

            long code = CommonUtils.getCode(codeId);
            if (codeMap.containsKey(code)){
                codeMap.put(code,codeMap.get(code)+","+codeId);
            }
            else{
                codeMap.put(code,codeId+"");
            }
        }

        Iterator<Map.Entry<Long,String>> iterator = codeMap.entrySet().iterator();

        List<String> sqlList = new ArrayList<>();
        while (iterator.hasNext()){
            Map.Entry<Long,String> entry = iterator.next();
            String sql = "SELECT * FROM " + tableName + "_" + entry.getKey() + " WHERE id in (" + entry.getValue()
                    + ")";
            sqlList.add(sql);
        }

        Future<List<T>> future = GlobalConsts.MULT_TABLE_FJPOOL.submit(new SqlComputerTask<T>(sqlList,entityClass, entityManager));

        try {
            respList = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return respList;
    }
}
