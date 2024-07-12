package ltbyz.practice_demo.wisdom_block.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ltbyz.practice_demo.wisdom_block.pojo.Response;
import ltbyz.practice_demo.wisdom_block.pojo.VoteProject;
import ltbyz.practice_demo.wisdom_block.pojo.VoteRecord;
import ltbyz.practice_demo.wisdom_block.services.VoteProjectService;
import ltbyz.practice_demo.wisdom_block.services.VoteRecordService;
import ltbyz.practice_demo.wisdom_block.services.VoteResultService;

import java.io.File;
import java.io.IOException;
import java.util.Random;

@RestController
@CrossOrigin(origins = "*")
public class VoteController {

    @Autowired
    VoteResultService vRService;

    @PostMapping("/secure/votes")
    public Response perAllPros(HttpServletRequest req, HttpServletResponse response) {
        Response res = vRService.queryAll();
        return res;
    }

    @Autowired
    VoteRecordService vRecordService;

    @PostMapping("/secure/pervotes")
    public Response perVote(HttpServletRequest req, @RequestBody VoteRecord vRecord) {
        String phNum = req.getAttribute("phNum").toString();
        System.out.println(phNum);
        Response res = vRecordService.add(vRecord, phNum);
        return res;
    }

    @Autowired
    VoteProjectService vPService;

    @PostMapping("/secure/newVote")
    public Response newVote(@RequestBody VoteProject vProject) {
        System.out.println(vProject);
        Random r = new Random();
        int voteNum = r.nextInt(99999);
        vProject.setVoteID(String.valueOf(voteNum));
        Response res = vPService.add(vProject);
        System.out.println(res);
        return res;
    }

}
