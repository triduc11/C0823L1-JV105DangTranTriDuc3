package com.chanh.demo_jstl.repository;

import com.chanh.demo_jstl.model.CodeClass;

import java.util.List;

public interface IClassRepository {
    List<CodeClass> findAll();
}
