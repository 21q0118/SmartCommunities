package ltbyz.practice_demo.wisdom_block.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import ltbyz.practice_demo.wisdom_block.pojo.Household;
import ltbyz.practice_demo.wisdom_block.pojo.PerInvite;
import ltbyz.practice_demo.wisdom_block.pojo.Response;
import ltbyz.practice_demo.wisdom_block.services.HouseholdService;
import ltbyz.practice_demo.wisdom_block.services.PerInviteService;

@RestController
@CrossOrigin(origins = "*")
public class HouseholdController {
    @Autowired
    HouseholdService householdService;

    @PostMapping("/secure/perInfo")
    public Response perInfo(HttpServletRequest request) throws SQLException {
        String phNum = request.getAttribute("phNum").toString();
        System.out.println(phNum);
        Response result = householdService.queryOne(phNum);
        System.out.println(result);
        return result;
    }

    @PostMapping("/secure/familyInfo")
    public Response familyInfo(HttpServletRequest request) throws SQLException {
        String phNum = request.getAttribute("phNum").toString();
        Response result = householdService.queryByFID(phNum);
        return result;
    }

    @PostMapping("/secure/real")
    public Response getReal(@RequestBody Household household, HttpServletRequest request) throws SQLException {
        String phNum = request.getAttribute("phNum").toString();
        household.setPHnum(phNum);
        System.out.println(household);
        Response res = householdService.getReal(household);
        System.out.println(res);
        return res;
    }

    @PostMapping("/secure/bindF")
    public Response bindF(@RequestBody PerInvite invite, HttpServletRequest request) throws SQLException {
        String phNum = request.getAttribute("phNum").toString();
        String FID = invite.getFID();
        System.out.println(invite);
        Response res = householdService.asFID(phNum, FID);
        System.out.println(res);
        return res;
    }

    @PostMapping("/secure/calF")
    public Response calF(HttpServletRequest request) throws SQLException {
        String phNum = request.getAttribute("phNum").toString();
        Response res = householdService.cancelPF(phNum);
        System.out.println(res);
        return res;
    }

    @Autowired
    PerInviteService pInviteService;

    @PostMapping("/secure/invite")
    public Response invite(@RequestBody PerInvite pInvite, HttpServletRequest request) throws SQLException {
        String DphNum = request.getAttribute("phNum").toString();
        pInvite.setDPHnum(DphNum);
        System.out.println(pInvite);
        Response res = pInviteService.invite(pInvite);
        System.out.println(res);
        return res;
    }

    @PostMapping("/secure/refuse")
    public Response refuse(@RequestBody PerInvite pInvite, HttpServletRequest request) throws SQLException {
        String phNum = request.getAttribute("phNum").toString();
        String FID = pInvite.getFID();
        Response res = pInviteService.refuse(FID, phNum);
        System.out.println(res);
        return res;
    }
}
