package ltbyz.practice_demo.wisdom_block.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ltbyz.practice_demo.wisdom_block.pojo.Family;

@Mapper
@Repository

public interface FamilyMapper {
    int add(String FID, String FName);

    Family queryByFID(String FID);

    int noFam(String FID);
}
