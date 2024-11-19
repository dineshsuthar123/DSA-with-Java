package HashMaps;

import java.util.*;

class MapUsingHash {

  private Entity[] entities;
  
  public MapUsingHash() {
    entities = new Entity[100];
  }

  public void put(String key, String value) {
    int hash = Math.abs(key.hashCode() % entities.length);
    entities[hash] = new Entity(key, value); // overriding
  }

  public String get(String key) {
    int hash = Math.abs(key.hashCode() % entities.length);
    if(entities[hash] != null && entities[hash].key.equals(key)) {
      return entities[hash].value;
    }
    return null;
  }

  public void remove(String key) {
    int hash = Math.abs(key.hashCode() % entities.length);
    if(entities[hash] != null && entities[hash].key.equals(key)) {
    entities[hash] = null;
    }
  }

  private class Entity {
    String key;
    String value;

    public Entity(String key, String value) {
      this.key = key;
      this.value = value;
    }
  }
}



class Main {
  public static void main(String[] args) {

    HashMapFinal<String, String> map = new HashMapFinal<>();
    
    map.put("Mango", "King of fruits");
    map.put("Apple", "A sweet red fruit");
    map.put("Litchi", "Kunal's fav fruit");

    System.out.println(map);
    
    
  }

  public static void hashDemo() {
    // String name = "Rahul";

    // Integer a = 4235678;

    // int code = a.hashCode();

    // System.out.println(code);

    HashMap<String, Integer> map = new HashMap<>();

    map.put("Kunal", 89);
    map.put("Karan", 99);
    map.put("Rahul", 94);

    // System.out.println(map.get("Karan"));
    // System.out.println(map.getOrDefault("Apoorv", 78));
    System.out.println(map.containsKey("Karan"));

    HashSet<Integer> set = new HashSet<>();
    set.add(56);
    set.add(9);
    set.add(12);
    set.add(43);
    set.add(56);
    set.add(2);

    System.out.println(set);
  }
  
}

 class HashMapFinal<K, V> {
  ArrayList<LinkedList<Entity>> list;

  private int size = 0;

  private float lf = 0.5f;

  public HashMapFinal() {
    list = new ArrayList<>();
    for(int i=0; i < 10; i++) {
      list.add(new LinkedList<>());
    }
  }

  public void put(K key, V value) {
    int hash = Math.abs(key.hashCode() % list.size());

    LinkedList<Entity> entities = list.get(hash);

    for (Entity entity : entities) {
      if(entity.key.equals(key)) {
        entity.value = value;
        return;
      }
    }

    if((float)(size) / list.size() > lf) {
      reHash();
    }
    
    entities.add(new Entity(key, value));

    size++;
  }

  private void reHash() {
    System.out.println("We are now rehashing!");

    ArrayList<LinkedList<Entity>> old = list;
    list = new ArrayList<>();

    size = 0;

    for(int i=0; i<old.size() * 2; i++) {
      list.add(new LinkedList<>());
    }

    for(LinkedList<Entity> entries :old) {
      for(Entity entry : entries) {
        put(entry.key, entry.value);
      }
    }
  }

  public V get(K key) {
    int hash = Math.abs(key.hashCode() % list.size());
    LinkedList<Entity> entities = list.get(hash);
    for(Entity entity : entities) {
      if(entity.key.equals(key)) {
        return entity.value;
      }
    }
    return null;
  }

  public void remove(K key) {
    int hash = Math.abs(key.hashCode() % list.size());
    LinkedList<Entity> entities = list.get(hash);

    Entity target = null;
    
    for(Entity entity : entities) {
      if(entity.key.equals(key)) {
        target = entity;
        break;
      }
    }

    entities.remove(target);
    size--;
  }

  public boolean containsKey(K key) {
    return get(key) != null;
  }

  @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
        builder.append("{");
      for(LinkedList<Entity> entities : list) {
        for(Entity entity : entities) {
          builder.append(entity.key);
          builder.append(" = ");
          builder.append(entity.value);
          builder.append(" , ");
        }
      }
      builder.append("}");

      return builder.toString();
    }

  private class Entity {
    K key;
    V value;

    public Entity(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  
}