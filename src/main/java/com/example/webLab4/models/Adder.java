package com.example.webLab4.models;

import javax.servlet.http.HttpServletRequest;

public interface Adder<T> {
    T add(HttpServletRequest request);
}
