<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<h1>Edit Event</h1>
<form:form action="/event/${event.id}" method="post" modelAttribute="event">
    <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="title">Title</form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="date">Date</form:label>
        <form:errors path="date"/>
        <form:textarea path="date"/>
    </p>
    <p>
        <form:label path="location">Location</form:label>
        <form:errors path="location"/>
        <form:input path="location"/>
    </p>
    <p>
        <form:label path="host">Host</form:label>
        <form:errors path="host"/>     
        <form:input path="host"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>
