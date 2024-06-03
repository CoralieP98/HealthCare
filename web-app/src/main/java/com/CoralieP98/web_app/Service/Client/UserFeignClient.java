package com.CoralieP98.web_app.Service.Client;

import com.CoralieP98.web_app.Model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@FeignClient("patient")
public interface UserFeignClient {



}
