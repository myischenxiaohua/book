package com.book.dao; /*
 ClassName:com.book.dao
 Description:公共DAO接口
 User: myischenxiaohua@163.com
 Date: 2019-01-09
 Time: 0:15
 */

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/* @param <K> 表示主键
 * @param <V> 表示要操作的对象
 */
public interface BaseDao<K,V> {
    /**
     * 实现数据增加操作
     * @param vo 表示要执行操作的对象
     * @return 成功返回 true，失败返回 false
     * @throws SQLException
     */
    boolean createData(V vo) throws SQLException;

    /**
     * 实现数据更新操作
     * @param vo 表示要执行更新的对象
     * @return 成功返回 true，失败返回 false
     * @throws SQLException
     */
    boolean updateData(V vo) throws SQLException;

    /**
     * 实现数据批量删除
     * @param ids 表示要执行删除的数据集合
     * @return 成功返回 true，失败返回 false
     * @throws SQLException
     */
    boolean removeData(Set<?> ids) throws SQLException;

    /**
     * 根据用户提供的id执行查询
     * @param id 表示要查询的id
     * @return 查询成功返回该数据行的记录，失败返回null
     * @throws SQLException
     */
    V findById(K id) throws SQLException;

    /**
     * 实现数据全部查询
     * @return 成功返回全部数据，失败返回null
     * @throws SQLException
     */
    List<V> findAll() throws SQLException;

    /**
     * 实现数据分页操作
     * @param column 表示要执行查询的列
     * @param keyWord 表示查询关键字
     * @param currentPage 表示当前页
     * @param lineSize 表示每页显示记录数
     * @return 查询成功返回满足条件的数据，失败返回null
     * @throws SQLException
     */
    List<V> findBySplit(
            String column,
            String keyWord,
            Integer currentPage,
            Integer lineSize
    ) throws SQLException;

    /**
     * 实现数据量统计操作
     * @param column 表示要查询的列
     * @param keyWord 表示查询关键字
     * @return 成功返回数据量，失败返回0
     * @throws SQLException
     */
    Integer getAllCount(
            String column,
            String keyWord
    ) throws SQLException;
}
