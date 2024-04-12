package com.chanh.demo_jstl.service.impl;

import com.chanh.demo_jstl.model.CodeClass;
import com.chanh.demo_jstl.repository.IClassRepository;
import com.chanh.demo_jstl.repository.impl.ClassRepository;
import com.chanh.demo_jstl.service.IClassService;

import java.util.List;

public class ClassService implements IClassService {
     private IClassRepository classRepository = new ClassRepository();
    @Override
    public List<CodeClass> findAll() {
        return classRepository.findAll();
    }
}
