package com.kob.backend.service.impl.utils;

import com.kob.backend.pojo.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @ClassName UserUtilImpl
 * @Description TODO
 * @Author Ultraman
 * @Date 2023/3/5 23:50
 * @Version 1.0
 */

public class UserUtilImpl {

    public static User getUser() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        return loginUser.getUser();
    }
}
