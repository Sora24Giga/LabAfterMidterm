package compolab_07.compolab_07.config;

import java.util.ArrayList;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import compolab_07.compolab_07.entity.Event;
import compolab_07.compolab_07.entity.Organizer;
import compolab_07.compolab_07.entity.Participant;
import compolab_07.compolab_07.repository.EventRepository;
import compolab_07.compolab_07.repository.OrganizerRepository;
import compolab_07.compolab_07.repository.ParticipantRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
        final EventRepository eventRepository;
        final OrganizerRepository organizerRepository;
        final ParticipantRepository participantRepository;

        @Override
        @Transactional
        public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
                Organizer org1, org2, org3;
                org1 = organizerRepository.save(Organizer.builder()
                                .name("CAMT").build());
                org2 = organizerRepository.save(Organizer.builder()
                                .name("CMU").build());
                org3 = organizerRepository.save(Organizer.builder()
                                .name("ChiangMai").build());

                Participant par1, par2, par3, par4, par5;
                par1 = participantRepository.save(Participant.builder()
                                .name("P1")
                                .telNo("011").eventHistory(new ArrayList<>())
                                .build());
                par2 = participantRepository.save(Participant.builder()
                                .name("P2")
                                .telNo("212").eventHistory(new ArrayList<>())
                                .build());
                par3 = participantRepository.save(Participant.builder()
                                .name("P3")
                                .telNo("033").eventHistory(new ArrayList<>())
                                .build());
                par4 = participantRepository.save(Participant.builder()
                                .name("P4")
                                .telNo("044").eventHistory(new ArrayList<>())
                                .build());
                par5 = participantRepository.save(Participant.builder()
                                .name("P5")
                                .telNo("052").eventHistory(new ArrayList<>())
                                .build());
                Event tempEvent;
                tempEvent = eventRepository.save(Event.builder()
                                .category("Academic")
                                .title("Midterm Exam")
                                .description("A time for taking the exam")
                                .location("CAMT Building")
                                .date("3rd Sept")
                                .time("3.00-4.00 pm.")
                                .petAllowed(false).participants(new ArrayList<>())
                                .build());
                tempEvent.setOrganizer(org1);
                tempEvent.getParticipants().add(par1);
                tempEvent.getParticipants().add(par2);
                tempEvent.getParticipants().add(par3);
                tempEvent.getParticipants().add(par4);
                tempEvent.getParticipants().add(par5);
                par1.getEventHistory().add(tempEvent);
                par2.getEventHistory().add(tempEvent);
                par3.getEventHistory().add(tempEvent);
                par4.getEventHistory().add(tempEvent);
                par5.getEventHistory().add(tempEvent);
                org1.getOwnEvents().add(tempEvent);
                tempEvent = eventRepository.save(Event.builder()
                                .category("Academic")
                                .title("Commencement Day")
                                .description("A time for celebration")
                                .location("CMU Convention hall")
                                .date("21th Jan")
                                .time("8.00am-4.00 pm.")
                                .petAllowed(false).participants(new ArrayList<>())
                                .build());
                tempEvent.setOrganizer(org1);
                tempEvent.getParticipants().add(par1);
                tempEvent.getParticipants().add(par2);
                tempEvent.getParticipants().add(par3);
                tempEvent.getParticipants().add(par4);
                tempEvent.getParticipants().add(par5);
                par1.getEventHistory().add(tempEvent);
                par2.getEventHistory().add(tempEvent);
                par3.getEventHistory().add(tempEvent);
                par4.getEventHistory().add(tempEvent);
                par5.getEventHistory().add(tempEvent);
                org1.getOwnEvents().add(tempEvent);
                tempEvent = eventRepository.save(Event.builder()
                                .category("Cultural")
                                .title("Loy Krathong")
                                .description("A time for Krathong")
                                .location("Ping River")
                                .date("21th Nov")
                                .time("8.00-10.00 pm.")
                                .petAllowed(false).participants(new ArrayList<>())
                                .build());
                tempEvent.setOrganizer(org2);
                tempEvent.getParticipants().add(par1);
                tempEvent.getParticipants().add(par2);
                tempEvent.getParticipants().add(par3);
                tempEvent.getParticipants().add(par4);
                tempEvent.getParticipants().add(par5);
                par1.getEventHistory().add(tempEvent);
                par2.getEventHistory().add(tempEvent);
                par3.getEventHistory().add(tempEvent);
                par4.getEventHistory().add(tempEvent);
                par5.getEventHistory().add(tempEvent);
                org1.getOwnEvents().add(tempEvent);
                tempEvent = eventRepository.save(Event.builder()
                                .category("Cultural")
                                .title("Songkran")
                                .description("Let's Play Water")
                                .location("Chiang Mai Moat")
                                .date("13th April")
                                .time("10.00am - 6.00 pm.")
                                .petAllowed(true).participants(new ArrayList<>())
                                .build());
                tempEvent.setOrganizer(org3);
                tempEvent.getParticipants().add(par1);
                tempEvent.getParticipants().add(par2);
                tempEvent.getParticipants().add(par3);
                tempEvent.getParticipants().add(par4);
                tempEvent.getParticipants().add(par5);
                par1.getEventHistory().add(tempEvent);
                par2.getEventHistory().add(tempEvent);
                par3.getEventHistory().add(tempEvent);
                par4.getEventHistory().add(tempEvent);
                par5.getEventHistory().add(tempEvent);
                org3.getOwnEvents().add(tempEvent);

                organizerRepository.save(Organizer.builder()
                                .name("Dog")
                                .build());

                organizerRepository.save(Organizer.builder()
                                .name("Cat")
                                .build());

                organizerRepository.save(Organizer.builder()
                                .name("MOOO")
                                .build());
        }
}
