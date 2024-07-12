package ltbyz.practice_demo.wisdom_block.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltbyz.practice_demo.wisdom_block.mapper.UserLoginMapper;
import ltbyz.practice_demo.wisdom_block.pojo.Response;
import ltbyz.practice_demo.wisdom_block.pojo.User;
import ltbyz.practice_demo.wisdom_block.pojo.UserLogin;

@Service
public class EnrollService {
    @Autowired
    UserLoginMapper userLoginMapper;

    public Response Enroll(User userLogin) {
        UserLogin tempUser = userLoginMapper.queryOne(userLogin);
        Response res = new Response();
        if (tempUser == null) {
            String phNum = userLogin.getPHnum();
            String password = userLogin.getPpword();
            userLoginMapper.add(phNum, password);
            res.setCode("1");
            res.setMsg("添加成功");
        } else {
            res.setCode("2");
            res.setMsg("此号码已注册");
        }
        return res;
    }
}
