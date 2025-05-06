package Aulas.Huffman;

import java.util.ArrayList;
import java.util.List;

public class TST<Value> {
    private Node root;

    private class Node{
        private Value val;
        private char c;
        private Node left, mid, right;
    }

    public void put(String key, Value val){root = put(root, key, val, 0);}
    private Node put(Node x, String key, Value val, int d){
        char c = key.charAt(d);
        if(x == null){x = new Node(); x.c = c;}
        if(c < x.c){
            x.left = put(x.left, key, val, d);
        }else if(c > x.c){
            x.right = put(x.right, key, val, d);
        }else if(d < key.length()-1){
            x.mid = put(x.mid, key, val, d+1);
        }else{
            x.val = val;
        }
        return x;
    }

    public boolean contains(String key){ return get(key) != null;}

    public Value get(String key){
        Node x = get(root, key, 0);
        if(x == null){return null;}
        return x.val;
    }
    private Node get(Node x, String key, int d){
        if(x == null){return null;}
        char c = key.charAt(d);
        if(c < x.c){
            x.left = get(x.left, key, d);
        }else if(c > x.c){
            x.right = get(x.right, key, d);
        }else if(d < key.length()-1){
            x.mid = get(x.mid, key, d+1);
        }else{
            return x ;
        }
        return null;
    }

    public void delete(String key){root = delete(root, key, 0);}
    private Node delete(Node x, String key, int d){
        if(x == null){ return null;}
        char c = key.charAt(d);
        if(c < x.c){
            x.left = delete(x.left, key, d);
        }else if(c > x.c){
            x.right = delete(x.right, key, d);
        }else if(d < key.length()-1){
            x.mid = delete(x.mid, key, d+1);
        }else{
            x.val = null;
        }

        if(x.val != null){return x;}
        if(x.left == null && x.mid == null && x.right == null){return null;}
        
        return null;
    }

    public List<String> keysWithPrefix(String prefix){
        List<String> results = new ArrayList<>();
        Node x = get(root, prefix, 0);
        if(x == null){return results;}
        if(x.val != null){results.add(prefix);}
        collect(x.mid, new StringBuilder(prefix), results);
        return results;
    }
    private void collect(Node x, StringBuilder prefix, List<String> results){
        if(x == null){return;}
        collect(x.left, prefix, results);
        if(x.val != null){results.add(prefix.toString() + x.c);}
        collect(x.mid, prefix.append(x.c), results);
        prefix.deleteCharAt(prefix.length()-1);
        collect(x.right, prefix, results);
    }

    public List<String> keys(){
        return keysWithPrefix("");
    }
}
