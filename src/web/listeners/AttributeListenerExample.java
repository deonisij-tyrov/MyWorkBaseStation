package web.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class AttributeListenerExample implements HttpSessionAttributeListener {

    public void attributeAdded(HttpSessionBindingEvent ev) {
        String currentAttributeName = ev.getName();
        System.out.println(ev.getSession().getAttribute("user") +" added new attribute " + currentAttributeName.toString());//log4j
    }

    public void attributeRemoved(HttpSessionBindingEvent ev) {
    }

    public void attributeReplaced(HttpSessionBindingEvent ev) {

    }
}