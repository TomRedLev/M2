<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleHelloProxyid" scope="session" class="DefaultNamespace.HelloProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleHelloProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        String getEndpoint2mtemp = sampleHelloProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        if(getEndpoint2mtemp!= null){
        String tempreturnp3 = getEndpoint2mtemp.toString();
        %>
        <%=tempreturnp3%>
        <%
        }}
break;
case 5:
        gotMethod = true;
        %>
        <jsp:useBean id="String_0id" scope="session" class="String" />
        <%
        sampleHelloProxyid.setEndpoint(String_0id);
break;
case 10:
        gotMethod = true;
        DefaultNamespace.Hello getHello10mtemp = sampleHelloProxyid.getHello();
if(getHello10mtemp == null){
%>
<%=getHello10mtemp %>
<%
}else{
        if(getHello10mtemp!= null){
        String tempreturnp11 = getHello10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String name_1id=  request.getParameter("name16");
            java.lang.String name_1idTemp = null;
        if(!name_1id.equals("")){
         name_1idTemp  = name_1id;
        }
        java.lang.String sayHello13mtemp = sampleHelloProxyid.sayHello(name_1idTemp);
if(sayHello13mtemp == null){
%>
<%=sayHello13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(sayHello13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>