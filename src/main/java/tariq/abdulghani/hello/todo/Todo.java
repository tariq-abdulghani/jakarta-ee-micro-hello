package tariq.abdulghani.hello.todo;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "TODO")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Size(min = 3, max = 20, message = "it must be at least 3 and max 20 chars.")
    String title;

    @NotNull(message = "objective can't be empty.")
    String objective;

    @FutureOrPresent(message = "creation date must be future or present.")
    Date creation_date;

    boolean completed;


    Date completed_at;

    public Todo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Date getCompleted_at() {
        return completed_at;
    }

    public void setCompleted_at(Date completed_at) {
        this.completed_at = completed_at;
    }

    @PrePersist
    private void initCreationDate(){
        this.creation_date = new Date();
    }
}
