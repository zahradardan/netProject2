package ir.asta.training.contacts.services.impl;
import ir.asta.training.contacts.entities.Case;
import ir.asta.training.contacts.manager.CaseManager;
import ir.asta.training.contacts.services.CaseService;
import ir.asta.wise.core.datamanagement.ActionResult;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Context;
import java.io.IOException;
import java.util.List;

@Named("caseServiceImpl")
public class CaseServiceImpl implements CaseService {

    @Inject
    private CaseManager manager;

    @Context
    public HttpServletRequest request;
    @Context
    public HttpServletResponse response;


    @Override
    public ActionResult<Case> create( String topic, String refer,  String description ,String username) throws ServletException, IOException {
        return  manager.save(topic,refer,description,username);
    }

    @Override
    public ActionResult<List<Case>> getUserCases( String username) {
        return manager.getUserCases(username);
    }

    @Override
    public ActionResult<Case> getCase(String id) {
        return manager.getCase(id);
    }

    @Override
    public ActionResult<List<Case>> filterCases( String username, boolean userType) {
        return manager.filterCases(username,userType);
    }

    @Override
    public ActionResult<List<Case>> filtering( String status,String submitter,String responsible) {
        return manager.filtering(status,submitter,responsible);
    }

    @Override
    public ActionResult<Case> updateRefer(String id,  String refer) {
        return manager.updateRefer(id,refer);
    }

    @Override
    public ActionResult<Case> action(String id,String status) {
            return manager.action(id,status);

    }
}
