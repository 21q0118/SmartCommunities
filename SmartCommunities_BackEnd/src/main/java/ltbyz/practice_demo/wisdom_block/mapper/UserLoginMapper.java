package ltbyz.practice_demo.wisdom_block.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ltbyz.practice_demo.wisdom_block.pojo.User;
import ltbyz.practice_demo.wisdom_block.pojo.UserLogin;

import java.util.List;

@Mapper
@Repository
public interface UserLoginMapper {

    List<UserLogin> queryAll();

    UserLogin queryOne(User userLogin);

    int add(String phNum, String password);

    UserLogin MLogin(User userLogin);

}
