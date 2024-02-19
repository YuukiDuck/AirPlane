package com.duck.airline.service.impl;

import com.duck.airline.dto.MayBayDto;
import com.duck.airline.exception.NotFoundException;
import com.duck.airline.model.LoaiMayBay;
import com.duck.airline.model.MayBay;
import com.duck.airline.repository.LoaiMayBayRepository;
import com.duck.airline.repository.MayBayRepository;
import com.duck.airline.service.MayBayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MayBayServiceImpl implements MayBayService {
    private final MayBayRepository mayBayRepository;
    private final MayBayDto mayBayDto;
    private final LoaiMayBayRepository loaiMayBayRepository;

    @Override
    public List<MayBay> getAllMayBay() {
        return mayBayRepository.findAll();
    }

    @Override
    public Optional<MayBay> getMayBayById(Long soHieu) {
        return mayBayRepository.findById(soHieu);
    }

    @Override
    public MayBay createMayBay(MayBayDto mayBayDTO) {
        LoaiMayBay loaiMayBay = loaiMayBayRepository.findById(mayBayDTO.getIdLoaiMayBay())
                .orElseThrow(() -> new NotFoundException("Không tìm thấy loại máy bay"));

        MayBay mayBay = new MayBay();
        mayBay.setSoHieu(mayBayDTO.getSoHieu());
        mayBay.setLoaiMayBay(loaiMayBay);

        return mayBayRepository.save(mayBay);
    }

    @Override
    public MayBay updateMayBay(MayBay mayBay) {
        return mayBayRepository.save(mayBay);
    }

    @Override
    public void deleteMayBayById(Long soHieu) {
        mayBayRepository.deleteById(soHieu);
    }
}
