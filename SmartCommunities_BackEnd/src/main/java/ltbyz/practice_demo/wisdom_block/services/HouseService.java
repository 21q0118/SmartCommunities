package ltbyz.practice_demo.wisdom_block.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltbyz.practice_demo.wisdom_block.mapper.HouseMapper;
import ltbyz.practice_demo.wisdom_block.pojo.House;
import ltbyz.practice_demo.wisdom_block.pojo.Response;

@Service
public class HouseService {
    @Autowired
    HouseMapper houseMapper;

    public Response queryOne(String ComName, String buildNum, String HouseNum) {
        Response res = new Response();
        House house = houseMapper.queryOne(ComName, buildNum, HouseNum);
        if (house == null) {
            res.setCode("2");
            res.setMsg("该房屋不存在");
        } else {
            res.setCode("1");
            res.setMsg("房屋查询成功");
            res.setValues(house);
        }
        return res;
    }

    public Response bindH_C(String ComName, String buildNum, String HouseNum, String CarID) {
        Response res = new Response();
        int result;
        try {
            result = houseMapper.bindH_C(ComName, buildNum, HouseNum, CarID);
            res.setMsg("房屋车辆绑定成功");
        } catch (Exception e) {
            result = 2;
            res.setMsg("房屋车辆绑定失败");
        }
        String s_result = String.valueOf(result);
        res.setCode(s_result);
        return res;
    }

    public Response calH_C(String ComName, String buildNum, String HouseNum, String CarID) {
        Response res = new Response();
        int result;
        try {
            result = houseMapper.calH_C(ComName, buildNum, HouseNum, CarID);
            res.setMsg("房屋车辆解绑成功");
        } catch (Exception e) {
            result = 2;
            res.setMsg("房屋车辆解绑失败");
        }
        String s_result = String.valueOf(result);
        res.setCode(s_result);
        return res;
    }

}
