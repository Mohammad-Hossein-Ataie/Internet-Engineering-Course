public class Actor {
    private String id;
    private String name;
    private String birthDate;
    private String nationality;

    public Actor(String id, String name, String birthDate,String nationality) {
        this.name = name;
        this.id = id;
        this.birthDate = birthDate;
        this.nationality = nationality;
    }
    public boolean isSame(Actor actor) {
        return this.id.equals(actor.id);
    }
    public void updateActor(Actor actor) {
        this.name = name;
        this.id = id;
        this.birthDate = birthDate;
        this.nationality = nationality;
    }
}
