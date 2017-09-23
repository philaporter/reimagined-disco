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
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        IdGenerator idGenerator = hz.getIdGenerator("id");
        for (int k = 0; k < 10; k++){
            Thread.sleep(200);
            System.out.printf("Id : %s\n", idGenerator.newId());
        }
        /*
            Run the application more times simultaneously and 
            the newIds being generated will advance 10k and 
            remain unique.
        */
    }
}
