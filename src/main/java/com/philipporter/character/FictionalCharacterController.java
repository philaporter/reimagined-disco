package com.philipporter.character;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Philip Porter
 * @version 0.0.0
 */
@RestController
public class FictionalCharacterController {
    
    @Autowired
    HazelcastInstance hzInstance;
    @Autowired
    IdGenerator idGenerator;
    @Autowired
    Map<Long,FictionalCharacter> map;
    
    @GetMapping("/character/{id}")
    public FictionalCharacter getFictionalCharacter(@PathVariable Long id){
        return map.get(id);
    }
    
    @PostMapping("/character/add")
    public ResponseEntity<FictionalCharacter> postFictionalCharacter(@RequestBody FictionalCharacter fc) {
        if(fc.getName() == null  || fc.getRole() == null) 
            return new ResponseEntity<>(fc, HttpStatus.BAD_REQUEST);
        fc.setId(idGenerator.newId());
        map.put(fc.getId(), fc);
        return new ResponseEntity<>(fc, HttpStatus.OK);
    }
}
