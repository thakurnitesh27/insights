package design.splitwise;

import java.util.Set;

public interface User {

   String getId();
   String getName();
   Set<Group> getGroup();
   void addGroup(Group group);


}
