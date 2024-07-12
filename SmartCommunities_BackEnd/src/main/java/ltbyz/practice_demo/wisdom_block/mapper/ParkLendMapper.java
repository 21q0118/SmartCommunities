package ltbyz.practice_demo.wisdom_block.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ltbyz.practice_demo.wisdom_block.pojo.Parklend;

@Mapper
@Repository
public interface ParkLendMapper {
    Parklend queryOne(String ParkID);

    int add(String ParkID, String CarID, Date StartTime);

    int update(String ParkID, String CarID, Date StartTime);

    List<Parklend> queryByCar(String IDnum);
}
