package Aulas.Huffman;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// A Tree node
class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq, Node left, Node right) {
        this.ch = ch;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}

// Comparison object to be used to order the heap
class NodeComparator implements Comparator<Node> {
    public int compare(Node l, Node r) {
        return Integer.compare(l.freq, r.freq);
    }
}

public class huffman {
    
    // Traverse the Huffman Tree and store Huffman Codes in a map
    public static void encode(Node root, String str, Map<Character, String> huffmanCode) {
        if (root == null) {
            return;
        }
        
        // Found a leaf node
        if (root.left == null && root.right == null) {
            huffmanCode.put(root.ch, str);
        }
        
        encode(root.left, str + "0", huffmanCode);
        encode(root.right, str + "1", huffmanCode);
    }
    
    // Traverse the Huffman Tree and decode the encoded string
    public static void decode(Node root, int[] index, String str) {
        if (root == null) {
            return;
        }
        
        // Found a leaf node
        if (root.left == null && root.right == null) {
            System.out.print(root.ch);
            return;
        }
        
        index[0]++;
        if (str.charAt(index[0]) == '0') {
            decode(root.left, index, str);
        } else {
            decode(root.right, index, str);
        }
    }
    
    // Builds Huffman Tree and decodes given input text
    public static void buildHuffmanTree(String text) {
        // Count frequency of appearance of each character and store it in a map
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : text.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        
        System.out.println("\nFrequency table:\n");
        for (var entry : freq.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        
        // Create a priority queue to store live nodes of Huffman tree
        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
        
        // Create a leaf node for each character and add it to the priority queue
        for (var entry : freq.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue(), null, null));
        }
        
        // Do till there is more than one node in the queue
        while (pq.size() > 1) {
            // Remove the two nodes of highest priority (lowest frequency)
            Node left = pq.poll();
            Node right = pq.poll();
            
            // Create a new internal node with these two nodes as children
            int sum = left.freq + right.freq;
            pq.add(new Node('\0', sum, left, right));
        }
        
        // Root stores pointer to root of Huffman Tree
        Node root = pq.peek();
        
        // Traverse the Huffman Tree and store Huffman Codes in a map
        Map<Character, String> huffmanCode = new HashMap<>();
        encode(root, "", huffmanCode);
        
        System.out.println("\nHuffman Codes are :\n");
        for (var entry : huffmanCode.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        
        System.out.println("\nOriginal string was :\n" + text);
        
        // Print encoded string
        StringBuilder str = new StringBuilder();
        for (char ch : text.toCharArray()) {
            str.append(huffmanCode.get(ch));
        }
        
        System.out.println("\nEncoded string is :\n" + str);
        
        // Traverse the Huffman Tree again and decode the encoded string
        int[] index = {-1};
        System.out.println("\nDecoded string is: ");
        while (index[0] < str.length() - 2) {
            decode(root, index, str.toString());
        }
        
        System.out.println("\n");
    }
    
    public static void main(String[] args) {
        String text = "A B C D E A B C D A B C A B A";
        buildHuffmanTree(text);
    }
}
