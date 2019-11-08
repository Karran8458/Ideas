<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<h1>Welcome, <c:out value="${user.email}" /></h1>
<a href="/logout">Logout</a>
<h1>All Events</h1>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Date</th>
            <th>Location</th>
            <th>Host</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${userevents}" var="userevent">
        <tr>
            <td><c:out value="${userevent.title}"/></td>
            <td><c:out value="${userevent.date}"/></td>
            <td><c:out value="${userevent.location}"/></td>
            <td><c:out value="${userevent.host.email}"/></td>
            <td><a href="/event/${userevent.id}/edit">Edit</a><td>
            <td><a href="/event/${userevent.id}">View</a><td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<h1>Other Events</h1>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Date</th>
            <th>Location</th>
            <th>Host</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${events}" var="event">
        <c:if test="${event.host ne user }">
        <tr>
            <td><c:out value="${event.title}"/></td>
            <td><c:out value="${event.date}"/></td>
            <td><c:out value="${event.location}"/></td>
            <td><c:out value="${event.host.email}"/></td>
            <td><a href="/event/${event.id}/edit">Edit</a><td>
            <td><a href="/event/${event.id}">View</a><td>
        </tr>
        </c:if>
        </c:forEach>
    </tbody>
</table>
<a href="/event/new">New Event</a>
