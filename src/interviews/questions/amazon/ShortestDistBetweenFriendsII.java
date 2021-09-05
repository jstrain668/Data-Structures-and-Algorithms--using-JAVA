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

public class ShortestDistBetweenFriendsII {

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

    public class BFSData {
        public Queue<PathNode> toVisit = new LinkedList<PathNode>();
        public Map<Integer, PathNode> visited = new HashMap<>();

        public BFSData(Person root) {
            PathNode sourcePath = new PathNode(root, null);
            toVisit.add(sourcePath);
            visited.put(root.getID(), sourcePath);
        }

        public boolean isFinished() {
            return toVisit.isEmpty();
        }
    }

    public Deque<Person> mergePaths(BFSData bfs1, BFSData bfs2, Person connection) {
        PathNode end1 = bfs1.visited.get(connection.getID()); // end1 -> source
        PathNode end2 = bfs2.visited.get(connection.getID()); // end2 -> dest
        Deque<Person> pathOne = end1.collapse(false); // forward: source -> connection
        Deque<Person> pathTwo = end2.collapse(true); // reverse: connection -> dest
        pathTwo.removeFirst(); // remove connection
        pathOne.addAll(pathTwo); // add second path
        return pathOne;
    }

    /* Search one level and return collision, if any. */
    public Person searchLevel(BFSData primary, BFSData secondary) {
        /* We only want to search one level at a time. Count how many nodes are currently in the primary's
         * level and only do that many nodes. We'll continue to add nodes to the end. */
        int count = primary.toVisit.size();
        for (int i = 0; i < count; i++) {
            /* Pull out first node. */
            PathNode pathNode = primary.toVisit.poll();

            /* Check if it's already been visited. */
            if (secondary.visited.containsKey(pathNode.getPerson().getID())) {
                return pathNode.getPerson();
            }

            /* Add friends to queue. */
            Person person = pathNode.getPerson();
            for (Person friend : person.getFriends()) {
                if (!primary.visited.containsKey(friend.getID())) {
                    PathNode next = new PathNode(friend, pathNode);
                    primary.visited.put(friend.getID(), next);
                    primary.toVisit.add(next);
                }
            }
        }
        return null;
    }


    //Solution: Search from both end points source and destination using BFS where both persons maintain a
    //'toVisit' queue and visited list containing the path of persons visited so far. The search is conducted in a
    //bidirectional fashion where each level of friends from source and destination are checked first for a match and if
    //not found move onto the next level until all levels are searched or match found.When the connecting person between
    //source and destination is found the path from source and destination is constructed with use of the PathNode
    //structure which maintains a previous pointer to the person that had this connection and so on until null is reached
    //i.e. the source and destination is arrived at. Both paths are found for source and destination and then joined
    //together to form the complete path. The length of this path is the shortest path.
    //Time Complexity: Bidirectional breadth-first search: We go through 2k nodes: each of source's k friends and each
    // of destination's k friends. Of course, 2k is much less than k+k*k.
    //Bidirectional BFS: 0( k to the power of q/2 + k to the power of q/2), which is just 0( kq/2). q is the length of
    //the path.
    //If we imagine a path like A->B->C->D->E where each person has 100 friends, this is a big difference. BFS will
    //require looking at 100 million (100 to the power of 4) nodes. A bidirectional BFS will require looking at only
    //20,000 nodes (2 x 100 to the power of 2).
    public Deque<Person> findShortestPathBiDirBFS(Person source, Person destination) {
        BFSData sourceData = new BFSData(source);
        BFSData destData = new BFSData(destination);

        while (!sourceData.isFinished() && !destData.isFinished()) {
            /* Search out from source. */
            Person collision = searchLevel(sourceData, destData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision);
            }

            /* Search out from destination. */
            collision = searchLevel(destData, sourceData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision);
            }
        }
        return null;
    }

    public void setUpFriends(int[][] edges,Map<Integer, Person> people){

        for (int[] edge : edges) {
            Person source = people.get(edge[0]);
            source.addFriend(people.get(edge[1]));

            Person destination = people.get(edge[1]);
            destination.addFriend(people.get(edge[0]));
        }

    }

    public Map<Integer, Person> setUpPeople(int nPeople){

        Map<Integer, Person> people = new HashMap<>();
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

        ShortestDistBetweenFriendsII shortDistBetweenFriends = new ShortestDistBetweenFriendsII();

        int nPeople = 11;
        Map<Integer,Person> people = shortDistBetweenFriends.setUpPeople(nPeople);

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
        int j = 10;
        Deque<Person> path3 = shortDistBetweenFriends.findShortestPathBiDirBFS(people.get(i), people.get(j));
        System.out.println("Shortest distance between person "+i+" and person "+j+" is "+path3.size()+" friends ");
        System.out.println("Friends connection path: ");
        shortDistBetweenFriends.printPeople(path3);
    }
}
