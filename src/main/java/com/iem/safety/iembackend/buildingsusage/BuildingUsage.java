package com.iem.safety.iembackend.buildingsusage;

import org.springframework.data.annotation.Id;

/**
 * @author MengQi 2018-05-22 19:33
 */
@SuppressWarnings(value = "unused")
public class BuildingUsage {
    @Id
    private String id;

    private String usage;

    public BuildingUsage() {
    }

    public BuildingUsage(String id, String usage) {
        this.id = id;
        this.usage = usage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }
}
