package interviews.questions.amazon;

//Question: Find shortest distance between two people in a social network.
//Given a person class with getAllConnections().
// class Person  {
//     List<Person> getAllConnections() {
//         // Direct connections only.
//     }
// }
// **/
//public List<String> shortedPath(final Person personA, final Person personB) {
//}

//Reference: Cracking coding interview - Scalability chapter

import java.util.*;

public class ShortestDistBetweenFriends {

    public class Person {
        private List<Person> friends = new ArrayList<>();
        private int personID;
        private String info;

        public String getInfo() { return info; }
        public void setInfo(String info) {
            this.info = info;
        }

        public List<Person> getFriends() {
            return friends;
        }

        public int getID() {
            return personID;
        }

        public void addFriend(Person person) {
            friends.add(person);
        }

        /*public void addFriend(int id) {
            friends.add(id);
        }*/

        public Person(int id) {
            this.personID = id;
        }

    }

    public class PathNode {
        private Person person = null;
        private PathNode previousNode = null;
        public PathNode(Person p, PathNode previous) {
            person = p;
            previousNode = previous;
        }

        public Person getPerson() {
            return person;
        }

        public Deque<Person> collapse(boolean startsWithRoot) {
            Deque<Person> path = new LinkedList<>();
            PathNode node = this;
            while (node != null) {
                if (startsWithRoot) {
                    path.addLast(node.person);
                } else {
                    path.addFirst(node.person);
                }
                node = node.previousNode;
            }
            return path;
        }
    }

    public Deque<Person> findPathBFS(Map<Integer, Person> people, int source, int destination) {
        Queue<PathNode> toVisit = new LinkedList<PathNode>();
        Set<Person> visited = new HashSet<>();
        toVisit.add(new PathNode(people.get(source), null));
        visited.add(people.get(source));
        while (!toVisit.isEmpty()) {
            PathNode node = toVisit.poll();
            Person person = node.getPerson();
            if (person.getID() == destination) {
                return node.collapse(false);
            }

            /* Search friends. */
            List<Person> friends = person.getFriends();
            for (Person friend : friends) {
                if (!visited.contains(friend)) {
                    visited.add(friend);
                    toVisit.add(new PathNode(friend, node));
                }
            }
        }
        return null;
    }

    public Deque<Person> findShortestPath(Person source, Person destination){
        Queue<PathNode> toVisit = new LinkedList<>();
        Set<Person> visited = new HashSet<>();
        toVisit.add(new PathNode(source,null));
        visited.add(source);

        while (!toVisit.isEmpty()){
            PathNode path = toVisit.poll();
            Person person = path.getPerson();
            if (person.getID() == destination.getID()){
                return path.collapse(false);
            }

            List<Person> friends = person.getFriends();
            for (Person friend : friends){
                if (!visited.contains(friend)){
                    visited.add(friend);
                    toVisit.add(new PathNode(friend,path));
                }
            }
        }
        return null;
    }
    public void setUpFriends(int[][] edges,Map<Integer,Person> people){

        for (int[] edge : edges) {
            Person source = people.get(edge[0]);
            source.addFriend(people.get(edge[1]));

            Person destination = people.get(edge[1]);
            destination.addFriend(people.get(edge[0]));
        }

    }

    public Map<Integer,Person> setUpPeople(int nPeople){

        Map<Integer, Person> people = new HashMap<Integer, Person>();
        for (int i = 0; i < nPeople; i++) {
            Person p = new Person(i);
            people.put(i, p);
        }
        return people;
    }

    public void printPeople(Deque<Person> path) {
        if (path == null) {
            System.out.println("No path");
        } else {
            for (Person p : path) {
                System.out.println(p.getID());
            }
        }
    }

    public static void main(String[] args) {

        ShortestDistBetweenFriends shortDistBetweenFriends = new ShortestDistBetweenFriends();

        int nPeople = 11;
        Map<Integer, Person> people = shortDistBetweenFriends.setUpPeople(nPeople);

        int[][] edges = {{1, 4}, {1, 2}, {1, 3}, {3, 2}, {4, 6}, {3, 7}, {6, 9}, {9, 10}, {5, 10}, {2, 5}, {3, 7}};

        shortDistBetweenFriends.setUpFriends(edges,people);

        for (Map.Entry<Integer,Person> entry : people.entrySet()){
            System.out.print("Connections for person "+entry.getKey()+" are: ");
            List<Person> friends = entry.getValue().getFriends();
            for(Person person : friends){
                System.out.print(person.getID()+",");
            }
            System.out.println();
        }

        int i = 1;
        int j = 7;
        Deque<Person> path1 = shortDistBetweenFriends.findPathBFS(people, i, j);
        System.out.println("Shortest distance between person "+i+" and person "+j+" is "+path1.size()+" friends ");
        System.out.println("Friends connection path: ");
        shortDistBetweenFriends.printPeople(path1);

        i = 1;
        j = 7;
        Deque<Person> path2 = shortDistBetweenFriends.findShortestPath(people.get(i), people.get(j));
        System.out.println("Shortest distance between person "+i+" and person "+j+" is "+path2.size()+" friends ");
        System.out.println("Friends connection path: ");
        shortDistBetweenFriends.printPeople(path2);
    }
}
