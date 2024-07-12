package ltbyz.practice_demo.wisdom_block.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltbyz.practice_demo.wisdom_block.mapper.HouseHoldMapper;
import ltbyz.practice_demo.wisdom_block.mapper.ProblemMapper;
import ltbyz.practice_demo.wisdom_block.pojo.Problem;
import ltbyz.practice_demo.wisdom_block.pojo.Household;
import ltbyz.practice_demo.wisdom_block.pojo.Response;

@Service
public class PromblemService {
    @Autowired
    ProblemMapper problemMapper;

    @Autowired
    HouseHoldMapper holdMapper;

    public Response queryPerAll(String phNum) {
        Household h = holdMapper.queryByPh(phNum);
        String IDnum = h.getIDnum();
        Response res = new Response();
        List<Problem> problems = problemMapper.queryAll(IDnum);
        if (problems.isEmpty()) {
            res.setCode("2");
            res.setMsg("没有问题或投诉");
        } else {
            res.setCode("1");
            res.setMsg("个人问题或投诉查询成功");
            res.setValues(problems);
        }
        return res;
    }

    public Response queryAllPros() {
        Response res = new Response();
        List<Problem> problems = problemMapper.queryPro();
        if (problems.isEmpty()) {
            res.setCode("2");
            res.setMsg("没有问题上报");
        } else {
            res.setCode("1");
            res.setMsg("问题上报查询成功");
            res.setValues(problems);
        }
        return res;
    }

    public Response queryAllComs() {
        Response res = new Response();
        List<Problem> problems = problemMapper.queryCom();
        if (problems.isEmpty()) {
            res.setCode("2");
            res.setMsg("没有投诉上报");
        } else {
            res.setCode("1");
            res.setMsg("投诉查询成功");
            res.setValues(problems);
        }
        return res;
    }

    public Response queryOne(String ProNum) {
        Response res = new Response();
        Problem problem = problemMapper.queryByID(ProNum);
        if (problem == null) {
            res.setCode("2");
            res.setMsg("查询失败");
        } else {
            res.setCode("1");
            res.setMsg("查询成功");
            res.setValues(problem);
        }
        return res;
    }

    public Response add(Problem problem, String phNum) {
        Household h = holdMapper.queryByPh(phNum);
        String IDnum = h.getIDnum();
        problem.setIDnum(IDnum);
        Response res = new Response();
        int result;
        try {
            result = problemMapper.add(problem);
            res.setMsg("上报成功");
        } catch (Exception e) {
            result = 2;
            res.setMsg("上报失败");
        }
        String s_result = String.valueOf(result);
        res.setCode(s_result);
        return res;
    }
}
