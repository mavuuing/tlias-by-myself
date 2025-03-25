package com.itheima.mapper;
import com.itheima.pojo.Result;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.itheima.pojo.Emp;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
//    /**
//     * 统计总记录数
//     * @return
//     */
//    @Select("select count(*) from emp")
//    Long count();
//    /**
//     * 分页查询
//     * @param start
//     * @param pageSize
//     * @return
//     */
    //方式一：
//    @Select("select * from emp limit #{start},#{pageSize}")
//    List<Emp> page(Integer start, Integer pageSize);

    //方式二：PageHelper
//    @Select("select * from emp")
//    public List<Emp> list();

    /**
     * 条件查询
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     *  批量删除
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 新增员工
     * @param emp
     */
    @Insert("Insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values " +
            "(#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime}) ")
    void insert(Emp emp);

    /**
     * 按照id查询
     * @param id
     * @return
     */
    @Select("select * from emp where id=#{id}")
    Emp getById(Integer id);

    void update(Emp emp);

    /**
     * 登录
     * @param emp
     * @return
     */
    @Select("select * from emp where username= #{username} and password=#{password}")
    Emp getByUsernameAndPassword(Emp emp);

    /**
     * 根据部门信息删除员工
     * @param deptId
     */
    @Delete("delete from emp where dept_id=#{id}")
    void deleteByDeptId(Integer deptId);
}
