<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleServiceConvertisseurEURToJPYProxyid" scope="session" class="eurtojpy.ServiceConvertisseurEURToJPYProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleServiceConvertisseurEURToJPYProxyid.setEndpoint(request.getParameter("endpoint"));
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
        String getEndpoint2mtemp = sampleServiceConvertisseurEURToJPYProxyid.getEndpoint();
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
        sampleServiceConvertisseurEURToJPYProxyid.setEndpoint(String_0id);
break;
case 10:
        gotMethod = true;
        eurtojpy.ServiceConvertisseurEURToJPY getServiceConvertisseurEURToJPY10mtemp = sampleServiceConvertisseurEURToJPYProxyid.getServiceConvertisseurEURToJPY();
if(getServiceConvertisseurEURToJPY10mtemp == null){
%>
<%=getServiceConvertisseurEURToJPY10mtemp %>
<%
}else{
        if(getServiceConvertisseurEURToJPY10mtemp!= null){
        String tempreturnp11 = getServiceConvertisseurEURToJPY10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String eur_1id=  request.getParameter("eur16");
        double eur_1idTemp  = Double.parseDouble(eur_1id);
        double convert13mtemp = sampleServiceConvertisseurEURToJPYProxyid.convert(eur_1idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(convert13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
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