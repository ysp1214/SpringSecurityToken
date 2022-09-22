package com.ysp.expression;

import com.ysp.domain.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @version 1.0
 * @auther杨甜
 */
@Component
public class YspExpression {
    public Boolean hasAuthority(String authority){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser principal = (LoginUser)authentication.getPrincipal();
        List<String> permissions = principal.getPermissions();
       return permissions.contains(authority);
    }

}
