package ltbyz.practice_demo.wisdom_block.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ltbyz.practice_demo.wisdom_block.pojo.House;

@Mapper
@Repository
public interface HouseMapper {
    House queryOne(String ComName, String buildNum, String HouseNum);

    int bindH_C(String ComName, String buildNum, String HouseNum, String CarID);

    int calH_C(String ComName, String buildNum, String HouseNum, String CarID);

    List<House> queryByIDnum(String IDnum);

}
