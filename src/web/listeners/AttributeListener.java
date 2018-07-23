package web.listeners;

import org.apache.log4j.Logger;
import web.handlers.RequestHandler;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class AttributeListener implements HttpSessionAttributeListener {
    private static final Logger logger = Logger.getLogger(AttributeListener.class.getName());
    public void attributeAdded(HttpSessionBindingEvent ev) {
        String currentAttributeName = ev.getName();
        logger.info(ev.getSession().getAttribute("user") + " added new attribute " + currentAttributeName.toString());
    }

    public void attributeRemoved(HttpSessionBindingEvent ev) {
    }

    public void attributeReplaced(HttpSessionBindingEvent ev) {

    }
}