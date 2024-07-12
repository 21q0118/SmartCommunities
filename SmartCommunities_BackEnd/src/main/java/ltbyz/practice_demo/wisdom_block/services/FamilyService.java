package ltbyz.practice_demo.wisdom_block.services;

import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltbyz.practice_demo.wisdom_block.mapper.FamilyMapper;
import ltbyz.practice_demo.wisdom_block.mapper.HouseHoldMapper;
import ltbyz.practice_demo.wisdom_block.mapper.PerInviteMapper;
import ltbyz.practice_demo.wisdom_block.pojo.Family;
import ltbyz.practice_demo.wisdom_block.pojo.Response;

@Service
public class FamilyService {
    @Autowired
    FamilyMapper familyMapper;

    public Response queryOne(String FID) {
        Response res = new Response();
        Family family = familyMapper.queryByFID(FID);
        if (family == null) {
            res.setCode("2");
            res.setMsg("该家庭不存在");
        } else {
            res.setCode("1");
            res.setMsg("查询成功");
            res.setValues(family);
        }
        return res;
    }

    @Autowired
    HouseHoldMapper holdMapper;

    public Response add(String FID, String FName, String phNum) {
        Response res = new Response();
        int sql_res;
        try {
            sql_res = familyMapper.add(FID, FName);
            sql_res = holdMapper.asFID(phNum, FID);
            sql_res = holdMapper.asMas(phNum);
            res.setMsg("新建成功");
        } catch (Exception e) {
            sql_res = 2;
            res.setMsg("新建失败");
        }
        String result = String.valueOf(sql_res);
        System.out.println(result);
        res.setCode(result);
        return res;
    }

    @Autowired
    PerInviteMapper pInviteMapper;

    public Response noFam(String FID) {
        Response res = new Response();
        int sql_res;
        try {
            sql_res = pInviteMapper.deleteAll(FID);
            sql_res = holdMapper.calMas(FID);
            sql_res = familyMapper.noFam(FID);
            res.setMsg("解散成功");
        } catch (Exception e) {
            sql_res = 1;
            res.setMsg("解散失败");
        }
        String result = String.valueOf(sql_res);
        System.out.println(result);
        res.setCode(result);
        return res;
    }

}
