package com.learn.demo.Dao;

import com.learn.demo.Entity.Job;
import com.learn.demo.Entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class JobDaoHibernateImpl implements JobDao{

    EntityManager entityManager;

    @Autowired
    public JobDaoHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Job> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Job> theQuery =
                currentSession.createQuery("from Job", Job.class);

        List<Job> jobs = theQuery.getResultList();

        return jobs;
    }

    @Override
    public Job findById(long theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Job> theQuery =
                currentSession.createQuery("from Job where id=:jobId",Job.class);

        theQuery.setParameter("jobId", theId);

        return theQuery.getSingleResult();
    }

    @Override
    public Job save(Job theJob) {

        Session currentSession = entityManager.unwrap(Session.class);

        // Don't work
        //currentSession.saveOrUpdate(theJob);

        // For this work...
        //User user = new User("sss",222,444);
        //currentSession.saveOrUpdate(user);

        if(theJob.getId() == -1) {

            Query theQuery = currentSession
                    .createNativeQuery("insert into Job (`id`,`name`, `describe`, `money`) values (0, :qname, :qdesc, :qpoint)");

            theQuery.setParameter("qpoint", theJob.getMoney());
            theQuery.setParameter("qname", theJob.getName());
            theQuery.setParameter("qdesc", theJob.getDescribe());

            theQuery.executeUpdate();

        } else {

            Query theQuery = currentSession
                    .createNativeQuery("update Job set `name` = :qname, `describe` = :qdesc, `money` = :qpoint where `id` = :qid");

            theQuery.setParameter("qpoint", theJob.getMoney());
            theQuery.setParameter("qname", theJob.getName());
            theQuery.setParameter("qdesc", theJob.getDescribe());
            theQuery.setParameter("qid", theJob.getId());

            theQuery.executeUpdate();

        }


        return theJob;
    }

    @Override
    public void deleteById(long theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery =
                currentSession.createQuery("delete Job where id =: jobId");
        theQuery.setParameter("jobId", theId);

        theQuery.executeUpdate();
    }
}
