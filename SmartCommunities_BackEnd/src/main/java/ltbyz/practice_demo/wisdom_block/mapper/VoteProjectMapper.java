package ltbyz.practice_demo.wisdom_block.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ltbyz.practice_demo.wisdom_block.pojo.VoteProject;

@Mapper
@Repository
public interface VoteProjectMapper {
    int add(VoteProject voteProject);
}
