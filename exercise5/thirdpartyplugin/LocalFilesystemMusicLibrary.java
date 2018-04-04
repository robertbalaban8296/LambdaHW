package com.ibm.streams.tutorial.exercise5.thirdpartyplugin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import com.ibm.streams.tutorial.exercise5.musicplayer.MusicLibrary;
import com.ibm.streams.tutorial.exercise5.musicplayer.Song;

public class LocalFilesystemMusicLibrary implements MusicLibrary {


    private final Set<Song> allSongs;

    public LocalFilesystemMusicLibrary(Song... allSongs) {
        this.allSongs = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(allSongs)));
    }

    @Override
    public Collection<Song> allSongs() {
        return SongByArtistSorter.sort(allSongs());
    }

    @Override
    public int timesPlayed(Song song) {
        // Could read a local database file to find the number of times played
        return 4;
    }
}
