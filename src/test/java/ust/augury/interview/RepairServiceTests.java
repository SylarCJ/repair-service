package ust.augury.interview;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import ust.augury.interview.entity.Repair;
import ust.augury.interview.exception.RepairDetailsNotFoundException;
import ust.augury.interview.service.impl.RepairServiceImpl;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepairServiceTests {

    private final RepairServiceImpl service;

    public RepairServiceTests() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        this.service = new RepairServiceImpl(mapper);
    }

    @Test
    void testGetAllRepairs() throws IOException {
        List<Repair> repairs = service.getAllRepairsDetails();

        assertNotNull(repairs);
        assertFalse(repairs.isEmpty());
        assertEquals("6731d639ab9cf66009b6a405", repairs.getFirst().getId());
    }

    @Test
    void testGetRepairById() throws IOException {
        Repair repair = service.getRepairDetailsById("6731d639ab9cf66009b6a405");

        assertNotNull(repair);
        assertEquals("6731d639ab9cf66009b6a405", repair.getId());
        assertEquals("We will relubricate bearing 4 today.", repair.getSummary());
    }

    @Test
    void testGetRepairByMachineId() throws IOException {
        List<Repair> result = service.getRepairDetailsByMachineId("5f54dd217546020001758b7b");

        // Assert
        assertNotNull(result);
        assertTrue(result.stream().allMatch(repair ->
                "5f54dd217546020001758b7b".equals(repair.getMachine().getId())));
    }

    @Test
    void testGetRepairByIdNotFound() {
        Exception exception = assertThrows(
                RepairDetailsNotFoundException.class,
                () -> service.getRepairDetailsById("nonexistent-id")
        );

        assertEquals("Repair Details not found for ID: nonexistent-id", exception.getMessage());
    }

    @Test
    void testGetRepairByMachineIdNotFound() {
        Exception exception = assertThrows(
                RepairDetailsNotFoundException.class,
                () -> service.getRepairDetailsByMachineId("nonexistent-id")
        );

        assertEquals("Repair Details not found for ID: nonexistent-id", exception.getMessage());
    }
}

