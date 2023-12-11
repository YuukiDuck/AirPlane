package com.duck.airline.service;

import com.duck.airline.model.KhaNang;

import java.util.List;
import java.util.Optional;

public interface KhaNangService {
    List<KhaNang> getAllKhaNang();

    Optional<KhaNang> getKhaNangById(Long id);

    KhaNang createKhaNang(KhaNang khaNang);

    KhaNang updateKhaNang(KhaNang khaNang);

    void deleteKhaNangById(Long id);
}
