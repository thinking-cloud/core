
package thinking.cloud.core.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import thinking.cloud.core.entity.Entity;
import thinking.cloud.core.vo.VO;

/**
 * 
 * Entity对象转VO对象的转换类
 * <p>Entity对象转VO对象的转换类</p> 
 * @author think
 * @param <T> 源类型
 * @param <V> VO类型
 */
public class EntityToVoConvert<T extends Entity<?>,V extends VO<T>> implements Converter<T, V> {
	
	private Class<V> voClass;
	public EntityToVoConvert(Class<V> voClass) {
		this.voClass = voClass;
	}
	
	/**
	 * sourceList 转为 VO的list
	 * @param sourceList 对象模型的集合
	 * @return VO对象的集合
	 */
	public List<V> convert(List<T> sourceList){
		List<V> voList = new ArrayList<>();
		if(sourceList != null && !sourceList.isEmpty()) {
			for (T source : sourceList) {
				V vo = convert(source);
				voList.add(vo);
			}	
		}
		return voList;
	}
	
	/**
	 * source 转为 VO对象
	 */
	public V convert(T source) {
		try {
			return voClass.newInstance().convert(source);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
