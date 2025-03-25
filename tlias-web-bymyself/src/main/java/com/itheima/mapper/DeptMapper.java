package com.itheima.mapper;

import org.apache.ibatis.annotations.*;
import com.itheima.pojo.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询所有部门数据
     * @return
     */
    @Select("select id, name, create_time, update_time from dept")
    List<Dept> list();//将结果映射到Dept对象中，然后将Dept对象存储到List集合中



    /**
     * 根据id删除部门数据
     * @param id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * 新增部门数据
     * @param dept
     */
    @Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    void save(Dept dept);

    /**
     * 根据id查询部门数据
     * @param id
     * @return
     */
    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept getById(Integer id);
    /**
     * 修改部门数据
     * @param dept
     */
    @Update("update dept set name=#{name}, update_time=#{updateTime} where id=#{id}")
    void update(Dept dept);
}