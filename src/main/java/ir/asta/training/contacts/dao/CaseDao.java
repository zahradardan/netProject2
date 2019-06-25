package ir.asta.training.contacts.dao;

import ir.asta.training.contacts.entities.Case;
import ir.asta.training.contacts.entities.CaseEntity;
import ir.asta.training.contacts.entities.UserEntity;
import ir.asta.wise.core.datamanagement.ActionResult;
import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Named("caseDao")
public class CaseDao {
    @PersistenceContext
    private EntityManager entityManager;

    public Case save(String topic, String refer, String description, String username) {
        Case entity = new Case();
        entity.setSubmitter(username);
        entity.setTopic(topic);
        entity.setDescription(description);
        entity.setRefer(refer);
        entity.setStatus("باز");
        entity.setDate(new Date().toString());
        entityManager.persist(entity);
        return entity;
    }

    public ActionResult<List<Case>> getUserCases(String username) {
        Query query = entityManager.createQuery("select c from Case c where c.refer =:username");
        query.setParameter("username", username);
        List<Case> list = query.getResultList();
        ActionResult<List<Case>> actionResult = new ActionResult<>();
        if (list.size() > 0) {
            actionResult.setMessage("True");
            actionResult.setSuccess(true);
        } else {
            actionResult.setMessage("false");
            actionResult.setSuccess(false);
        }

        actionResult.setData(list);
        return actionResult;
    }

    public ActionResult<Case> getCase(String id) {
        long ID = Long.parseLong(id);
        Query query = entityManager.createQuery("select c from Case c where c.id =:ID");
        query.setParameter("ID", ID);
        List<Case> list = query.getResultList();
        ActionResult<Case> actionResult = new ActionResult<>();
        if (list.size() > 0) {
            actionResult.setMessage("True");
            actionResult.setSuccess(true);
            actionResult.setData(list.get(0));
        } else {
            actionResult.setMessage("False");
            actionResult.setSuccess(false);
            actionResult.setData(null);
        }
        return actionResult;
    }

    public ActionResult<List<Case>> filterCases(String username, boolean userType) {
        Query query;
        if (userType)
            query = entityManager.createQuery("select c from Case c");
        else {
            query = entityManager.createQuery("select c from Case c where c.submitter =:username");
            query.setParameter("username", username);
        }
        ActionResult<List<Case>> actionResult = new ActionResult<>();
        List<Case> list = query.getResultList();
        if (list.size() > 0) {
            actionResult.setMessage("True");
            actionResult.setSuccess(true);
            actionResult.setData(list);
        } else {
            actionResult.setMessage("False");
            actionResult.setSuccess(false);
            actionResult.setData(null);
        }
        return actionResult;
    }

    public ActionResult<List<Case>> filtering(String status, String submitter, String responsible) {
        String string = "select c from Case c ";
        boolean[] filter = new boolean[3];
        boolean filtering = false;
        if (!status.equals("بدون فیلتر")) {
            filter[0] = true;
            filtering = true;
            string += "where c.status = :status ";
        }
        if (!submitter.equals("بدون فیلتر")) {
            filter[1] = true;
            if (!filtering)
                string += "where c.submitter = :submitter ";
            else
                string += "and c.submitter = :submitter ";
            filtering = true;
        }
        if (!responsible.equals("بدون فیلتر")) {
            filter[2] = true;
            if (!filtering)
                string += "where c.refer = :responsible ";
            else
                string += "and c.refer = :responsible ";
        }

        Query query = entityManager.createQuery(string);
        if (filter[0])
            query.setParameter("status", status);
        if (filter[1])
            query.setParameter("submitter", submitter);
        if (filter[2])
            query.setParameter("responsible", responsible);

        List<Case> list = query.getResultList();
        ActionResult<List<Case>> actionResult = new ActionResult<>();
        if (list.size() > 0) {
            actionResult.setMessage("True");
            actionResult.setSuccess(true);
        } else {
            actionResult.setMessage("false");
            actionResult.setSuccess(false);
        }

        actionResult.setData(list);
        return actionResult;
    }

    @Transactional
    public ActionResult<Case> updateRefer(String id, String refer) {
        long ID = Long.parseLong(id);
        Query query = entityManager.createQuery("select c from Case c where c.id =:ID");
        query.setParameter("ID", ID);
        Case entity=(Case)query.getResultList().get(0);
        entity.setRefer(refer);
        entityManager.merge(entity);
        return new ActionResult<Case>(true,"مورد "+ID+" به کاربر "+refer+" ارجاع شد ",entity);
    }


    @Transactional
    public ActionResult<Case> action(String id, String status){
        long ID = Long.parseLong(id);
        Query query = entityManager.createQuery("select c from Case c where c.id =:ID");
        query.setParameter("ID", ID);
        Case entity=(Case)query.getResultList().get(0);
        entity.setStatus(status);
        entityManager.merge(entity);
        return new ActionResult<Case>(true,"مورد "+ID+" به وضعیت "+status+" درآمد ",entity);
    }


}

