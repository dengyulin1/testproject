package com.dyl.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SqlComputerTask<T> extends RecursiveTask<List<T>> {

    private static Logger LOG = LogManager.getLogger(SqlComputerTask.class);

    private EntityManager entityManager;

    private List<String> sqlList;

    private Class<T> className;

    public SqlComputerTask(List<String> sqlList, Class<T> className,EntityManager entityManager) {
        this.sqlList = sqlList;
        this.className = className;
        this.entityManager = entityManager;
    }

    private ArrayList<T> compute(String Sql) {
        LOG.info(Sql);
        ArrayList<T> resp = new ArrayList<T>();
        try {
            Query query = this.entityManager.createNativeQuery(Sql, className);
            resp = (ArrayList<T>) query.getResultList();
        } catch (Exception e) {
            LOG.error("出错Sql：" + Sql);
            LOG.error("ERROR:", e);
        } finally {
            entityManager.close();
        }
        return resp;
    }

    @Override
    protected List<T> compute() {
        List<T> resulList = new ArrayList();
        if (null == sqlList || sqlList.isEmpty()){
            return null;
        }
        if (sqlList.size() == 1){
            return compute(sqlList.get(0));
        }

        if (sqlList.size() > 1){
            SqlComputerTask<T> t1 = new SqlComputerTask<T>(sqlList.subList(0,sqlList.size()/2),className,entityManager);
            SqlComputerTask<T> t2 = new SqlComputerTask<T>(sqlList.subList(sqlList.size()/2,sqlList.size()),className,entityManager);
            t1.fork();
            t2.fork();
            resulList.addAll(t1.join());
            resulList.addAll(t2.join());
        }

        return resulList;
    }
}
