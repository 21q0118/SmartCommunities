package ltbyz.practice_demo.wisdom_block.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltbyz.practice_demo.wisdom_block.mapper.CarMapper;
import ltbyz.practice_demo.wisdom_block.mapper.HouseHoldMapper;
import ltbyz.practice_demo.wisdom_block.mapper.ParkLendMapper;
import ltbyz.practice_demo.wisdom_block.pojo.Car;
import ltbyz.practice_demo.wisdom_block.pojo.Household;
import ltbyz.practice_demo.wisdom_block.pojo.Parklend;
import ltbyz.practice_demo.wisdom_block.pojo.Response;

@Service
public class ParkLendService {
    @Autowired
    ParkLendMapper parkLendMapper;

    public Response queryOne(String ParkID) {
        Response res = new Response();
        Parklend parklend = parkLendMapper.queryOne(ParkID);
        try {
            Date endTime = parklend.getEndTime();
            if (endTime == null) {
                res.setCode("2");
                res.setMsg("该车位已被租借");
            } else {
                res.setCode("1");
                res.setMsg("该车位未被租借");
                res.setValues(parklend);
            }
        } catch (Exception e) {
            res.setCode("1");
            res.setMsg("该车位未被租借");
        }

        return res;
    }

    public Response update(String ParkID, String CarID, Date StartTime) {
        Response res = new Response();
        int result;
        result = parkLendMapper.update(ParkID, CarID, StartTime);
        try {
            res.setMsg("车位修改成功");
        } catch (Exception e) {
            result = 2;
            res.setMsg("车位修改失败");
        }
        String s_result = String.valueOf(result);
        res.setCode(s_result);
        return res;
    }

    public Response add(String ParkID, String CarID, Date StartTime) {
        Response res = new Response();
        int result;
        result = parkLendMapper.add(ParkID, CarID, StartTime);
        try {
            res.setMsg("车位租借成功");
        } catch (Exception e) {
            result = 2;
            res.setMsg("车位租借失败");
        }
        String s_result = String.valueOf(result);
        res.setCode(s_result);
        return res;
    }

    @Autowired
    HouseHoldMapper holdMapper;

    public Response queryByCar(String phNum) {
        Household h = holdMapper.queryByPh(phNum);
        String IDnum = h.getIDnum();
        Response res = new Response();
        System.out.println(IDnum);
        List<Parklend> parklends = parkLendMapper.queryByCar(IDnum);
        parklends.remove(0);
        System.out.println(parklends);
        if (parklends.isEmpty()) {
            res.setCode("2");
            res.setMsg("未有车辆信息");
        } else {
            res.setCode("1");
            res.setMsg("车位信息查询成功");
            res.setValues(parklends);
        }
        return res;
    }

    @Autowired
    CarMapper carMapper;

    public Response Cars(String phNum) {
        Household household = holdMapper.queryByPh(phNum);
        Response res = new Response();
        String IDnum = household.getIDnum();
        String FID = household.getFID();
        if (FID == null) {
            res.setCode("2");
            res.setMsg("请先加入或创建家庭");
        } else {
            List<Car> cars = carMapper.Cars(IDnum);
            res.setCode("1");
            res.setMsg("车辆查询成功");
            res.setValues(cars);
        }
        return res;
    }
}
