public class MyHashTable <K,V>{
    private class HashCode<K,V>{
        private K key;
        private V value;
        private HashCode<K,V> next;

        public HashCode(K key,V value){
            this.key=key;
            this.value=value;
        }

        public String toString(){
            return "{"+ key + " " + value + "}";
        }

    }

    private HashCode<K,V>[] chainArray;
    private int capacity=11;
    private float loadFactor=0.75F;
    private int size=0;

    public MyHashTable(){
        chainArray=new HashCode[capacity];
    }
    public MyHashTable(int capacity){
        int newCapacity= (int) (capacity*loadFactor);
        if(newCapacity<1){
            chainArray=new HashCode[capacity];
            return;
        }
        capacity=newCapacity;
        chainArray=new HashCode[capacity];
    }

    private int hash(K key){
        return Math.abs(key.hashCode()%capacity);
    }

    public void put(K key,V value){
        int keyBucket = hash(key);

        HashCode<K, V> temp = chainArray[keyBucket];
        while (temp != null) {
            if ((temp.key == null && key == null)
                    || (temp.key != null && temp.key.equals(key))) {
                temp.value = value;
                return;
            }
            temp = temp.next;
        }

        chainArray[keyBucket] = new HashCode<K, V>(key, value);
        size++;
    }


    public V get(K key){
          if(key.equals(hash(key))){
              return (V) key;
          }
          return (V) "nothing";
    }

    public V remove(K key){
    int index=hash(key);
    HashCode head=chainArray[index];
    HashCode prev=null;
    while(head != null){
        if(head.key.equals(key)){
            break;
        }
        prev=head;
        head=head.next;
    } if(head==null){return null;}
    size--;
    if (prev != null){ prev.next=head.next;}
    else{chainArray[index]=head.next;}
    return (V) head.value;
    }

    public boolean contains(V value){
        for(int i=0;i<size;i++){
            if(value.equals(chainArray[i])){return true;}
        }
        return false;
    }

    public V getValue(K key){
         int index=hash(key);
         HashCode head=chainArray[index];
         while(head != null){
             if(head.key.equals(key)){
                 return (V) head.value;
             }
             head=head.next;
         }
        return null;
    }
}
