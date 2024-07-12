package ltbyz.practice_demo.wisdom_block.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltbyz.practice_demo.wisdom_block.mapper.VoteResultMapper;
import ltbyz.practice_demo.wisdom_block.pojo.Response;
import ltbyz.practice_demo.wisdom_block.pojo.VoteResult;

@Service
public class VoteResultService {
    @Autowired
    VoteResultMapper voteResultMapper;

    public Response queryAll() {
        Response res = new Response();
        List<VoteResult> voteResults = voteResultMapper.queryAll();
        System.out.println("voteResults:");
        System.out.println(voteResults);
        if (voteResults.isEmpty()) {
            res.setCode("2");
            res.setMsg("查询失败");
        } else {
            res.setCode("1");
            res.setMsg("查询成功");
            for (int i = 0; i < voteResults.size(); i++) {
                VoteResult voteResult = voteResults.get(i);
                String cond = voteResult.getVcondition();
                if (cond.equals("完成")) {
                    int agNum = voteResult.getAgreeNum();
                    int disNum = voteResult.getDisagNum();
                    String result = "";
                    if (agNum > disNum) {
                        result = "通过";
                    } else {
                        result = "淘汰";
                    }
                    voteResult.setResult(result);
                } else {
                    voteResult.setResult("请等待结果");
                }
            }
            res.setValues(voteResults);
        }
        return res;
    }

    public Response queryOne(String VoteID) {
        Response res = new Response();
        VoteResult voteResult = voteResultMapper.queryOne(VoteID);
        if (voteResult == null) {
            res.setCode("2");
            res.setMsg("查询失败");
        } else {
            res.setCode("1");
            res.setMsg("查询成功");
            res.setValues(voteResult);
        }
        return res;
    }
}
