package com.istidata.data_pribadi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.istidata.data_pribadi.model.Karyawan;
import com.istidata.data_pribadi.repository.KaryawanRepository;

@Service
public class KaryawanService {
      @Autowired
    private KaryawanRepository karyawanRepository;

    public List<Karyawan> getAllKaryawan() {
        return karyawanRepository.findAll();
    }

    public Karyawan saveKaryawan(Karyawan karyawan) {
        return karyawanRepository.save(karyawan);
    }

    public Karyawan getKaryawanById(Long nik) {
        return karyawanRepository.findById(nik).orElse(null);
    }

    public void deleteKaryawan(Long nik) {
        karyawanRepository.deleteById(nik);
    }
}
