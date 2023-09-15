package BinarySearch;

import java.util.*;

class Node {
  private int timestamp;
  private String value;

  public Node(String value,int timestamp) {
    this.timestamp = timestamp;
    this.value = value;
  }

  public int getTimestamp() {
    return timestamp;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return  "timestamp=" + timestamp +
            ", value=" + value ;
  }

}
public class TimeMap {

  HashMap<String, List<Node>> map;
  public TimeMap() {
    map = new HashMap<>();
  }
  public void set(String key, String value, int timestamp) {
    Node node = new Node(value, timestamp);
    if(map.containsKey(key)){
      map.get(key).add(node);
    }
    else {
      List<Node> initialList = new ArrayList<>();
      initialList.add(node);
      map.put(key, initialList);
    }

  }

  public String get(String key, int timestamp) {
    if (!map.containsKey(key))  return "";
    List<Node> nodes = map.get(key);
    if (nodes != null) {
      nodes.sort(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
          //return Long.compare(o2.getTimestamp(), o1.getTimestamp());
          return Long.compare(timestamp, o1.getTimestamp());
        }
      });
    }
    //return value with the greatest timestamp
    return nodes.get(0).getValue();


  }

  public static void main(String[] args) {
    TimeMap map = new TimeMap();
    map.set("love", "high", 10 );
    map.set("love", "low", 20 );

    System.out.println(map.get("love", 5));
    System.out.println(map.get("love", 10));
    System.out.println(map.get("love", 15));
    System.out.println(map.get("love", 20));
    System.out.println(map.get("love", 25));
  }


}