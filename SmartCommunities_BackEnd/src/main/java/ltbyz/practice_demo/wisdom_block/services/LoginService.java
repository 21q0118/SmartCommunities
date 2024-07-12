package ltbyz.practice_demo.wisdom_block.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltbyz.practice_demo.wisdom_block.mapper.UserLoginMapper;
import ltbyz.practice_demo.wisdom_block.pojo.Response;
import ltbyz.practice_demo.wisdom_block.pojo.User;
import ltbyz.practice_demo.wisdom_block.pojo.UserLogin;

@Service
public class LoginService {
    @Autowired
    UserLoginMapper userLoginMapper;

    public Response queryOne(User uLogin) {
        UserLogin userLogin = userLoginMapper.queryOne(uLogin);
        System.out.println(userLogin);
        Response res = new Response();
        if (userLogin == null) { // 未注册
            res.setCode("2");
            res.setMsg("未注册");
        } else {
            String isReal = userLogin.getIsreal();
            if (isReal.equals("未实名")) { // 未实名
                res.setCode("3");
                res.setMsg("未实名");
            } else {
                res.setCode("1"); // 登陆成功
                res.setMsg("登录成功");
                res.setValues(uLogin);
            }
        }
        // jwt
        return res;
    }

    public Response MLogin(User uLogin) {
        UserLogin userLogin = userLoginMapper.MLogin(uLogin);
        System.out.println(userLogin);
        Response res = new Response();
        if (userLogin == null) {
            res.setCode("2");
            res.setMsg("未注册");
        } else {
            res.setCode("1"); // 登陆成功
            res.setMsg("登录成功");
            res.setValues(uLogin);
        }
        return res;
    }
    // jwt
}
