package ust.augury.interview.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import ust.augury.interview.entity.Repair;
import ust.augury.interview.exception.RepairDetailsNotFoundException;
import ust.augury.interview.service.RepairService;

import java.io.IOException;
import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {
    private final ObjectMapper mapper;

    @Autowired
    public RepairServiceImpl(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Repair> getAllRepairsDetails() throws IOException {
        // Deserialize the JSON file into a list of Machine objects
        return mapper.readValue(
                new ClassPathResource("repairs.json").getInputStream(),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public Repair getRepairDetailsById(String repairId) throws IOException {
        List<Repair> repairs = getAllRepairsDetails();

        // Find the repair details with the specified ID
        return repairs.stream()
                .filter(repairDetails -> repairDetails.getId().equals(repairId))
                .findFirst()
                .orElseThrow(() -> new RepairDetailsNotFoundException(repairId));
    }

    @Override
    public List<Repair> getRepairDetailsByMachineId(String machineId) throws IOException {
        List<Repair> repairs = getAllRepairsDetails();

        // Filter repairs by machine ID and collect them into a list
        List<Repair> repairList = repairs.stream()
                .filter(repairDetails -> repairDetails.getMachine() != null &&
                        machineId.equals(repairDetails.getMachine().getId()))
                .toList();

        if (repairList.isEmpty()) {
            throw new RepairDetailsNotFoundException(machineId);
        }

        return repairList;
    }
}
