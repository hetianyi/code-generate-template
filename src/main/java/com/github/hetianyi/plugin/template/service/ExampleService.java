// #MvcTemplate#
package com.github.hetianyi.plugin.template.service;

import com.github.hetianyi.boot.ready.model.http.Page;
import com.github.hetianyi.plugin.template.model.form.CreateExampleForm;
import com.github.hetianyi.plugin.template.model.form.QueryExampleForm;
import com.github.hetianyi.plugin.template.model.form.UpdateExampleForm;
import com.github.hetianyi.plugin.template.model.vo.ExampleVO;

/**
 * 示例服务
 *
 * @author Jason He
 */
public interface ExampleService {

    /**
     * 新增示例
     *
     * @param form 新增示例请求表单
     *
     * @return 新增示例的ID
     */
    String insert(CreateExampleForm form);

    /**
     * 更新示例信息
     *
     * @param form 更新示例信息请求表单
     */
    void update(UpdateExampleForm form);

    /**
     * 删除示例
     *
     * @param exampleId 示例ID
     */
    void delete(Long exampleId);

    /**
     * 根据ID获取示例信息详情
     *
     * @param exampleId 示例ID
     *
     * @return 示例信息
     */
    ExampleVO getById(String exampleId);

    /**
     * 分页查询示例信息
     *
     * @param form 分页查询参数
     *
     * @return 示例信息分页数据
     */
    Page<ExampleVO> list(QueryExampleForm form);
}
