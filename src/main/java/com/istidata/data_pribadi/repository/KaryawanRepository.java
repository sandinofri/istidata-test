package com.istidata.data_pribadi.repository;

import com.istidata.data_pribadi.model.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KaryawanRepository extends JpaRepository<Karyawan, Long> {
    
}
