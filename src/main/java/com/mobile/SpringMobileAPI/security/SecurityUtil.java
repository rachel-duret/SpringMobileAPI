package com.mobile.SpringMobileAPI.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static String getloggedUserEmail(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)){
            String loggedUserEmail = authentication.getName();
            return loggedUserEmail;
        }
        return null;
    }
}
