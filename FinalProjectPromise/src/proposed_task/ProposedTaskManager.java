package proposed_task;

import ibatis.IbatisHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

public class ProposedTaskManager {
	private SqlMapClient ibatis;

	public ProposedTaskManager() {
		this.ibatis = IbatisHelper.getSqlMapInstance();
	}

	public List<ProposedTaskBean> getAllPropTaskFiltered(String col,
			String input, Integer pageNum, Integer pageSize, int userId) throws SQLException {
		int begin = (pageNum - 1) * pageSize;
		int end = pageNum * pageSize;
		System.out.println(col + "-" + input + "-"+ begin + "-"+ end);
		
		Map map = new HashMap();
		map.put("searchField", col);
		map.put("searchValue", input);
		map.put("begin", begin);
		map.put("end", end);
		map.put("userId", userId);

	
		List<ProposedTaskBean> 	arr = this.ibatis.queryForList("proposedTask.getListProposedTask", map);

		System.out.println(arr);
		return arr;
	}
	

	public ProposedTaskBean getPropTaskByPropTaskId(int propTaskId) {
		ProposedTaskBean task = null;
		try {
			task = (ProposedTaskBean) ibatis.queryForObject("proposedTask.getPropTaskByPropTaskId", propTaskId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return task;
	}
	
	public List<ProposedTaskBean> getListPropTaskForSearchDialog(String col, String input) {
		
		Map m = new HashMap();
		m.put("searchValue", input);
		m.put("searchField", col);
		
		List<ProposedTaskBean> arr = new ArrayList<ProposedTaskBean>();

		try {
			arr = this.ibatis.queryForList("proposedTask.getPropTaskForSearchDialog", m);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	
	public Integer newPropTaskId() throws SQLException {
		
		Integer propTaskId = (Integer) ibatis.queryForObject("proposedTask.newPropTaskId", null);
		return propTaskId;
	}

	public void updateProposedTask(ProposedTaskBean bean) throws SQLException {
		
		Map m = new HashMap();
		m.put("propTaskName", bean.getPropTaskName());
		m.put("propTaskDesc", bean.getPropTaskDesc());
		m.put("estStartDateInString", bean.getEstStartDateInString());
		m.put("estEndDateInString", bean.getEstEndDateInString());
		m.put("propTaskId", bean.getPropTaskId());
		m.put("userId", bean.getUpdatedBy());
		
		try {
			ibatis.startTransaction();
			ibatis.update("proposedTask.updateProposedTask", m);
			ibatis.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
			ibatis.endTransaction();
		}
	}

	public void deleteProposedTask(int propTaskId,int userId)
			throws ClassNotFoundException,SQLException {
		
		
		Map m = new HashMap();
		m.put("propTaskId", propTaskId);
		m.put("userId", userId);
		
		try {			
			ibatis.startTransaction();
			ibatis.delete("proposedTask.deleteProposedTask", m);
			ibatis.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
			ibatis.endTransaction();
		}
	}

	public void insertProposedTask(ProposedTaskBean bean) {
		
		Map m = new HashMap();
		m.put("propTaskId", bean.getPropTaskId());
		m.put("propTaskName", bean.getPropTaskName());
		m.put("propTaskDesc", bean.getPropTaskDesc());
		m.put("estStartDateInString", bean.getEstStartDateInString());
		m.put("estEndDateInString", bean.getEstEndDateInString());
		m.put("propBy", bean.getPropBy());
		m.put("propTo", bean.getPropTo());
		m.put("createdBy", bean.getCreatedBy());
		m.put("updatedBy", bean.getUpdatedBy());
		m.put("createDateInString", bean.getCreateDateInString());
		m.put("updatedDateInString", bean.getUpdateDateInString());	
		m.put("userId", bean.getUpdatedBy());
		
		try {
			ibatis.startTransaction();
			bean.setPropTaskId(newPropTaskId());
			ibatis.insert("proposedTask.insertProposedTask", m);
			ibatis.commitTransaction();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Integer getCountProposedTask(String column, String value, int userId)
			throws SQLException, ClassNotFoundException {
		Map map = new HashMap();
		map.put("searchField", column);
		map.put("searchValue", value);
		map.put("userId", userId);

		Integer result = (Integer) this.ibatis.queryForObject(
				"proposedTask.countProposedTask", map);
		return result;
	}
}