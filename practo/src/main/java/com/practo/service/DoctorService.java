package com.practo.service;

import com.practo.entity.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor addDoctor(Doctor doctor);
//    List<Doctor> getAllDoctors();
    List<Doctor> searchDoctorsByNameOrSpecialization(String search);
}
