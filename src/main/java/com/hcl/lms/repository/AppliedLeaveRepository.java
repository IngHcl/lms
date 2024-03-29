package com.hcl.lms.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.lms.entity.AppliedLeave;

@Repository

public interface AppliedLeaveRepository extends JpaRepository<AppliedLeave, Integer> {


	Optional<AppliedLeave> findByUserIdAndAppliedLeaveDate(Integer userId, LocalDate appliedLeaveDate);

	Optional<List<AppliedLeave>> findByAppliedLeaveDateBetween(LocalDate fromDate, LocalDate toDate);
@Query("select c from AppliedLeave c where c.userId=:userId and c.leaveTypeId=:leaveTypeId")
	List<AppliedLeave> findByuserIdAndLeaveTypeId(Integer userId, Integer leaveTypeId);

}
