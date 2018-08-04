package com.iem.safety.iembackend.expectenvir;

/**
 * @author MengQi 2018-06-20 20:11
 */
public class Part {
    private String name = "";
    private boolean checked = false;

    public Part() {
    }

    public Part(String name, boolean checked) {
        this.name = name;
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
