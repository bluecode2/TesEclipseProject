package general;

import ibatis.IbatisHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

public class GeneralCodeManager {
	private SqlMapClient ibatis;

	public GeneralCodeManager() {
		// TODO Auto-generated constructor stub
		this.ibatis = IbatisHelper.getSqlMapInstance();
	}

	public List<GeneralCodeBean> getAllGeneralCode(String col, String input,
			Integer pageNum, Integer pageSize){
		int begin = (pageNum - 1) * pageSize;
		int end = pageNum * pageSize;
		List<GeneralCodeBean> arr = new ArrayList<GeneralCodeBean>();
		
		Map map = new HashMap();
		map.put("searchField", col);
		map.put("searchValue", input);
		map.put("begin", begin);
		map.put("end", end);		

		try {
			arr = this.ibatis.queryForList(
						"genCode.selectGeneralCode", map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arr;
	}

	public GeneralCodeBean getGeneralCodeByGenId(String tmpGenId) {
		GeneralCodeBean genCodeBean = null;

		try {
			genCodeBean = (GeneralCodeBean) this.ibatis.queryForObject("genCode.getGenCodeWithId", tmpGenId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(genCodeBean);
		return genCodeBean;
	}
	
	public int getCountGeneralCode(String column, String value)
			throws SQLException {
		Map map = new HashMap();
		map.put("searchField", column);
		map.put("searchValue", value);

		int count = (Integer) this.ibatis.queryForObject(
				"genCode.countGeneralCode", map);

		return count;
	}

	public void insertGeneralCode(GeneralCodeBean genCodebean)
			throws SQLException {

		try {
			this.ibatis.startTransaction();
			this.ibatis.insert("genCode.insertGeneralCode", genCodebean);
			this.ibatis.commitTransaction();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				ibatis.endTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void updateGeneralCode(GeneralCodeBean genCodeBean)
			throws SQLException {
		
		try {
			this.ibatis.startTransaction();
			this.ibatis.update("genCode.updateGeneralCode", genCodeBean);
			this.ibatis.commitTransaction();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				ibatis.endTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void deleteGeneralCodeByCodeId(String genCodeId) throws SQLException {
		try {
			this.ibatis.startTransaction();
			this.ibatis.update("genCode.deleteGeneralCode", genCodeId);
			this.ibatis.commitTransaction();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				ibatis.endTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public List<GeneralCodeBean> getGeneralCodeByParentId(String parentId) {
		List<GeneralCodeBean> arrList = new ArrayList<GeneralCodeBean>();
		
		try {
			arrList = this.ibatis.queryForList("genCode.selectGeneralCodeByParentId", parentId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrList;
	}
}
