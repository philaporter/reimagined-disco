package com.philipporter.nosql.in.memory.db;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;

/**
 * @author Philip Porter
 * @version 0.0.0
 */
public class Main {
    
    // Using https://odoepner.files.wordpress.com/2015/04/mastering_hazelcast1.pdf for documentation
    public static void main(String[] args) throws InterruptedException{
        /*
            Create two instances and test the cluster. Call 
            newId() for both IdGenerator objects. The IDs generated 
            will advance 10k and remain unique.
        */
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        HazelcastInstance hz2 = Hazelcast.newHazelcastInstance();
        IdGenerator idGenerator = hz.getIdGenerator("id");
        IdGenerator idGenerator2 = hz2.getIdGenerator("id");
        
        for (int k = 0; k < 10; k++){
            Thread.sleep(200);
            System.out.printf("Id : %s\n", idGenerator.newId());
            System.out.printf("Id : %s\n", idGenerator2.newId());
        }
    }
}
