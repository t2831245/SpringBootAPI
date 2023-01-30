package com.demo.repository;

import com.demo.entity.Attendance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceDao extends CrudRepository<Attendance, Integer> {

}
