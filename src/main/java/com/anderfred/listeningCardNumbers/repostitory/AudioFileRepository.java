package com.anderfred.listeningCardNumbers.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AudioFileRepository extends JpaRepository<AudioFile, Long> {
}
