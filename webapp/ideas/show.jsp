<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<h1><c:out value="${event.title}"/></h1>
<p>Date: <c:out value="${event.date}"/></p>
<p>Location: <c:out value="${event.location}"/></p>
<p>Host: <c:out value="${event.host.email}"/></p>

<h1>Event Wall</h1>
<table>
    <thead>
        <tr>
            <th>Title</th>
            <th>Text</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${messages}" var="event">
        <tr>
            <td><c:out value="${message.title}"/></td>
            <td><c:out value="${message.text}"/></td>
        </tr>   
</c:forEach>
    </tbody>
</table>
<h1>Post Comment</h1>
