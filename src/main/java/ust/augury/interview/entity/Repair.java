package ust.augury.interview.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Repair {

    private String id;

    private String userId;

    private String componentId;

    @JsonProperty("repair")
    private String repairType;

    private String text;

    private String summary;

    @JsonProperty("createdAt")
    private Date createdAt;

    @JsonProperty("updatedAt")
    private Date updatedAt;

    @JsonProperty("repairDate")
    private Date repairDate;

    @JsonProperty("initialRepairDate")
    private Date initialRepairDate;

    private RepairWorkflowStatus repairWorkflowStatus;

    private Machine machine;

    private Reason reason;

    private User user;

    private String reviewStatus;

    @JsonProperty("workorderId")
    private String workOrderId;

    private FixAreaDetails fixAreaDetails;

}

