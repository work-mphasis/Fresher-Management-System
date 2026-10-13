package com.jaswant.fms.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import com.jaswant.fms.dto.FresherRequest;
import com.jaswant.fms.dto.FresherResponse;
import com.jaswant.fms.entity.Fresher;
import com.jaswant.fms.exception.ResourceNotFoundException;
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
    void testCreateFresher() {

        FresherRequest request = new FresherRequest(
                "EMP001",
                "Shaikumar",
                "shaikumar@gmail.com",
                "9876543210",
                "Java",
                LocalDate.now(),
                "ACTIVE");

        Fresher fresher = new Fresher(
                1L,
                "EMP001",
                "Shaikumar",
                "shaikumar@gmail.com",
                "9876543210",
                "Java",
                LocalDate.now(),
                "ACTIVE");

        when(fresherRepository.save(any(Fresher.class)))
                .thenReturn(fresher);

        FresherResponse response =
                fresherServiceImpl.createFresher(request);

        assertEquals("EMP001",
                response.getEmployeeId());

        assertEquals("Shaikumar",
                response.getName());
    }

    @Test
    void testGetAllFreshers() {

        Fresher fresher = new Fresher(
                1L,
                "EMP001",
                "Shaikumar",
                "shaikumar@gmail.com",
                "9876543210",
                "Java",
                LocalDate.now(),
                "ACTIVE");

        when(fresherRepository.findAll())
                .thenReturn(Arrays.asList(fresher));

        assertEquals(
                1,
                fresherServiceImpl.getAllFreshers().size());
    }

    @Test
    void testGetFresherById() {

        Fresher fresher = new Fresher(
                1L,
                "EMP001",
                "Shaikumar",
                "mail@gmail.com",
                "9876543210",
                "Java",
                LocalDate.now(),
                "ACTIVE");

        when(fresherRepository.findById(1L))
                .thenReturn(Optional.of(fresher));

        FresherResponse result =
                fresherServiceImpl.getFresherById(1L);

        assertEquals(
                "Shaikumar",
                result.getName());
    }

    @Test
    void testGetFresherByIdNotFound() {

        when(fresherRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> fresherServiceImpl.getFresherById(1L));
    }

    @Test
    void testUpdateFresher() {

        FresherRequest request = new FresherRequest(
                "EMP001",
                "Updated User",
                "updated@gmail.com",
                "9999999999",
                "Spring",
                LocalDate.now(),
                "ACTIVE");

        Fresher fresher =
                new Fresher();

        fresher.setId(1L);

        when(fresherRepository.findById(1L))
                .thenReturn(Optional.of(fresher));

        when(fresherRepository.save(any(Fresher.class)))
                .thenAnswer(i -> i.getArgument(0));

        FresherResponse response =
                fresherServiceImpl.updateFresher(
                        1L,
                        request);

        assertEquals(
                "Updated User",
                response.getName());
    }

    @Test
    void testDeleteFresher() {

        Fresher fresher =
                new Fresher();

        fresher.setId(1L);

        when(fresherRepository.findById(1L))
                .thenReturn(Optional.of(fresher));

        fresherServiceImpl.deleteFresher(1L);

        verify(fresherRepository)
                .delete(fresher);
    }

    @Test
    void testDeleteFresherNotFound() {

        when(fresherRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> fresherServiceImpl.deleteFresher(1L));
    }
}