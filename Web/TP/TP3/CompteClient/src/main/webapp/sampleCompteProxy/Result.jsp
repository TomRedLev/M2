<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleCompteProxyid" scope="session" class="DefaultNamespace.CompteProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleCompteProxyid.setEndpoint(request.getParameter("endpoint"));
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
        String getEndpoint2mtemp = sampleCompteProxyid.getEndpoint();
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
        <jsp:useBean id="String_0id" scope="session" class="java.lang.String" />
        <%
        sampleCompteProxyid.setEndpoint(String_0id);
break;
case 10:
        gotMethod = true;
        DefaultNamespace.Compte getCompte10mtemp = sampleCompteProxyid.getCompte();
if(getCompte10mtemp == null){
%>
<%=getCompte10mtemp %>
<%
}else{
        if(getCompte10mtemp!= null){
        String tempreturnp11 = getCompte10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String montant_1id=  request.getParameter("montant16");
        int montant_1idTemp  = Integer.parseInt(montant_1id);
        sampleCompteProxyid.retraitDe(montant_1idTemp);
break;
case 18:
        gotMethod = true;
        int valeurDuSolde18mtemp = sampleCompteProxyid.valeurDuSolde();
        String tempResultreturnp19 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(valeurDuSolde18mtemp));
        %>
        <%= tempResultreturnp19 %>
        <%
break;
case 21:
        gotMethod = true;
        String montant_2id=  request.getParameter("montant24");
        int montant_2idTemp  = Integer.parseInt(montant_2id);
        sampleCompteProxyid.depotDe(montant_2idTemp);
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