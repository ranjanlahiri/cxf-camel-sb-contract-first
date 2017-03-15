package org.jboss.fis2.demo.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.4
 * 2017-03-15T10:25:14.628Z
 * Generated source version: 3.1.4
 * 
 */
@WebServiceClient(name = "EmployeeWS", 
                  wsdlLocation = "file:/C:/JBoss/JDevStudio/Workspaces/webservice-demo-060317/cxf-camel-sb-contract-first/src/main/resources/META-INF/wsdl/employee.wsdl",
                  targetNamespace = "http://soap.demo.fis2.jboss.org/") 
public class EmployeeWS extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://soap.demo.fis2.jboss.org/", "EmployeeWS");
    public final static QName EmployeeWSPort = new QName("http://soap.demo.fis2.jboss.org/", "EmployeeWSPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/JBoss/JDevStudio/Workspaces/webservice-demo-060317/cxf-camel-sb-contract-first/src/main/resources/META-INF/wsdl/employee.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(EmployeeWS.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/JBoss/JDevStudio/Workspaces/webservice-demo-060317/cxf-camel-sb-contract-first/src/main/resources/META-INF/wsdl/employee.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public EmployeeWS(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public EmployeeWS(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EmployeeWS() {
        super(WSDL_LOCATION, SERVICE);
    }
    




    /**
     *
     * @return
     *     returns EmployeeWSPortType
     */
    @WebEndpoint(name = "EmployeeWSPort")
    public EmployeeWSPortType getEmployeeWSPort() {
        return super.getPort(EmployeeWSPort, EmployeeWSPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EmployeeWSPortType
     */
    @WebEndpoint(name = "EmployeeWSPort")
    public EmployeeWSPortType getEmployeeWSPort(WebServiceFeature... features) {
        return super.getPort(EmployeeWSPort, EmployeeWSPortType.class, features);
    }

}
