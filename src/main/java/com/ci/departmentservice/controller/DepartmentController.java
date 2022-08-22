package com.ci.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ci.departmentservice.common.ApiResponse;
import com.ci.departmentservice.model.Department;
import com.ci.departmentservice.service.DepartmentService;


@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	DepartmentService deptService;

	@GetMapping("/home")
	// @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String home() {
		return "Welcome to Department Service";
	}

	@GetMapping("/department")
	// @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ApiResponse<?> getDepartments() {
		return deptService.getDepartments();
	}

	@GetMapping("/department/{id}")
	// @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ApiResponse<?> getDepartment(@PathVariable String id) {
		return deptService.getDepartment(Long.parseLong(id));
	}

	@PostMapping("/department")
	// @PreAuthorize("hasRole('ADMIN')")
	public ApiResponse<?> addDepartment(@RequestBody Department department) {
		return deptService.addDepartment(department);
	}

	/*
	 * @PostMapping("/departments") public ResponseEntity<?>
	 * addDepartments(@RequestBody List<Department> departmentList) { return
	 * deptService.addDepartments(departmentList); }
	 */

	@PutMapping("/department/{id}")
	// @PreAuthorize("hasRole('ADMIN')")
	public ApiResponse<?> updatedepartment(@PathVariable String id, @RequestBody Department department) {
		return deptService.updateDepartment(Long.parseLong(id), department);
	}

	@DeleteMapping("/department/{id}")
	// @PreAuthorize("hasRole('ADMIN')")
	public ApiResponse<?> deletedepartment(@PathVariable String id) {
		return deptService.deleteDepartment(Long.parseLong(id));
	}

	@DeleteMapping("/department")
	// @PreAuthorize("hasRole('ADMIN')")
	public ApiResponse<?> deleteAlldepartments() {
		return deptService.deleteAllDepartment();
	}

}
