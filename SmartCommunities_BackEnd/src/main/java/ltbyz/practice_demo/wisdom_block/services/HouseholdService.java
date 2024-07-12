package ltbyz.practice_demo.wisdom_block.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltbyz.practice_demo.wisdom_block.mapper.FamilyMapper;
import ltbyz.practice_demo.wisdom_block.mapper.HouseHoldMapper;
import ltbyz.practice_demo.wisdom_block.mapper.PerInviteMapper;
import ltbyz.practice_demo.wisdom_block.pojo.Family;
import ltbyz.practice_demo.wisdom_block.pojo.Household;
import ltbyz.practice_demo.wisdom_block.pojo.PerInvite;
import ltbyz.practice_demo.wisdom_block.pojo.Response;

@Service
public class HouseholdService {
    @Autowired
    HouseHoldMapper houseHoldMapper;

    @Autowired
    PerInviteMapper perInviteMapper;

    public Response asFID(String phNum, String FID) {
        Response res = new Response();
        int result;
        try {
            result = houseHoldMapper.asFID(phNum, FID);
            result = pInviteMapper.delete(FID, phNum);
            res.setMsg("家庭绑定成功");
        } catch (Exception e) {
            result = 2;
            res.setMsg("家庭绑定失败");
        }
        String s_result = String.valueOf(result);
        res.setCode(s_result);
        return res;
    }

    public Response cancelPF(String phNum) {
        Response res = new Response();
        int result;
        result = houseHoldMapper.calFID(phNum);
        try {
            res.setMsg("家庭解绑成功");
        } catch (Exception e) {
            result = 2;
            res.setMsg("家庭解绑失败");
        }
        String s_result = String.valueOf(result);
        res.setCode(s_result);
        return res;
    }

    @Autowired
    FamilyMapper fMapper;

    @Autowired
    PerInviteService pInviteService;

    public Response hasFamily(String phNum) {
        Response res = new Response();
        Household h = houseHoldMapper.queryByPh(phNum);
        String FID = h.getFID();
        if (FID == null) {
            res.setCode("2");
            res.setMsg("还未加入家庭");
        } else {
            res.setCode("1");
            res.setMsg("已加入家庭");
        }
        return res;
    }

    public Response queryByFID(String phNum) {
        Response f_res = hasFamily(phNum);
        Response res = new Response();
        if (f_res.getCode().equals("2")) {
            res = pInviteService.isInvited(phNum);
        } else {
            Household h = houseHoldMapper.queryByPh(phNum);
            String FID = h.getFID();
            Family family = fMapper.queryByFID(FID);
            List<Household> households = houseHoldMapper.queryByFId(FID);
            Map<String, Object> data = new HashMap<>();
            data.put("familyInfo", family);
            data.put("members", households);
            res.setValues(data);
            String role = h.getRole();
            if (role.equals("家庭成员")) {
                res.setCode("2");
                res.setMsg("家庭信息查询成功，角色为家庭成员");
            } else {
                res.setCode("1");
                res.setMsg("家庭信息查询成功，角色为家主");
            }
        }
        return res;
    }

    public Response queryOne(String phNum) {
        Response res = new Response();
        Household household = houseHoldMapper.queryByPh(phNum);
        if (household == null) {
            res.setCode("2");
            res.setMsg("该用户不存在");
        } else {
            res.setCode("1");
            res.setMsg("个人信息查询成功");
            res.setValues(household);
        }
        return res;
    }

    @Autowired
    PerInviteMapper pInviteMapper;

    public Response getReal(Household household) {
        Response res = new Response();
        int result;
        try {
            result = houseHoldMapper.add(household);
            res.setMsg("实名成功");
            String phNum = household.getPHnum();
            PerInvite invite = pInviteMapper.queryByIPHnum(phNum);
            if (invite != null) {
                String FID = invite.getFID();
                asFID(phNum, FID);
                result = 3;
                res.setMsg("实名成功,并自动绑定家庭");
                res.setValues(invite);
            }
        } catch (Exception e) {
            System.out.println(e);
            result = 2;
            res.setMsg("实名失败");
        }
        String s_result = String.valueOf(result);
        res.setCode(s_result);
        return res;
    }

}
