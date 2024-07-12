package ltbyz.practice_demo.wisdom_block.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jakarta.servlet.http.HttpServletRequest;
import ltbyz.practice_demo.wisdom_block.pojo.Problem;
import ltbyz.practice_demo.wisdom_block.pojo.Response;
import ltbyz.practice_demo.wisdom_block.services.PromblemService;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

@RestController
@CrossOrigin(origins = "*")
public class ProblemController {

    @Autowired
    PromblemService pService;

    @PostMapping("/secure/upload")
    // public Response upload(@RequestParam("file") MultipartFile file,
    // @RequestParam("ProInfo") Problem problem,
    // HttpServletRequest request) {
    // System.out.println(file);
    public Response upload(@RequestBody Problem problem,
            HttpServletRequest request) {
        Date newTime = problem.getReTime();
        problem.setNewTime(newTime);
        Random r = new Random();
        int proNum = r.nextInt(99999);
        List<String> types = new ArrayList<>();
        types.add("环境");
        types.add("维修");
        types.add("居民");
        types.add("水电");
        types.add("道路");
        int i = r.nextInt(types.size());
        String PType = types.get(i);
        problem.setProNum(String.valueOf(proNum));
        problem.setPType(PType);
        String phNum = request.getAttribute("phNum").toString();
        Response res = pService.add(problem, phNum);
        System.out.println(problem);
        System.out.println(res);
        return res;
    }

    @PostMapping("/secure/perAllPros")
    public Response perAllPros(HttpServletRequest req) {
        String phNum = req.getAttribute("phNum").toString();
        Response res = pService.queryPerAll(phNum);
        return res;
    }

    @PostMapping("/secure/AllPros")
    public Response AllPros() {
        System.out.println("problems");
        Response res = pService.queryAllPros();
        return res;
    }

    @PostMapping("/secure/AllComs")
    public Response AllComs() {
        System.out.println("complains");
        Response res = pService.queryAllComs();
        return res;
    }

    @PostMapping("/secure/queryOne")
    public Response queryOne(@RequestParam("ProNum") String ProNum) {
        System.out.println(ProNum);
        Response res = pService.queryOne(ProNum);
        return res;
    }

}
