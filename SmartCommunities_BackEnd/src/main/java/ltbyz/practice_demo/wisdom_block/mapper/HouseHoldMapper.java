package ltbyz.practice_demo.wisdom_block.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ltbyz.practice_demo.wisdom_block.pojo.Household;

@Mapper
@Repository
public interface HouseHoldMapper {
    List<Household> queryByFId(String FID);

    Household queryByPh(String phNum);

    Household queryMaster(String FID);

    int asFID(String phNum, String FID);

    int calFID(String phNum);

    int add(Household household);

    int asMas(String phNum);

    int calMas(String phNum);

}
