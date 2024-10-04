package org.efrei.start.dto;

import org.efrei.start.global.Category;

public class CreateMovie {

    private String title;
    private Category category;
    private String directorId;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDirectorId() {
        return this.directorId;
    }

    public void setDirectorId(String directorId) {
        this.directorId = directorId;
    }
}

