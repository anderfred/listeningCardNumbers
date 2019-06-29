package com.anderfred.listeningCardNumbers.repostitory;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class AudioFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    private String fileName;

    @Getter
    @Setter
    private String answer;

}
