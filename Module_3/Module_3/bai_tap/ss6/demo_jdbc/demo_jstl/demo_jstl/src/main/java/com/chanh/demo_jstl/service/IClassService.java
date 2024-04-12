package com.chanh.demo_jstl.service;

import com.chanh.demo_jstl.dto.StudentDto;
import com.chanh.demo_jstl.model.CodeClass;

import java.util.List;

public interface IClassService {
    List<CodeClass> findAll();
}
