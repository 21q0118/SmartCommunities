package ltbyz.practice_demo.wisdom_block.pojo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteResult {
    private String VoteID;
    private String VoteName;
    private String VType;
    private String Vcondition;
    private int CostNum;
    private Date CostTime;
    private Date StartTime;
    private Date EndTime;
    private int AgreeNum;
    private int DisagNum;
    private int GiveupNum;
    private String result;
}
