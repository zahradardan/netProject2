package ir.asta.training.contacts.services.impl;

import ir.asta.training.contacts.entities.CaseEntity;
import ir.asta.training.contacts.manager.CaseManager;
import ir.asta.training.contacts.services.CaseService;
import ir.asta.wise.core.datamanagement.ActionResult;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import java.io.IOException;
import java.util.Date;

@Named("caseServiceImpl")
public class CaseServiceImpl implements CaseService {

    @Inject
    private CaseManager manager;

    @Context
    public HttpServletRequest request;
    @Context
    public HttpServletResponse response;


    @Override
    public ActionResult save( String topic, String refer, String description) throws ServletException, IOException {
        CaseEntity entity = new CaseEntity();
        entity.setSubmitter("default");
        entity.setTopic(topic);
        entity.setDescription(description);
        entity.setRefer(refer);
        entity.setStatus("باز");
        entity.setDate(new Date().toString());
        manager.save(entity);
//        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Cartable.html");
//        dispatcher.forward(request, response);
        return new ActionResult<CaseEntity>(true,"مورد با موفقیت ثبت شد .",entity);
    }
}
