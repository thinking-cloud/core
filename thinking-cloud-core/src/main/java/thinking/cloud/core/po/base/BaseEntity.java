package thinking.cloud.core.po.base;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import thinking.cloud.core.entity.Entity;
import thinking.cloud.core.entity.Timestamp;
@Data
public abstract class BaseEntity<PK extends Serializable> implements Entity<PK>, Timestamp {
	private static final long serialVersionUID = -5208780711395858867L;
	
	private PK id;
	private Date createTime;
	private Date lastUpdateTime;
}