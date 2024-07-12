package ltbyz.practice_demo.wisdom_block.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ltbyz.practice_demo.wisdom_block.pojo.VoteResult;

@Mapper
@Repository
public interface VoteResultMapper {
    List<VoteResult> queryAll();

    VoteResult queryOne(String VoteID);
}
