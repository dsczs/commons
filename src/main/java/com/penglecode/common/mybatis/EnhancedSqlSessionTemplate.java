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
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

import com.penglecode.common.support.Pager;
import com.penglecode.common.support.PaginationUtils;
import com.penglecode.common.util.CollectionUtils;

/**
 * 该类是{@link #SqlSessionTemplate}的代理类,增加了几个便于开发的方法,如分页查询方法
 * 
 * @author	  	pengpeng
 * @date	  	2014年6月18日 下午6:26:20
 * @version  	1.0
 */
public class EnhancedSqlSessionTemplate implements SqlSession {

	/**
     * <p>
     * 默认分页总数查询statementKey的后缀
     * 例如分页查询数据的statementKey为'getXxxxList',则针对该分页的查询总记录数的statementKey一定要以<code>DEFAULT_PAGING_COUNT_STATEMENT_KEY_SUFFIX</code>结尾,例如：
     * <p/>
     * <select id="selectMyOrderList" parameterType="java.util.Map" statementType="PREPARED" resultType="OrderInfo">
     * select * from t_order_info a where a.user_id = #{userId}
     * </select>
     * 其分页count的查询statementKey的定义应如下：
     * <select id="selectMyOrderList_count" parameterType="java.util.Map" statementType="PREPARED" resultType="Integer">
     * select count(*) from t_order_info a where a.user_id = #{userId}
     * </select>
     */
    public static final String DEFAULT_PAGING_COUNT_STATEMENT_KEY_SUFFIX = "_count";

    private final SqlSession delegate;

    public EnhancedSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    	delegate = new SqlSessionTemplate(sqlSessionFactory);
    }
    
    public EnhancedSqlSessionTemplate(SqlSessionFactory sqlSessionFactory, ExecutorType executorType) {
    	delegate = new SqlSessionTemplate(sqlSessionFactory, executorType);
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

	/**
     * EscapeFilter的作用：对key-value键值对型数据转换,例如：
     * <p/>
     * return orderInfoDAO.selectOne(MybatisUtils.getMapperKey(OrderInfo.class, "selectOrderInfoById"), orderId, new EscapeFilter<OrderInfo>() {
     * 		public void doEscapeFilter(OrderInfo element) {
     * 			element.setOrderTypeName(OrderTypeEnum.getTypeName(element.getOrderType()));
     * 			...
     * 			...
     * 		}
     * });
     *
     * @param statementKey
     * @param paramObj
     * @param escapeFilter
     * @return
     */
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
    
    /**
     * EscapeFilter的作用：对key-value键值对型数据转换,例如：
     * <p/>
     * return orderInfoDAO.selectOne(MybatisUtils.getMapperKey(OrderInfo.class, "selectOrderInfoById"), orderId, new EscapeFilter<OrderInfo>() {
     * 		public void doEscapeFilter(OrderInfo element) {
     * 			element.setOrderTypeName(OrderTypeEnum.getTypeName(element.getOrderType()));
     * 			...
     * 			...
     * 		}
     * });
     *
     * @param statementKey
     * @param paramObj
     * @param escapeFilter
     * @return
     */
    public <T> List<T> selectList(String statementKey, Object paramObj, EscapeFilter<T> escapeFilter) {
        EscapeResultHandler<T> resultHandler = new EscapeResultHandler<T>(escapeFilter);
        delegate.select(statementKey, paramObj, resultHandler);
        return resultHandler.getResultList();
    }

    /**
     * 带分页的查询
     *
     * @param statementKey
     * @param paramObj
     * @param pager
     * @return
     */
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
    
    /**
     * 带分页的查询
     *
     * @param statementKey
     * @param paramObj
     * @param escapeFilter
     * @param pager
     * @return
     */
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
	
}
