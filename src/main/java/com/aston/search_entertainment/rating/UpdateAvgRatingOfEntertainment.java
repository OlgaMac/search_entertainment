package com.aston.search_entertainment.rating;

import com.aston.search_entertainment.domain.entity.Entertainment;
import com.aston.search_entertainment.repository.CommentRepository;
import com.aston.search_entertainment.repository.EntertainmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UpdateAvgRatingOfEntertainment {

    private final CommentRepository commentRepository;
    private final EntertainmentRepository entertainmentRepository;

    @Transactional
  //  @Scheduled(fixedRateString = "${rating.timeForScheduler}")
    @Scheduled(fixedDelay=100000)
    public void updateAvgRatingForCompanies() {
        log.info("Начало обновления рейтинга досуга");
        List<Entertainment> list = entertainmentRepository.findAll();
        for (Entertainment entertainment:list){
            if (entertainment.getComments().size() > 1) {
                Double newRating = commentRepository.getAvgRatingOfEntertainment(entertainment.getId());
                entertainment.setRating(newRating);
            }
        };
        log.info("Рейтинг досуга обновлен");
    }
}
