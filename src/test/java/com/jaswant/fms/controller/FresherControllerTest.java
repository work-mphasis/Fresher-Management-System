package com.jaswant.fms.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;

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
    void testGetAllFreshers() {

        List<FresherResponse> responses =
                new ArrayList<>();

        when(fresherService.getAllFreshers())
                .thenReturn(responses);

        assertEquals(responses,
                fresherController.getAllFreshers());
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