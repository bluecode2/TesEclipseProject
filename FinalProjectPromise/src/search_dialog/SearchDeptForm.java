package search_dialog;

import org.apache.struts.action.ActionForm;

public class SearchDeptForm extends ActionForm {

	private String searchValue;
	private String searchField;
	
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	public String getSearchField() {
		return searchField;
	}
	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	
}
