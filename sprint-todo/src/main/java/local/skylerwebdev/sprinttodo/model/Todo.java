package local.skylerwebdev.sprinttodo.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import static javax.persistence.TemporalType.TIMESTAMP;

@Entity
@Table(name = "todo")
public class Todo
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;
    private String description;
    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date datestarted;
    private boolean completed;

    public Todo(String description, Date datestarted, boolean completed)
    {
        this.description = description;
        this.datestarted = datestarted;
        this.completed = completed;
    }

    public Todo()
    {
    }

    public long getTodoid()
    {
        return todoid;
    }

    public void setTodoid(long todoid)
    {
        this.todoid = todoid;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getDatestarted()
    {
        return datestarted;
    }

    public void setDatestarted(Date datestarted)
    {
        this.datestarted = datestarted;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    @Override
    public String toString()
    {
        return "Todo{" +
                "todoid=" + todoid +
                ", description='" + description + '\'' +
                ", datestarted=" + datestarted +
                ", completed=" + completed +
                '}';
    }
}
