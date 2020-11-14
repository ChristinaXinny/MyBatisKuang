package lxy.dao;

import com.lxy.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author ChristinaXinny
 * @create 2020-11-07 2:54 下午
 */
public interface UserMapper {

//    查询全部用户
    List<User> getUserList();

//    根据id查询用户
    User getUserById(int id);

//    插入
    int addUser(User u);

//    修改
    int updateUser(User u);

//    删除
    void deleteUser(int id);



//    万能map查询
    int addUserMap(Map<String, Object> map);
    int addUserMap2(Map<String, Object> map);


//    多个参数用map
    int addUserMap3(Map<String, Object> map);



    //    查询like用户
    List<User> getUserLike(String value);

}
