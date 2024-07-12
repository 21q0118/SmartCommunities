package ltbyz.practice_demo.wisdom_block.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ltbyz.practice_demo.wisdom_block.pojo.PerInvite;

@Mapper
@Repository
public interface PerInviteMapper {
    PerInvite queryByIPHnum(String IPHnum);

    int add(PerInvite pInvite);

    int delete(String FID, String phNum);

    int deleteAll(String FID);
}
