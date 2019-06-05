package net.wanho.mapper;

import net.wanho.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2019/6/5.
 */
public interface UserMapper {
    void insert(User user);


    void insertReturnKey(User user);


    void updateUser(String username,String password,Integer id);


    void updateUser1(@Param("id") Integer id, @Param("username") String username, @Param("password") String password);

    void updateUser2(@Param("user") User user,@Param("id") Integer id);

    @Update("UPDATE USER  set username=#{user.username1} ,password=#{user.password} where id=#{id}")
    void updateUser3(@Param("user") User user,@Param("id") Integer id);



    void insertReturnKey1(User user);

    List<User> selectUserByName(String name);

    List<User> selectUserByName1(User user);

    List<User> selectUserByName2(String name);

    List<User> selectAllUser();

    User selectUserById(Integer id);
}
