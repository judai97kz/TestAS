package com.judai.asif;

import android.graphics.Bitmap;

public class Skills {
    private String skill;
    private Bitmap imgsk;

    public Skills(String skill, Bitmap imgsk) {
        this.skill = skill;
        this.imgsk = imgsk;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Bitmap getImgsk() {
        return imgsk;
    }

    public void setImgsk(Bitmap imgsk) {
        this.imgsk = imgsk;
    }
}
