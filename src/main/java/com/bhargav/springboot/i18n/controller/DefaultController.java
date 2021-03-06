package com.bhargav.springboot.i18n.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;
import java.util.Map;

@Controller
public class DefaultController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/")
    public ModelAndView getIndex(
            Map<String, Object> model, Locale locale) {
        model.put("greetMessage", messageSource.getMessage("welcomeText", null, locale));
        model.put("languageSupported", messageSource.getMessage("languageSupport", null, locale));
        return new ModelAndView("index", model);
    }

}
