// package compolab_07.compolab_07.dao;

// import java.util.Optional;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.stereotype.Repository;

// import compolab_07.compolab_07.entity.Organizer;
// import compolab_07.compolab_07.repository.OrganizerRepository;
// import lombok.RequiredArgsConstructor;

// @Repository
// @RequiredArgsConstructor
// public class OrganizerDaoImpl implements OrganizerDao {
//     final OrganizerRepository organizerRepository;

//     @Override
//     public Page<Organizer> getOrganizer(Pageable pageRequest) {
//         return organizerRepository.findAll(pageRequest);
//     }

//     @Override
//     public Optional<Organizer> findById(Long id) {
//         return organizerRepository.findById(id);
//     }

// }
