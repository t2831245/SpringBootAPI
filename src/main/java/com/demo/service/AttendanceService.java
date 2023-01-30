package com.demo.service;

import com.demo.entity.Attendance;
import com.demo.repository.AttendanceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class AttendanceService {
    @Autowired
    AttendanceDao attendanceDao;

    public void coundDiff(){
        Optional<Attendance> a1 = attendanceDao.findById(1);
        System.out.println(ChronoUnit.HOURS.between(a1.get().getPunchOut(), a1.get().getPunchIn()));
    }
}
