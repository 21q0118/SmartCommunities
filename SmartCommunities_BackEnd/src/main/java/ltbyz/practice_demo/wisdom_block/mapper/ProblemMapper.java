package ltbyz.practice_demo.wisdom_block.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ltbyz.practice_demo.wisdom_block.pojo.Problem;

@Mapper
@Repository
public interface ProblemMapper {
    List<Problem> queryAll(String IDnum);

    List<Problem> queryPro();

    List<Problem> queryCom();

    Problem queryByID(String ProNum);

    int add(Problem problem);
}
