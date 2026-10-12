package com.jaswant.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jaswant.fms.dto.FresherRequest;
import com.jaswant.fms.dto.FresherResponse;
import com.jaswant.fms.service.FresherService;

@RestController
@RequestMapping("/api/freshers")
@CrossOrigin(origins = "*")
public class FresherController {

    @Autowired
    private FresherService fresherService;

    @PostMapping
    public FresherResponse createFresher(
            @RequestBody FresherRequest request) {

        return fresherService.createFresher(request);
    }

    @GetMapping
    public List<FresherResponse> getAllFreshers() {

        return fresherService.getAllFreshers();
    }

    @GetMapping("/{id}")
    public FresherResponse getFresherById(
            @PathVariable Long id) {

        return fresherService.getFresherById(id);
    }

    @PutMapping("/{id}")
    public FresherResponse updateFresher(
            @PathVariable Long id,
            @RequestBody FresherRequest request) {

        return fresherService.updateFresher(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteFresher(
            @PathVariable Long id) {

        fresherService.deleteFresher(id);

        return "Fresher deleted successfully";
    }
}