package thinking.cloud.generator.file.impl;

import java.io.PrintStream;
import java.util.List;

import thinking.cloud.generator.bean.ColumnFieldMapping;
import thinking.cloud.generator.bean.TableClassMapping;
import thinking.cloud.generator.file.OutputJavaFile;
import thinking.cloud.generator.utils.PackageNameUtils;

/**
 * 生成java文件
 * @author zhouxinke
 * @date 2021年4月30日
 */
public class OutputEntity extends OutputJavaFile {

	public OutputEntity(String outputFilePath, List<TableClassMapping> tableClassMapping) {
		super(outputFilePath, tableClassMapping);
	}

	@Override
	public String getFileName(TableClassMapping table) {
		return table.getEntityName();
	}

	@Override
	protected String packageName()  {
		return PackageNameUtils.entityPackage();
		
	}

	@Override
	protected void outputAnnotation(TableClassMapping table, PrintStream ps) {
		ps.println("@Data");
		ps.println("@EqualsAndHashCode(callSuper = false)");
		ps.println("@NoArgsConstructor");
		
	}

	@Override
	protected void outputClassName(TableClassMapping table, PrintStream ps) {
		ps.println("public class "+table.getEntityName()+" extends BaseEntity<"+table.getPk().getFieldType()+",String> {");
		
	}

	@Override
	protected void outputClassFiled(TableClassMapping table, PrintStream ps) {
		String ignoreFieldNames="id,createUserId,createTime,lastUpdateUserId,lastUpdateTime,";
		for (ColumnFieldMapping col : table.getColFieldMappingList()) {	
			if(ignoreFieldNames.indexOf(col.getFieldName()+",")==-1) {
				ps.println(methodIndent+"private "+col.getFieldType()+" "+col.getFieldName()+";");
			}
		}
	}
	
	

	@Override
	protected void outputImport(TableClassMapping table, PrintStream ps) {
		super.outputImport(table, ps);
		ps.println("import lombok.Data;");
		ps.println("import lombok.EqualsAndHashCode;");
		ps.println("import lombok.NoArgsConstructor;");
		ps.println("import thinking.cloud.beans.entity.abs.BaseEntity;");
	}

	@Override
	protected void outputMethod(TableClassMapping table, PrintStream ps) {
		
	}
}
