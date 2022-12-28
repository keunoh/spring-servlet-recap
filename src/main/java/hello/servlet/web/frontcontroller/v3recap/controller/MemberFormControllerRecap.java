package hello.servlet.web.frontcontroller.v3recap.controller;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3recap.ControllerRecap;

import java.util.Map;

public class MemberFormControllerRecap implements ControllerRecap {

    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form");
    }
}
