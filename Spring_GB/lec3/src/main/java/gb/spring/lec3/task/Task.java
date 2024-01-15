package gb.spring.lec3.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class Task {
    private Long id;
    private String name;
    private String description;
    private boolean completed;
}
