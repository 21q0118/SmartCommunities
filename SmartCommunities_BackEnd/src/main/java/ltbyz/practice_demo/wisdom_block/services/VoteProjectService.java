package ltbyz.practice_demo.wisdom_block.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltbyz.practice_demo.wisdom_block.mapper.VoteProjectMapper;
import ltbyz.practice_demo.wisdom_block.pojo.Response;
import ltbyz.practice_demo.wisdom_block.pojo.VoteProject;

@Service
public class VoteProjectService {
    @Autowired
    VoteProjectMapper voteProjectMapper;

    public Response add(VoteProject voteProject) {
        Response res = new Response();
        int result;
        result = voteProjectMapper.add(voteProject);
        try {
            res.setMsg("投票项目创建成功");
        } catch (Exception e) {
            result = 2;
            res.setMsg("投票项目创建失败");
        }
        String s_result = String.valueOf(result);
        res.setCode(s_result);
        return res;
    }
}
