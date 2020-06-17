package cn.dy.mapper;
import cn.dy.pojo.DyConsultants;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DyConsultantsMapper {

	public DyConsultants getDyConsultantsById(@Param(value = "id") String id)throws Exception;

	public List<DyConsultants>	getDyConsultantsListByMap(Map<String,Object> param)throws Exception;

	public Integer getDyConsultantsCountByMap(Map<String,Object> param)throws Exception;

	public Integer insertDyConsultants(DyConsultants dyConsultants)throws Exception;

	public Integer updateDyConsultants(DyConsultants dyConsultants)throws Exception;

	public Integer deleteDyConsultantsById(@Param(value = "id") String id)throws Exception;

	public Integer batchDeleteDyConsultants(Map<String,List<String>> params);

}
