package org.efrei.start.dto;

import org.efrei.start.global.Category;

public class CreateMovie {

    private String title;
    private Category category;
    private String directorId; // Ajoutez ce champ

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

    public String getDirectorId() { // Ajoutez ce getter
        return this.directorId;
    }

    public void setDirectorId(String directorId) { // Ajoutez ce setter
        this.directorId = directorId;
    }
}

