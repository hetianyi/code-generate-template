/**
 * Copyright (c) 2022, Jason He. All rights reserved.
 */

package com.github.hetianyi.plugin.template.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.hetianyi.boot.ready.common.Convertible;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 示例表
 * 
 * <br><br>
 * This class is automatically generated by
 * <a href="https://github.com/hetianyi/code-generator-plugin">code-generator-plugin</a>.
 * 
 * @author Jason He
 */
@ApiModel(description = "示例表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExampleVO implements Convertible<ExampleVO> {

    /** 用户ID */
    @ApiModelProperty("用户ID")
    private String id;

    /** 用户名 */
    @ApiModelProperty("用户名")
    private String username;

    /** 昵称 */
    @ApiModelProperty("昵称")
    private String nickname;

    /** 创建时间 */
    @ApiModelProperty("创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    /** 修改时间 */
    @ApiModelProperty("修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;
}