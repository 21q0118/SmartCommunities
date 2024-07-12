package ltbyz.practice_demo.wisdom_block.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteRecord {
    private String IDnum;
    private String VoteID;
    private String Result;
}
