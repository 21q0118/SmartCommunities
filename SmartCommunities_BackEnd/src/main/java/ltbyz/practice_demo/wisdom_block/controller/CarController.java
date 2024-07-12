package ltbyz.practice_demo.wisdom_block.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import ltbyz.practice_demo.wisdom_block.pojo.Parklend;
import ltbyz.practice_demo.wisdom_block.pojo.Response;
import ltbyz.practice_demo.wisdom_block.services.ParkLendService;

@RestController
@CrossOrigin(origins = "*")
public class CarController {
    @Autowired
    ParkLendService pLendService;

    @PostMapping("/secure/cars")
    public Response cars(HttpServletRequest req) {
        String phNum = req.getAttribute("phNum").toString();
        System.out.println(phNum);
        Response res = pLendService.queryByCar(phNum);
        return res;
    }

    @PostMapping("/secure/parkLend")
    public Response lendPark(@RequestBody Parklend parklend) {
        String parkID = parklend.getParkID();
        Response parkInfo = pLendService.queryOne(parkID);
        Response res = new Response();
        String isNull = parkInfo.getCode();
        System.out.println(parklend);
        if (isNull.equals("1")) {
            String CarID = parklend.getCarID();
            Date StartTime = parklend.getStartTime();
            res = pLendService.add(parkID, CarID, StartTime);
        } else {
            res = parkInfo;
        }
        return res;
    }

    @PostMapping("/secure/changeParkLend")
    public Response changePark(@RequestBody Parklend parklend) {
        String parkID = parklend.getParkID();
        Response parkInfo = pLendService.queryOne(parkID);
        Response res = new Response();
        String isNull = parkInfo.getCode();
        System.out.println(parklend);
        if (isNull.equals("1")) {
            String CarID = parklend.getCarID();
            Date StartTime = parklend.getStartTime();
            res = pLendService.update(parkID, CarID, StartTime);
        } else {
            res = parkInfo;
        }
        return res;
    }
}
