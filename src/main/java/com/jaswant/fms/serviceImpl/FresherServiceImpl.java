package com.jaswant.fms.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaswant.fms.dto.FresherRequest;
import com.jaswant.fms.dto.FresherResponse;
import com.jaswant.fms.entity.Fresher;
import com.jaswant.fms.exception.ResourceNotFoundException;
import com.jaswant.fms.repository.FresherRepository;
import com.jaswant.fms.service.FresherService;
import com.jaswant.fms.util.Constants;

@Service
public class FresherServiceImpl
        implements FresherService {

    @Autowired
    private FresherRepository fresherRepository;

    @Override
    public FresherResponse createFresher(
            FresherRequest request) {

        Fresher fresher = new Fresher();

        fresher.setEmployeeId(
                request.getEmployeeId());

        fresher.setName(
                request.getName());

        fresher.setEmail(
                request.getEmail());

        fresher.setPhone(
                request.getPhone());

        fresher.setTechnology(
                request.getTechnology());

        fresher.setJoiningDate(
                request.getJoiningDate());

        fresher.setStatus(
                request.getStatus());

        Fresher saved =
                fresherRepository.save(
                        fresher);

        return convertToResponse(
                saved);
    }

    @Override
    public List<FresherResponse>
            getAllFreshers() {

        return fresherRepository
                .findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FresherResponse
            getFresherById(Long id) {

        Fresher fresher =
                fresherRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        Constants.FRESHER_NOT_FOUND
                                                + id));

        return convertToResponse(
                fresher);
    }

    @Override
    public FresherResponse
            updateFresher(
                    Long id,
                    FresherRequest request) {

        Fresher fresher =
                fresherRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        Constants.FRESHER_NOT_FOUND
                                                + id));

        fresher.setEmployeeId(
                request.getEmployeeId());

        fresher.setName(
                request.getName());

        fresher.setEmail(
                request.getEmail());

        fresher.setPhone(
                request.getPhone());

        fresher.setTechnology(
                request.getTechnology());

        fresher.setJoiningDate(
                request.getJoiningDate());

        fresher.setStatus(
                request.getStatus());

        Fresher updated =
                fresherRepository.save(
                        fresher);

        return convertToResponse(
                updated);
    }

    @Override
    public void deleteFresher(
            Long id) {

        Fresher fresher =
                fresherRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        Constants.FRESHER_NOT_FOUND
                                                + id));

        fresherRepository.delete(
                fresher);
    }

    private FresherResponse convertToResponse(Fresher fresher) {

        FresherResponse response = new FresherResponse();

        response.setId(fresher.getId());
        response.setEmployeeId(fresher.getEmployeeId());
        response.setName(fresher.getName());
        response.setEmail(fresher.getEmail());
        response.setPhone(fresher.getPhone());
        response.setTechnology(fresher.getTechnology());
        response.setJoiningDate(fresher.getJoiningDate());
        response.setStatus(fresher.getStatus());

        return response;
    }}