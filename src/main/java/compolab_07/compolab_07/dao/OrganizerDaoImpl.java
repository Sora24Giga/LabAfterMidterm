// package compolab_07.compolab_07.dao;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.stereotype.Repository;

// import compolab_07.compolab_07.entity.Organizer;
// import jakarta.annotation.PostConstruct;

// @Repository
// public class OrganizerDaoImpl implements OrganizerDao {
//     List<Organizer> eventList;

//     @PostConstruct
//     public void init() {
//         eventList = new ArrayList<>();

//         eventList.add(Organizer.builder()
//                 .id(1003L)
//                 .organizerName("Dog")
//                 .address("home")
//                 .build());

//         eventList.add(Organizer.builder()
//                 .id(1004L)
//                 .organizerName("Cat")
//                 .address("home")
//                 .build());

//         eventList.add(Organizer.builder()
//                 .id(1005L)
//                 .organizerName("MOOO")
//                 .address("home")
//                 .build());
//     }

//     @Override
//     public Integer getEventSize() {
//         return eventList.size();
//     }

//     @Override
//     public List<Organizer> getEvents(Integer pageSize, Integer page) {
//         pageSize = pageSize == null ? eventList.size() : pageSize;
//         page = page == null ? 1 : page;
//         int firstIndex = (page - 1) * pageSize;
//         return eventList.subList(firstIndex, firstIndex + pageSize);
//     }

//     @Override
//     public Organizer getEvent(Long id) {
//         return eventList.stream().filter(event -> event.getId().equals(id)).findFirst().orElse(null);
//     }
// }