package compolab_07.compolab_07.entity;

import java.util.ArrayList;
import java.util.List;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizerDTO {
    Long id;
    String name;
    List<OrganizerOwnEventsDTO> ownEvents = new ArrayList<>();
}
