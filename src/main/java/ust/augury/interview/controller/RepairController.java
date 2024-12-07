package ust.augury.interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ust.augury.interview.entity.Repair;
import ust.augury.interview.service.RepairService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/repairs")
public class RepairController {

    private final RepairService repairService;

    @Autowired
    public RepairController(RepairService repairService) {
        this.repairService = repairService;
    }

    @GetMapping("/{repairId}")
    public ResponseEntity<Repair> getRepairDetailsById(@PathVariable String repairId) throws IOException {

        return ResponseEntity.ok(repairService.getRepairDetailsById(repairId));
    }

    @GetMapping("/machine/{machineId}")
    public ResponseEntity<List<Repair>> getRepairDetailsByMachineId(@PathVariable String machineId) throws IOException {

        return ResponseEntity.ok(repairService.getRepairDetailsByMachineId(machineId));
    }

    @GetMapping
    public ResponseEntity<List<Repair>> getAllRepairsDetails() throws IOException {

        return ResponseEntity.ok(repairService.getAllRepairsDetails());
    }
}
