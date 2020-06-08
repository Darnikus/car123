package antihype.carsharings.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carAdvert")
public class CarAdvert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    @OneToMany(fetch = FetchType.EAGER)
    @CollectionTable(name = "renters", joinColumns = @JoinColumn(name = "user_id"))
    private Set<User> renters;

    public CarAdvert() {
    }

    public CarAdvert(String text, User author) {
        this.text = text;
        this.author = author;
        renters = new HashSet<>();
    }

    public void addRenter(User user) {
        renters.add(user);
    }

    public void deleteRenter(User user) {
        renters.remove(user);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Set<User> getRenters() {
        return renters;
    }

    public void setRenters(Set<User> renters) {
        this.renters = renters;
    }
}
