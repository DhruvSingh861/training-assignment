package hashing;

import java.util.*;


public class My_HashTable {
    Pair arr[];
    
    int capacity;
    int collisions;
    class Pair{
        int key;
        int val;
        public Pair(int k,int v){
            key=k;
            val=v;
        }
    }
    public My_HashTable(Integer x){
        capacity=x;
        collisions=0;
        arr=new Pair[x];
    }
    public int getCollisions(){
        return collisions;
    }
    public void put(Integer k, Integer v){
        int hashValue=hash(k);
        if(arr[hashValue]!=null && arr[hashValue].key!=k) collisions++;
        arr[hashValue]=new Pair(k,v);
    }
    public int hash(Integer k){
        //System.out.println(k+"---"+k.hashCode()%capacity);
        return ((k.hashCode())%capacity);
    }
    public int get(Integer k){
        //System.out.println(" "+arr[hash(k)]key);
        return arr[hash(k)].val;
    }
    public static void main(String args[]){
        My_HashTable map=new My_HashTable(100001);
        int val=10,key=1;
        Set<Integer> s=new HashSet<>();
        Random rand =new Random();
        for(int i=0;i<100000;i++){
            int r=rand.nextInt((1000000-1)+1)+1;
            if(!s.contains(r))
            map.put(r, val++);
            s.add(r);
        }
//        map.put(1,10);
//        map.put(12,20);
//        map.put(16,30);
//        map.put(81,40);
//        map.put(341,50);
//        map.put(9871,60);
//        System.out.println(map.get(1));
//        System.out.println(map.get(12));
//        System.out.println(map.get(16));
//        System.out.println(map.get(81));
//        System.out.println(map.get(341));
//        System.out.println(map.get(9871));
        System.out.println(map.getCollisions());
    }
}
