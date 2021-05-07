package com.ani.sso.ssodemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping
    public String dashboard(final Authentication authentication,final Model model) throws JsonProcessingException {

        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();

        System.out.println(authentication.getClass().getCanonicalName());
        model.addAttribute("bio", token.getPrincipal().getAttribute("bio"));
        model.addAttribute("login", token.getPrincipal().getAttribute("login"));
        model.addAttribute("avatar_url", token.getPrincipal().getAttribute("avatar_url"));
        return "dashboard";
    }
}
