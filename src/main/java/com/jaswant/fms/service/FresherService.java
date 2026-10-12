package com.jaswant.fms.service;

import java.util.List;

import com.jaswant.fms.dto.FresherRequest;
import com.jaswant.fms.dto.FresherResponse;

public interface FresherService {

    FresherResponse createFresher(
            FresherRequest request);

    List<FresherResponse> getAllFreshers();

    FresherResponse getFresherById(
            Long id);

    FresherResponse updateFresher(
            Long id,
            FresherRequest request);

    void deleteFresher(
            Long id);
}