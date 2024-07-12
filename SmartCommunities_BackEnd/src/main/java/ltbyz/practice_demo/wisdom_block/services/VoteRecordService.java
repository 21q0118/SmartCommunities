package ltbyz.practice_demo.wisdom_block.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltbyz.practice_demo.wisdom_block.mapper.HouseHoldMapper;
import ltbyz.practice_demo.wisdom_block.mapper.VoteRecordMapper;
import ltbyz.practice_demo.wisdom_block.pojo.Household;
import ltbyz.practice_demo.wisdom_block.pojo.Response;
import ltbyz.practice_demo.wisdom_block.pojo.VoteRecord;

@Service
public class VoteRecordService {
    @Autowired
    VoteRecordMapper voteRecordMapper;

    public Response queryOne(String IDnum, String VoteID) {
        Response res = new Response();
        VoteRecord voteRecord = voteRecordMapper.queryOne(IDnum, VoteID);
        if (voteRecord == null) {
            res.setCode("2");
            res.setMsg("该投票纪录不存在");
        } else {
            res.setCode("1");
            res.setMsg("投票纪录查询成功");
            res.setValues(voteRecord);
        }
        return res;
    }

    @Autowired
    HouseHoldMapper holdMapper;

    public Response add(VoteRecord voteRecord, String phNum) {
        Household h = holdMapper.queryByPh(phNum);
        String IDnum = h.getIDnum();
        voteRecord.setIDnum(IDnum);
        Response res = new Response();
        int result;
        try {
            result = voteRecordMapper.add(voteRecord);
            res.setMsg("投票成功");
        } catch (Exception e) {
            result = 2;
            res.setMsg("投票失败");
        }
        String s_result = String.valueOf(result);
        res.setCode(s_result);
        return res;
    }
}
