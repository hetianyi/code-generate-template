// #MvcTemplate#
package com.github.hetianyi.plugin.template.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.hetianyi.plugin.template.model.form.QueryExampleForm;
import com.github.hetianyi.plugin.template.model.po.ExamplePO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 示例Mapper
 *
 * @author Jason He
 */
@Mapper
public interface ExampleMapper extends BaseMapper<ExamplePO> {
    Integer countExamples(QueryExampleForm form);
    List<ExamplePO> listExamples(QueryExampleForm form);
}
