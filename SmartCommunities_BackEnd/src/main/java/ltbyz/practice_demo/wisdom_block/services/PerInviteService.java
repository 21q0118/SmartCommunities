package ltbyz.practice_demo.wisdom_block.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltbyz.practice_demo.wisdom_block.mapper.HouseHoldMapper;
import ltbyz.practice_demo.wisdom_block.mapper.HouseMapper;
import ltbyz.practice_demo.wisdom_block.mapper.PerInviteMapper;
import ltbyz.practice_demo.wisdom_block.pojo.Household;
import ltbyz.practice_demo.wisdom_block.pojo.PerInvite;
import ltbyz.practice_demo.wisdom_block.pojo.Response;

@Service
public class PerInviteService {
    @Autowired
    PerInviteMapper perInviteMapper;

    @Autowired
    HouseHoldMapper holdMapper;

    public Response isInvited(String IPHnum) {
        Response res = new Response();
        PerInvite invites = perInviteMapper.queryByIPHnum(IPHnum);

        if (invites == null) {
            res.setCode("4");
            res.setMsg("未收到邀请");
        } else {
            String DPHnum = invites.getDPHnum();
            Household h = holdMapper.queryByPh(DPHnum);
            String DName = h.getPName();
            invites.setDPHnum(DName);
            res.setCode("3");
            res.setMsg("有邀请");
            res.setValues(invites);
        }
        return res;
    }

    public Response invite(PerInvite pInvite) {
        Response res = new Response();
        String DPHnum = pInvite.getDPHnum();
        Household h = holdMapper.queryByPh(DPHnum);
        String FID = h.getFID();
        pInvite.setFID(FID);
        int result;

        try {
            result = perInviteMapper.add(pInvite);
            res.setMsg("邀请成功");
        } catch (Exception e) {
            result = 2;
            res.setMsg("邀请失败");
        }
        String s_result = String.valueOf(result);
        res.setCode(s_result);
        return res;
    }

    public Response refuse(String FID, String phNum) {
        Response res = new Response();
        int result;
        result = perInviteMapper.delete(FID, phNum);
        try {
            res.setMsg("拒绝成功");
        } catch (Exception e) {
            result = 2;
            res.setMsg("拒绝失败");
        }
        String s_result = String.valueOf(result);
        res.setCode(s_result);
        return res;
    }
}
