// #MvcTemplate#
package com.github.hetianyi.plugin.template.controller;

import java.util.Objects;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.github.hetianyi.boot.ready.model.http.Page;
import com.github.hetianyi.boot.ready.model.http.Result;
import com.github.hetianyi.plugin.template.model.form.CreateExampleForm;
import com.github.hetianyi.plugin.template.model.form.QueryExampleForm;
import com.github.hetianyi.plugin.template.model.form.UpdateExampleForm;
import com.github.hetianyi.plugin.template.model.vo.ExampleVO;
import com.github.hetianyi.plugin.template.service.ExampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 示例增删改查接口
 *
 * @author Jason He
 */
@Slf4j
@RestController
@Api(tags = "示例增删改查接口")
@RequestMapping("/api/examples")
@Validated
public class ExampleController implements BaseController {

    @Resource
    private ExampleService exampleService;

    /**
     * 新增示例
     */
    @ApiOperation("新增示例")
    @PostMapping
    public Result<String> insertExample(
            @RequestBody @Validated CreateExampleForm form,
            BindingResult bindingResult
    ) {
        validateFields(bindingResult);
        return Result.success(exampleService.insert(form));
    }

    /**
     * 更新示例信息
     */
    @ApiOperation("更新示例信息")
    @PutMapping("/{exampleId}")
    public Result updateExample(
            @PathVariable String exampleId,
            @RequestBody @Validated UpdateExampleForm form,
            BindingResult bindingResult
    ) {
        form.setId(exampleId);
        validateFields(bindingResult);

        exampleService.update(form);
        return Result.success();
    }

    /**
     * 删除示例
     */
    @ApiOperation("删除示例")
    @DeleteMapping("/{exampleId}")
    public Result deleteExample(@PathVariable String exampleId) {
        exampleService.delete(Long.valueOf(exampleId));
        return Result.success();
    }

    /**
     * 获取示例详情
     */
    @ApiOperation("获取示例详情")
    @GetMapping("/{exampleId}")
    public Result<ExampleVO> getExampleById(@PathVariable String exampleId) {
        return Result.success(exampleService.getById(exampleId));
    }

    /**
     * 分页查询示例信息
     */
    @ApiOperation("分页查询示例信息")
    @GetMapping
    public Result<Page<ExampleVO>> listExamples(QueryExampleForm form) {

        if (null == form) {
            form = new QueryExampleForm();
            form.setDescending(true);
        }
        if (Objects.isNull(form.getPage()) || form.getPage() <= 0) {
            form.setPage(1);
        }
        if (Objects.isNull(form.getPageSize()) || form.getPageSize() <= 0) {
            form.setPageSize(20);
        }

        return Result.success(exampleService.list(form));
    }
}
