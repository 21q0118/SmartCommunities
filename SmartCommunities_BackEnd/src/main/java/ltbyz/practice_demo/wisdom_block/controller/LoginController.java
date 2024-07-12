package ltbyz.practice_demo.wisdom_block.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import ltbyz.practice_demo.wisdom_block.jwt.JwtUtil;
import ltbyz.practice_demo.wisdom_block.pojo.Response;
import ltbyz.practice_demo.wisdom_block.pojo.User;
import ltbyz.practice_demo.wisdom_block.services.EnrollService;
import ltbyz.practice_demo.wisdom_block.services.LoginService;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public Response login(@RequestBody User user, HttpServletResponse response)
            throws SQLException {
        System.out.println(user);
        Response res = loginService.queryOne(user);
        System.out.println(res);
        if (res.getCode().equals("1")) {
            String token = JwtUtil.createToken(user);
            response.addHeader("token", token);
            res.setValues(null);
        } else if (res.getCode().equals("3")) {
            String token = JwtUtil.createToken(user);
            System.out.println(token);
            response.addHeader("token", token);
            res.setValues(null);
        }
        return res;
    }

    @PostMapping("/MLogin")
    public Response mLogin(@RequestBody User u, HttpServletResponse response) throws SQLException {
        System.out.println(u);
        Response res = loginService.MLogin(u);
        if (res.getCode().equals("1")) {
            String token = JwtUtil.createToken(u);
            response.addHeader("token", token);
            res.setValues(null);
        }
        System.out.println(res);
        return res;
    }

    @Autowired
    EnrollService enrollService;

    @PostMapping("/enroll")
    public Response enroll(@RequestBody User userLogin) throws SQLException {
        System.out.println(userLogin);
        Response enrollResult = enrollService.Enroll(userLogin);
        return enrollResult;
    }
}
