import java.util.Iterator;

public class BST <K extends Comparable<K>,V> implements Iterable<K>{
    private Node root;

    private class Node{
        private K key;
        private V value;
        private Node left,right;
        public Node(K key, V value){
            this.key=key;
            this.value=value;
        }
    }
    public void put(K key, V value){
        root=put(root,key,value);
    }
    private Node put(Node r,K key,V value){
        if(r==null) return null;
        int count= key.compareTo(r.key);
        if(count<0) r.left=put(r.left,key,value);
        else if(count>0) r.right=put(r.right,key,value);
        else r.value=value;
        return r;
    }
    public V get(K key,V value){
        return get(root,key);
    }
    private V get(Node r,K key){
        if(r==null) return null;
        int count=key.compareTo(r.key);
        if (count<0) return get(r.left,key);
        else if (count>0) return get(r.right,key);
        else return r.value;
    }
    public void delete(K key){ root=delete(root,key);} //delete min case?
    public Node delete(Node r,K key){
        if(r==null) return null;
         if(key.compareTo(r.key)>0){
             r.left=delete(r.left,key);
         } else if (key.compareTo(r.key)<0){
             r.right=delete(r.right,key);
        } else {
             if((r.left.equals(null)) || r.right.equals(null)) {
                 Node temp=null;
                 if(temp.equals(r.left)){ return r.right;}
                 else{return r.left;}
             }
         }
         return r;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
     }

}
