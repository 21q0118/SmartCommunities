package ltbyz.practice_demo.wisdom_block.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ltbyz.practice_demo.wisdom_block.pojo.VoteRecord;

@Mapper
@Repository
public interface VoteRecordMapper {
    VoteRecord queryOne(String IDnum, String VoteID);

    int add(VoteRecord voteRecord);
}
