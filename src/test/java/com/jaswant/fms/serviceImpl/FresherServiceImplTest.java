package com.jaswant.fms.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import com.jaswant.fms.repository.FresherRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FresherServiceImplTest {

    @Mock
    private FresherRepository fresherRepository;

    @InjectMocks
    private FresherServiceImpl fresherServiceImpl;

    @Test
    void testGetAllFreshers() {

        when(fresherRepository.findAll())
                .thenReturn(new ArrayList<>());

        assertEquals(
                0,
                fresherServiceImpl
                        .getAllFreshers()
                        .size());
    }
}