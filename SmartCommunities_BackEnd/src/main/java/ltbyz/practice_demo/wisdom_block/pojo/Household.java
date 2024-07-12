package ltbyz.practice_demo.wisdom_block.pojo;

import java.sql.Date;

// import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Household {
    private String IDnum;
    private String PHnum;
    private String Sex;
    private String PName;
    private String Role;
    private String FID;

    private Date Birthday;
}
