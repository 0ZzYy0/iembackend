package com.iem.safety.iembackend.detailpartinfo;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * 细部震损建筑物细节部分信息
 *
 * @author MengQi 2018-06-20 21:41
 */
public class DetailPartInfo {
    @Id
    private String id;

    private String assessId;

    private String customerId;

    private String structureTypeId;//类型id
    private String partTypeName;
    private String structurePartId;
    private String intuitJudgement;//判断结果
    private boolean intuited;//是否直观
    private boolean damaged;
    private List<Damage> damages;

    public DetailPartInfo(String id, String assessId, String customerId, String structureTypeId, String partTypeName, String structurePartId, String intuitJudgement, boolean intuited, boolean damaged, List<Damage> damages) {
        this.id = id;
        this.assessId = assessId;
        this.customerId = customerId;
        this.structureTypeId = structureTypeId;
        this.partTypeName = partTypeName;
        this.structurePartId = structurePartId;
        this.intuitJudgement = intuitJudgement;
        this.intuited = intuited;
        this.damaged = damaged;
        this.damages = damages;
    }

    public DetailPartInfo(String id, String assessId, String customerId, String structureTypeId, String intuitJudgement, boolean intuited, boolean damaged, List<Damage> damages) {
        this.id = id;
        this.assessId = assessId;
        this.customerId = customerId;
        this.structureTypeId = structureTypeId;
        this.intuitJudgement = intuitJudgement;
        this.intuited = intuited;
        this.damaged = damaged;
        this.damages = damages;
    }

    public DetailPartInfo() {
    }

    public String getPartTypeName() {
        return partTypeName;
    }

    public void setPartTypeName(String partTypeName) {
        this.partTypeName = partTypeName;
    }

    public String getStructurePartId() {
        return structurePartId;
    }

    public void setStructurePartId(String structurePartId) {
        this.structurePartId = structurePartId;
    }

    public String getStructureTypeId() {
        return structureTypeId;
    }

    public void setStructureTypeId(String structureTypeId) {
        this.structureTypeId = structureTypeId;
    }

    public String getIntuitJudgement() {
        return intuitJudgement;
    }

    public void setIntuitJudgement(String intuitJudgement) {
        this.intuitJudgement = intuitJudgement;
    }

    public boolean isIntuited() {
        return intuited;
    }

    public void setIntuited(boolean intuited) {
        this.intuited = intuited;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAssessId() {
        return assessId;
    }

    public void setAssessId(String assessId) {
        this.assessId = assessId;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDamaged() {
        return damaged;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }

    public List<Damage> getDamages() {
        return damages;
    }

    public void setDamages(List<Damage> damages) {
        this.damages = damages;
    }
}
