package Aulas.Huffman;

import java.util.ArrayList;
import java.util.List;

public class trieST<Value> {
    private static final int R = 256;
    private Node root = new Node();

    private static class Node{
        private Object value;
        private Node[] next = new Node[R];
    }

    public void put(String key, Value val){
        root = put(root, key, val, 0);
    }
    private Node put(Node r, String key, Value val, int d){
        if(r == null){ r = new Node();}
        if(d == key.length()){ r.value = val; return r;}
        char c = key.charAt(d);
        r.next[c] = put(r.next[c], key, val, d+1);
        return r;
    }

    public boolean contains(String key){
        return get(key) != null;
    }
    
    public Value get(String key){
        Node x = get(root, key, 0);
        if(x == null){return null;}
        return (Value) x.value;
    }
    private Node get(Node r, String key, int d){
        if(r == null){return null;}
        if(d == key.length()){return r;}
        char c = key.charAt(d);
        return get(r.next[c], key, d+1);
    }

    public void delete(String key){
        root = delete(root, key, 0);
    }
    private Node delete(Node r, String key, int d){
        if(r == null){return null;}
        
        if(d == key.length()){
            r.value = null;
        }else{
            char c = key.charAt(d);
            r.next[c] = delete(r.next[c], key, d+1);
        }
        
        if(r.value != null){
            return r;
        }

        for(int i = 0; i < R; i++){
            if(r.next[i] != null){return r;}
        }

        return null;
    }

    public List<String> keysWithPrefix(String prefix){
        List<String> results = new ArrayList<>();
        Node x = get(root, prefix, 0);
        collect(x, new StringBuilder(prefix), results);
        return results;
    }
    private void collect(Node x, StringBuilder prefix, List<String> results){
        if(x == null){return;}
        if(x.value != null){
            results.add(prefix.toString());
        }
        for(char c = 0; c < R; c++){
            if(x.next[c] != null){
                prefix.append(c);
                collect(x.next[c], prefix, results);
                prefix.deleteCharAt(prefix.length()-1);
            }
        }
    }

    public List<String> keys(){
        return keysWithPrefix("");
    }
}
