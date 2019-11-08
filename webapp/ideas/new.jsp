<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<h1>New Event</h1>
<form:form action="/event/new" method="post" modelAttribute="event">
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
    <input type="submit" value="Submit"/>
</form:form>    
