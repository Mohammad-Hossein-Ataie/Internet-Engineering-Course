package org.example.CA1.Entity;

public class Actor {
    private int id;
    private String name;
    private String birthDate;
    private String nationality;

    public String getActorImage() {
        return image;
    }

    private String image;


    public Actor(int id, String name, String birthDate, String nationality, String actorImage) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isSame(Actor actor) {
        return this.id == actor.id;
    }
}
