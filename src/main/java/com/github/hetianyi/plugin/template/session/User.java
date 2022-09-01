package com.github.hetianyi.plugin.template.session;

import java.security.Principal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.hetianyi.boot.ready.common.Convertible;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 会话用户
 *
 * @author Jason He
 * @version 1.0.0
 * @date 2022/04/04 21:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Convertible<User> {

    /** 用户userId */
    private String userId;

    /** 用户username */
    private String username;

    /** 头像 */
    private String avatar;

    /** 账户是否被锁定 */
    private boolean locked;

    private String token;


    /** 账户注册时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerTime;

    /** 登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date loginTime;

    /** 登录过期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expireTime;

    /**
     * 从Principal中解析得到User对象
     *
     * @param principal
     */
    public static final User from(Principal principal) {
        if (null == principal) {
            return null;
        }
        /*if (principal instanceof UsernamePasswordAuthenticationToken) {
            return (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        }*/
        return null;
    }
}
