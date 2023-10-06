package compolab_07.compolab_07.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import compolab_07.compolab_07.entity.Event;
import compolab_07.compolab_07.entity.Organizer;
import compolab_07.compolab_07.repository.EventRepository;
import compolab_07.compolab_07.repository.OrganizerRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
        final EventRepository eventRepository;
        final OrganizerRepository organizerRepository;

        @Override
        public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
                eventRepository.save(Event.builder()
                                .category("Academic")
                                .title("Midterm Exam")
                                .description("A time for taking the exam")
                                .location("CAMT Building")
                                .date("3rd Sept")
                                .time("3.00-4.00 pm.")
                                .petAllowed(false)
                                .organizer("CAMT").build());
                eventRepository.save(Event.builder()
                                .category("Academic")
                                .title("Commencement Day")
                                .description("A time for celebration")
                                .location("CMU Convention hall")
                                .date("21th Jan")
                                .time("8.00am-4.00 pm.")
                                .petAllowed(false)
                                .organizer("CMU").build());
                eventRepository.save(Event.builder()
                                .category("Cultural")
                                .title("Loy Krathong")
                                .description("A time for Krathong")
                                .location("Ping River")
                                .date("21th Nov")
                                .time("8.00-10.00 pm.")
                                .petAllowed(false)
                                .organizer("Chiang Mai").build());
                eventRepository.save(Event.builder()
                                .category("Cultural")
                                .title("Songkran")
                                .description("Let's Play Water")
                                .location("Chiang Mai Moat")
                                .date("13th April")
                                .time("10.00am - 6.00 pm.")
                                .petAllowed(true)
                                .organizer("Chiang Mai Municipality").build());
                organizerRepository.save(Organizer.builder()
                                .organizerName("Dog")
                                .address("home")
                                .build());

                organizerRepository.save(Organizer.builder()
                                .organizerName("Cat")
                                .address("home")
                                .build());

                organizerRepository.save(Organizer.builder()
                                .organizerName("MOOO")
                                .address("home")
                                .build());
        }
}
