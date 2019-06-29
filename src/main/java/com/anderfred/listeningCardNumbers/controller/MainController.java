package com.anderfred.listeningCardNumbers.controller;

import com.anderfred.listeningCardNumbers.repostitory.AudioFile;
import com.anderfred.listeningCardNumbers.repostitory.AudioFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/")
public class MainController {
    private AudioFileRepository audioFileRepository;

    @Autowired
    public MainController(AudioFileRepository audioFileRepository) {
        this.audioFileRepository = audioFileRepository;

    }

    @GetMapping(path="/getAllFiles")
    public @ResponseBody
    Iterable<AudioFile> getAllUsers() {
        // This returns a JSON or XML with the users
        return audioFileRepository.findAll();
    }
}
