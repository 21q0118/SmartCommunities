package ltbyz.practice_demo.wisdom_block.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parklend {
    private String ParkID;
    private String CarID;
    private Date StartTime;
    private Date EndTime;
}
