package com.duck.airline.security.service;

import com.duck.airline.model.KhachHang;
import com.duck.airline.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        KhachHang khachHang = khachHangRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy khách hàng với email: " + email));

        return UserDetailsImpl.build(khachHang);
    }
}
