package com.penglecode.common.mybatis;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;

import com.penglecode.common.support.Pager;
import com.penglecode.common.support.PaginationUtils;
import com.penglecode.common.util.CollectionUtils;
import com.penglecode.mybatis.ex.ExSqlSession;
import com.penglecode.mybatis.ex.spring.ExSqlSessionTemplate;

/**
 * 该类是{@link #ExSqlSessionTemplate}的代理类,增加了几个便于开发的方法,如分页查询方法等
 * 
 * @author	  	pengpeng
 * @date	  	2014年6月18日 下午6:26:20
 * @version  	1.0
 */
public class EnhancedExSqlSessionTemplate implements EnhancedSqlSession {

    private final ExSqlSession delegate;

    public EnhancedExSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    	delegate = new ExSqlSessionTemplate(sqlSessionFactory);
    }
    
    public EnhancedExSqlSessionTemplate(SqlSessionFactory sqlSessionFactory, ExecutorType executorType) {
    	delegate = new ExSqlSessionTemplate(sqlSessionFactory, executorType);
    }
	
	public void clearCache() {
		delegate.clearCache();
	}

	public void close() {
		delegate.close();
	}

	public void commit() {
		delegate.commit();
	}

	public void commit(boolean force) {
		delegate.commit(force);
	}

	public int delete(String statement) {
		return delegate.delete(statement);
	}

	public int delete(String statement, Object parameter) {
		return delegate.delete(statement, parameter);
	}

	public List<BatchResult> flushStatements() {
		return delegate.flushStatements();
	}

	public Configuration getConfiguration() {
		return delegate.getConfiguration();
	}

	public Connection getConnection() {
		return delegate.getConnection();
	}

	public <T> T getMapper(Class<T> type) {
		return delegate.getMapper(type);
	}

	public int insert(String statement) {
		return delegate.insert(statement);
	}

	public int insert(String statement, Object parameter) {
		return delegate.insert(statement, parameter);
	}

	public void rollback() {
		delegate.rollback();
	}

	public void rollback(boolean force) {
		delegate.rollback(force);
	}

	public void select(String statement, ResultHandler handler) {
		delegate.select(statement, handler);
	}

	public void select(String statement, Object parameter, ResultHandler handler) {
		delegate.select(statement, parameter, handler);
	}

	public void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler) {
		delegate.select(statement, parameter, rowBounds, handler);
	}

	public <E> List<E> selectList(String statement) {
		return delegate.selectList(statement);
	}

	public <E> List<E> selectList(String statement, Object parameter) {
		return delegate.selectList(statement, parameter);
	}

	public <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds) {
		return delegate.selectList(statement, parameter, rowBounds);
	}

	public <K, V> Map<K, V> selectMap(String statement, String parameter) {
		return delegate.selectMap(statement, parameter);
	}

	public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey) {
		return delegate.selectMap(statement, parameter, mapKey);
	}

	public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds) {
		return delegate.selectMap(statement, parameter, mapKey, rowBounds);
	}

	public <T> T selectOne(String statement) {
		return delegate.selectOne(statement);
	}

	public <T> T selectOne(String statement, Object parameter) {
		return delegate.selectOne(statement, parameter);
	}

	public int update(String statement) {
		return delegate.update(statement);
	}

	public int update(String statement, Object parameter) {
		return delegate.update(statement, parameter);
	}

    public <T> T selectOne(String statementKey, Object paramObj, EscapeFilter<T> escapeFilter) {
        EscapeResultHandler<T> resultHandler = new EscapeResultHandler<T>(escapeFilter);
        delegate.select(statementKey, paramObj, resultHandler);
        List<T> list = resultHandler.getResultList();
        if (list == null || list.isEmpty()) {
            return null;
        } else if (list.size() == 1) {
            return list.get(0);
        }
        throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + list.size());
    }
    
    public <T> List<T> selectList(String statementKey, Object paramObj, EscapeFilter<T> escapeFilter) {
        EscapeResultHandler<T> resultHandler = new EscapeResultHandler<T>(escapeFilter);
        delegate.select(statementKey, paramObj, resultHandler);
        return resultHandler.getResultList();
    }

    public <T> List<T> selectList(String statementKey, Object paramObj, Pager pager) {
    	Number totalNum = delegate.selectOne(statementKey + DEFAULT_PAGING_COUNT_STATEMENT_KEY_SUFFIX, paramObj);
    	Integer totalRowCount = totalNum.intValue();
    	List<T> resultList = null;
    	if(totalRowCount > 0){
    		int offset = (pager.getCurrentPage() - 1) * pager.getPageSize();
    		resultList = delegate.selectList(statementKey, paramObj, new RowBounds(offset, pager.getPageSize()));
            if(CollectionUtils.isEmpty(resultList)){
            	totalRowCount = 0;
            }else if(resultList.size() > totalRowCount){
            	totalRowCount = resultList.size();
            }
    	}
    	pager.setTotalRowCount(totalRowCount);
    	PaginationUtils.setPageItems(pager);
        return resultList;
    }
    
    public <T> List<T> selectList(String statementKey, Object paramObj, EscapeFilter<T> escapeFilter, Pager pager) {
    	Number totalNum = delegate.selectOne(statementKey + DEFAULT_PAGING_COUNT_STATEMENT_KEY_SUFFIX, paramObj);
        Integer totalRowCount = totalNum.intValue();
        List<T> resultList = null;
        if(totalRowCount > 0){
        	int offset = (pager.getCurrentPage() - 1) * pager.getPageSize();
            EscapeResultHandler<T> resultHandler = new EscapeResultHandler<T>(escapeFilter);
            delegate.select(statementKey, paramObj, new RowBounds(offset, pager.getPageSize()), resultHandler);
            resultList = resultHandler.getResultList();
            if(CollectionUtils.isEmpty(resultList)){
            	totalRowCount = 0;
            }else if(resultList.size() > totalRowCount){
            	totalRowCount = resultList.size();
            }
        }
        pager.setTotalRowCount(totalRowCount);
		PaginationUtils.setPageItems(pager);
		return resultList;
    }

	public <T> int[] batchInsert(String statementKey, List<T> paramObjList) {
		return delegate.batchInsert(statementKey, paramObjList);
	}

	public <T> int[] batchInsert(String statementKey, List<T> paramObjList, int flushBatchSize) {
		return delegate.batchInsert(statementKey, paramObjList, flushBatchSize);
	}

	public <T> int[] batchUpdate(String statementKey, List<T> paramObjList) {
		return delegate.batchUpdate(statementKey, paramObjList);
	}

	public <T> int[] batchUpdate(String statementKey, List<T> paramObjList, int flushBatchSize) {
		return delegate.batchUpdate(statementKey, paramObjList, flushBatchSize);
	}

	public <T> int[] batchDelete(String statementKey, List<T> paramObjList) {
		return delegate.batchDelete(statementKey, paramObjList);
	}

	public <T> int[] batchDelete(String statementKey, List<T> paramObjList, int flushBatchSize) {
		return delegate.batchDelete(statementKey, paramObjList, flushBatchSize);
	}
	
}
