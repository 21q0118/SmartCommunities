package ltbyz.practice_demo.wisdom_block.pojo;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteProject {
    private String VoteID;
    private String VoteName;
    private String VType;
    private int AgreeNum;
    private int DisagNum;
    private int CostNum;

    private Date StartTime;
    private Date EndTime;
    private Date CostTime;
}
