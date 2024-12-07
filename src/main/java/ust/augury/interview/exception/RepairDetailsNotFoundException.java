package ust.augury.interview.exception;

public class RepairDetailsNotFoundException extends RuntimeException {
    public RepairDetailsNotFoundException(String repairId) {
        super("Repair Details not found for ID: " + repairId);
    }
}
