package com.CoralieP98.Service.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@FeignClient("patient")
public interface PatientFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "signUp", consumes = "application/json")
    ModelAndView processRequest(@ModelAttribute("signUpForm") SignUpForm form);

}
