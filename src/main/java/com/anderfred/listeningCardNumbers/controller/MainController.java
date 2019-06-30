package com.anderfred.listeningCardNumbers.controller;

import com.anderfred.listeningCardNumbers.aop.LogAOP;
import com.anderfred.listeningCardNumbers.repostitory.AudioFile;
import com.anderfred.listeningCardNumbers.repostitory.AudioFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
@RequestMapping(path = "/")
public class MainController {
    private AudioFileRepository audioFileRepository;

    @Autowired
    public MainController(AudioFileRepository audioFileRepository) {
        this.audioFileRepository = audioFileRepository;

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/Files")
    @LogAOP
    public @ResponseBody
    Iterable<AudioFile> getAllUsers() {
        return audioFileRepository.findAll();
    }

    @PostMapping(path = "/newFile", headers = {"Content-type=application/json"})
    @LogAOP
    public @ResponseBody
    AudioFile newAudioFile(@RequestBody AudioFile audioFile) {
        return audioFileRepository.save(audioFile);
    }

    @GetMapping(path = "/randomFile")
    @LogAOP
    public @ResponseBody
    AudioFile randomAudioFile(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(audioFileRepository.findAll().size()) + 1;
        return audioFileRepository.getOne(Long.parseLong(randomInt+""));
    }

}
