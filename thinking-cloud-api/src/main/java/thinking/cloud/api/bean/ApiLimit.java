package thinking.cloud.api.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import thinking.cloud.api.annotation.IgnoreSwaggerParameter;
import thinking.cloud.api.constant.ThreadLocalTables;
import thinking.cloud.beans.page.Limit;

/**
 * 分页查询条件
 * <p>分页查询条件</p> 
 * @author think
 */
public interface ApiLimit extends Limit { 
	
	/**
	 * 获取当前页码
	 * @return
	 */
	default Integer getPageNo() {
		Integer pageNo = ThreadLocalTables.THREADLOCAL_PAGENO.get();
		return pageNo == null || pageNo<=0 ? DEFAULT_PAGE_N0:pageNo;
	}

	/**
	 * 设置当前页码
	 * @param pageNo
	 */
	default void setPageNo(int pageNo) {
		ThreadLocalTables.THREADLOCAL_PAGENO.set(pageNo<=0 ? DEFAULT_PAGE_N0 : pageNo);
	}

	/**
	 * 获取每页显示的条数
	 * @return
	 */
	default Integer getPageSize() {
		Integer pageSize = ThreadLocalTables.THREADLOCAL_PAGESIZE.get();
		return pageSize == null || pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
	}

	/**
	 * 设置每页显示的条数
	 * @param pageSize
	 */
	default void setPageSize(int pageSize) {
		ThreadLocalTables.THREADLOCAL_PAGESIZE.set(pageSize <= 0? DEFAULT_PAGE_SIZE : pageSize);
	}
	
	default void setTotalRecord(long total) {
		ThreadLocalTables.THREADLOCAL_TOTALRECORD.set(total);
	}
	
	@IgnoreSwaggerParameter
	@JsonIgnore
	@ApiModelProperty(value="总条数",example = "0")
	default Long getTotalRecord() {
		return ThreadLocalTables.THREADLOCAL_TOTALRECORD.get();
	}

	/**
	 * 获取数据起始索引
	 * @return
	 */
	@IgnoreSwaggerParameter
	@JsonIgnore
	@ApiModelProperty(value="起始索引",example = "0")
	default int getStartIndex(){
		return (getPageNo() - 1) * getPageSize();
	}	
}