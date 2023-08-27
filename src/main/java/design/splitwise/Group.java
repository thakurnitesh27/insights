package design.splitwise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Group {

    private String groupId;
    private String groupName;
    private Set<User> users;

    public Group(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupId() {
        return groupId;
    }

    public Set<User> getUsers() {
        return Collections.unmodifiableSet(users);
    }

    public void addUsers(User... users) {

        Arrays.asList(users).forEach(u -> u.addGroup(this));
        this.users.addAll(Arrays.asList(users));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (!groupId.equals(group.groupId)) return false;
        return groupName.equals(group.groupName);
    }

    @Override
    public int hashCode() {
        return groupId.hashCode();
    }
}
