package com.ci.departmentservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci.departmentservice.common.ApiResponse;
import com.ci.departmentservice.model.Department;
import com.ci.departmentservice.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository deptRepository;

	// ResponseEntity<?>
	public ApiResponse<?> getDepartments() {

		try {
			List<Department> deptList = deptRepository.findAll();
			if (deptList.isEmpty()) {
				// return new ResponseEntity<>("Record Not Found!", HttpStatus.NOT_FOUND);
				return new ApiResponse<>("failed", "Record Not Found!", null);
			}
			// return new ResponseEntity<>(deptList, HttpStatus.OK);
			return new ApiResponse<>("success", "Record Fetched.", deptList);
		} catch (Exception e) {
			// return new ResponseEntity<>("Server Error!",
			// HttpStatus.INTERNAL_SERVER_ERROR);
			return new ApiResponse<>("failed", "Server Error!", null);
		}
	}

	public ApiResponse<?> getDepartment(Long id) {
		try {
			Department existingDepartment = deptRepository.findByDeptId(id);
			if (existingDepartment != null) {
				return new ApiResponse<>("success", "Fetching Record.", existingDepartment);
			} else {
				return new ApiResponse<>("failed", "Record Not Found!", null);
			}
		} catch (Exception e) {
			return new ApiResponse<>("failed", "Server Error!", null);
		}
	}

	public ApiResponse<?> addDepartment(Department department) {
		try {
			Department _department = deptRepository.save(department);
			return new ApiResponse<>("success", "Record saved succssfully.", _department);
		} catch (Exception e) {
			return new ApiResponse<>("failed", "Server Error!", null);
		}
	}

	/*
	 * public ResponseEntity<?> addDepartments(List<Department> departmentList) {
	 * try { List<Department> _departmentList =
	 * deptRepository.saveAll(departmentList); return new
	 * ResponseEntity<>(_departmentList, HttpStatus.CREATED); } catch (Exception e)
	 * { return new ResponseEntity<>("Server Error!",
	 * HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */

	public ApiResponse<?> updateDepartment(Long id, Department department) {
		try {
			Department existingDepartment = deptRepository.findByDeptId(id);
			if (existingDepartment != null) {
				Department _department = existingDepartment;
				_department.setDeptName(department.getDeptName());
				_department.setDeptAddress(department.getDeptAddress());
				deptRepository.save(_department);
				return new ApiResponse<>("success", "Record Updated Successfully.", _department);
			} else {
				return new ApiResponse<>("failed", "Record Not Found!", null);
			}
		} catch (Exception e) {
			return new ApiResponse<>("failed", "Server Error!", null);
		}
	}

	public ApiResponse<?> deleteDepartment(Long id) {
		try {
			Optional<Department> department = deptRepository.findById(id);
			if (department.isPresent()) {
				deptRepository.delete(department.get());
				return new ApiResponse<>("success", "Record Deleted Successfully.", null);
			} else {
				return new ApiResponse<>("failed", "Record Not Found!", null);
			}
		} catch (Exception e) {
			return new ApiResponse<>("failed", "Server Error!", null);
		}
	}

	public ApiResponse<?> deleteAllDepartment() {
		try {
			deptRepository.deleteAll();
			return new ApiResponse<>("success", "All Records Deleted Successfully!", null);
		} catch (Exception e) {
			return new ApiResponse<>("failed", "Server Error!", null);
		}
	}
}
