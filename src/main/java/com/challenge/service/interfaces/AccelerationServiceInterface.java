package com.challenge.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.challenge.entity.Acceleration;

public interface AccelerationServiceInterface extends ServiceInterface<Acceleration> {

    Optional<Acceleration> findById(Long id);

    List<Acceleration> findByCompanyId(Long companyId);
   

}
