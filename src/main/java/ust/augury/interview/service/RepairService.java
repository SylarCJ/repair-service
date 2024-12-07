package ust.augury.interview.service;

import ust.augury.interview.entity.Repair;

import java.io.IOException;
import java.util.List;

public interface RepairService {
    Repair getRepairDetailsById(String repairId) throws IOException;

    List<Repair> getRepairDetailsByMachineId(String machineId) throws IOException;

    List<Repair> getAllRepairsDetails() throws IOException;
}
