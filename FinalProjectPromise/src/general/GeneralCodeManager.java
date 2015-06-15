package general;

import ibatis.IbatisHelper;

import java.sql.SQLException;
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
			Integer pageNum, Integer pageSize) {
		int begin = (pageNum - 1) * pageSize;
		int end = pageNum * pageSize;

		List<GeneralCodeBean> arr = null;
		Map map = new HashMap();
		map.put("searchField", col);
		map.put("searchValue", input);
		map.put("begin", begin);
		map.put("end", end);

		try {
			arr = (List<GeneralCodeBean>) this.ibatis.queryForList(
					"genCode.selectGeneralCode", map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arr;
	}

	public GeneralCodeBean getGeneralCodeByGenId(String tmpGenId) throws SQLException {
		GeneralCodeBean genCodeBean = (GeneralCodeBean) this.ibatis.queryForObject("genCode.getGenCodeWithId", tmpGenId);
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
		} finally {
			this.ibatis.endTransaction();
		}

	}

	public void updateGeneralCode(String parentId, String genCodeCaption, int genCodeIndex, int empId, String genCodeId)
			throws SQLException {
		
		Map m = new HashMap();
		m.put("parentId", parentId);
		m.put("genCodeCaption", genCodeCaption);
		m.put("genCodeIndex", genCodeIndex);
		m.put("empId", empId);
		m.put("genCodeId", genCodeId);
		
		try {
			this.ibatis.startTransaction();
			this.ibatis.update("genCode.updateGeneralCode", m);
			this.ibatis.commitTransaction();
		} finally {
			this.ibatis.endTransaction();
		}

	}

	public void deleteGeneralCodeByCodeId(String genCodeId, int status) throws SQLException {
		Map m = new HashMap();
		m.put("status", status);
		m.put("genCodeId", genCodeId);
		
		try {
			this.ibatis.startTransaction();
			this.ibatis.update("genCode.deleteGeneralCode", m);
			this.ibatis.commitTransaction();
		} finally {
			this.ibatis.endTransaction();
		}
	}

}
