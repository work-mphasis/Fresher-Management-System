package com.jaswant.fms.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.jaswant.fms.dto.FresherRequest;
import com.jaswant.fms.dto.FresherResponse;
import com.jaswant.fms.service.FresherService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FresherControllerTest {

    @Mock
    private FresherService fresherService;

    @InjectMocks
    private FresherController fresherController;

    @Test
    void testCreateFresher() {

        FresherRequest request = new FresherRequest();

        FresherResponse response = new FresherResponse();
        response.setName("Shaikumar");

        when(fresherService.createFresher(request))
                .thenReturn(response);

        FresherResponse result =
                fresherController.createFresher(request);

        assertEquals("Shaikumar",
                result.getName());
    }

    @Test
    void testGetAllFreshers() {

        List<FresherResponse> list =
                new ArrayList<>();

        FresherResponse response =
                new FresherResponse();

        response.setName("Shaikumar");

        list.add(response);

        when(fresherService.getAllFreshers())
                .thenReturn(list);

        List<FresherResponse> result =
                fresherController.getAllFreshers();

        assertEquals(1, result.size());
    }

    @Test
    void testGetFresherById() {

        FresherResponse response =
                new FresherResponse();

        response.setId(1L);
        response.setName("Shaikumar");

        when(fresherService.getFresherById(1L))
                .thenReturn(response);

        FresherResponse result =
                fresherController.getFresherById(1L);

        assertEquals(1L, result.getId());
    }

    @Test
    void testUpdateFresher() {

        FresherRequest request =
                new FresherRequest();

        FresherResponse response =
                new FresherResponse();

        response.setId(1L);
        response.setName("Updated User");

        when(fresherService.updateFresher(1L, request))
                .thenReturn(response);

        FresherResponse result =
                fresherController.updateFresher(
                        1L,
                        request);

        assertEquals(
                "Updated User",
                result.getName());
    }

    @Test
    void testDeleteFresher() {

        String result =
                fresherController.deleteFresher(1L);

        verify(fresherService)
                .deleteFresher(1L);

        assertEquals(
                "Fresher deleted successfully",
                result);
    }
}