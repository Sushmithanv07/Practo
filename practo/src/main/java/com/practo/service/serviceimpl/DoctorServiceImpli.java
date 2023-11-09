package com.practo.service.serviceimpl;

import com.practo.entity.Doctor;
import com.practo.repository.DoctorRepository;
import com.practo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpli implements DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpli(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
//    @Override
//    public List<Doctor> getAllDoctors() {
//        return doctorRepository.findAll();
//    }

    @Override
    public List<Doctor> searchDoctorsByNameOrSpecialization(String search) {
        return doctorRepository.findByByNameOrSpecialization(search);
    }

    }

