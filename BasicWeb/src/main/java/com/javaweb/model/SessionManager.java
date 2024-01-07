package com.javaweb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.javaweb.model.UserModel;

public class SessionManager {
    public static void createSession(HttpServletRequest request, UserModel userModel) {
        HttpSession session = request.getSession();
        session.setAttribute("user", userModel);
    }

    public static void destroySession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }


}