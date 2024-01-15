package gb.spring.lec3.task;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private List<Task> ls;

    public TaskService() {
        this.ls = new ArrayList<>();
        ls.add(new Task(1L,"Drova", "privezi", false));
        ls.add(new Task(2L,"Pivo", "kupi", false));
        ls.add(new Task(3L,"Drova", "nakoli", false));
    }

    public Task getTask(Long id) {
        return ls.stream()
                .filter(it -> it.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Task> getAll(){
    return ls;
    }

    public Task createTask(Task task) {
        ls.add(task);
        return task;
    }

    public Task updateTask(long id, Task updatedTask) {
        Task existingTask = getTask(id);
        if (existingTask != null) {
            existingTask.setName(updatedTask.getName());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setCompleted(updatedTask.isCompleted());
        }
        return existingTask;
    }
    public void deleteTask(Long id) {
        ls.removeIf(task -> task.getId().equals(id));
    }

}
