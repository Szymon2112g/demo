package com.learn.demo.Controller;

import com.learn.demo.Entity.Job;
import com.learn.demo.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HibernateController {

    JobService jobService;

    @Autowired
    public HibernateController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/sss")
    public String ccc(){
        jobService.deleteById(3);
        return "sss";
    }

    @GetMapping("/hibernate/joblist")
    public List<Job> getAllJobs() {

        return jobService.findAll();
    }

    @GetMapping("/hibernate/getsinglejob/{id}")
    public Job getSingleJob(@PathVariable long id) {

        return jobService.findById(id);
    }

    @DeleteMapping("/hibernate/deletejob/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable long id) {

        jobService.deleteById(id);

        return  ResponseEntity.noContent().build();
    }

    @PutMapping("/hibernate/updatejob/{id}")
    public ResponseEntity<Job> updateJob(
            @PathVariable long id,
            @RequestBody Job theJob) {

        Job job1 = jobService.save(theJob);

        return new ResponseEntity<Job>(theJob, HttpStatus.OK);
    }

    @PostMapping("/hibernate/createjob")
    public ResponseEntity<Void> createJob(@RequestBody Job theJob) {

        Job createdJob = jobService.save(theJob);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand((createdJob.getId())).toUri();

        return  ResponseEntity.created(uri).build();
    }
}
