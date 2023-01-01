package hello.servlet.web.frontcontroller.v3recap.controller;

import hello.servlet.web.frontcontroller.ModelAndView;
import hello.servlet.web.frontcontroller.v3recap.ControllerRecap;

import java.util.Map;

public class MemberFormControllerRecap implements ControllerRecap {

    @Override
    public ModelAndView process(Map<String, String> paramMap) {
        return new ModelAndView("new-form");
    }
}
