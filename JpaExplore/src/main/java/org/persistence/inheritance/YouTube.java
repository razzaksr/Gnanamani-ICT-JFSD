package org.persistence.inheritance;

import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity
public class YouTube extends Google {
    private List<String> playList = new ArrayList<String>();

    public List<String> getPlayList() {
        return playList;
    }

    public void setPlayList(List<String> playList) {
        this.playList = playList;
    }
}
