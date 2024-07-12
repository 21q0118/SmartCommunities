package ltbyz.practice_demo.wisdom_block.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private String code;
    private String msg;
    private Object values;
}
