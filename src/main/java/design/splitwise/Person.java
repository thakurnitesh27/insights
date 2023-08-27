package design.splitwise;

import java.util.*;

public class Person implements User {

    private String Id;
    private String name;
    private Set<Group> groupId;

    public Person(String Id, Set<Group> groups){
        this.Id=Id;
        this.groupId=groups;
    }

    public Person(String Id, Group group){
        this.Id=Id;
        this.groupId=new HashSet<>();
        this.groupId.add(group);
    }

    @Override
    public String getId() {
        return Id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Set<Group> getGroup() {
        return Collections.unmodifiableSet(groupId);
    }

    @Override
    public void addGroup(Group group) {
        this.addToGroup(group);
    }

    public void addToGroup(Group group){
        groupId.add(group);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!Id.equals(person.Id)) return false;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Id.hashCode();
    }
}
