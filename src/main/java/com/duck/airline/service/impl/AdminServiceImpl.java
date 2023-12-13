//package com.duck.airline.service.impl;
//
//import com.duck.airline.model.Admin;
//import com.duck.airline.model.ERole;
//import com.duck.airline.repository.AdminRepository;
//import com.duck.airline.service.AdminService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AdminServiceImpl implements AdminService {
//    @Autowired
//    private AdminRepository adminRepository;
//
//    public Admin creatAdmin(String email, String password) {
//        Admin admin = new Admin();
//        admin.setEmail(email);
//        admin.setPassword(password);
//        admin.setRole(ERole.valueOf("ADMIN"));
//        return adminRepository.save(admin);
//    }
//}
