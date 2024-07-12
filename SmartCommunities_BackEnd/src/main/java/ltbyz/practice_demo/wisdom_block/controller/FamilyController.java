package ltbyz.practice_demo.wisdom_block.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import ltbyz.practice_demo.wisdom_block.pojo.Family;
import ltbyz.practice_demo.wisdom_block.pojo.PerInvite;
import ltbyz.practice_demo.wisdom_block.pojo.Response;
import ltbyz.practice_demo.wisdom_block.services.FamilyService;
import ltbyz.practice_demo.wisdom_block.services.PerInviteService;

@RestController
@CrossOrigin(origins = "*")
public class FamilyController {
    @Autowired
    FamilyService familyService;
    PerInviteService perInviteService;

    @PostMapping("/secure/newFamily")
    public Response newFamily(@RequestBody Family f, HttpServletRequest req) {
        String phNum = req.getAttribute("phNum").toString();
        System.out.println(f);
        String FName = f.getFName();
        System.out.println(FName);
        Random r = new Random();
        int ID = r.nextInt(99999);
        String FID = "F" + String.valueOf(ID);
        Response map = familyService.add(FID, FName, phNum);
        return map;
    }

    @PostMapping("/secure/calFamily")
    public Response calFamily(@RequestBody PerInvite pInvite) {
        System.out.println(pInvite);
        String FID = pInvite.getFID();
        System.out.println(FID);
        Response map = familyService.noFam(FID);
        return map;
    }

}
