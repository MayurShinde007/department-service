package com.ci.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ci.departmentservice.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	Department findByDeptId(Long deptId);
}
