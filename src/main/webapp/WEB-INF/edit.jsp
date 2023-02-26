<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Burger Tracker 1</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/darkly.css" />
    <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
    <!-- change to match your file/naming structure -->
  </head>
  <body>
    <div class="container m-5">
      <div class="card mt-5">
        <div class="card-header d-flex justify-content-between">
          <h1>Edit Burger</h1>
          <a href="/">Go Back</a>
        </div>
        <div class="card-body">
          <form:form action="/burgers" method="post" modelAttribute="burger" class="form-control mb-3">
            <form:label class="form-label" path="burgerName"><h4>Burger Name</h4></form:label>
            <form:errors path="burgerName" style="color:red"/>
            <form:input path="burgerName" type="text" class="form-control mb-3" />
            <form:label class="form-label" path="restaurantName"><h4>Restaurant Name</h4></form:label>
            <form:errors path="restaurantName" style="color:red"/>
            <form:input path="restaurantName" type="text" class="form-control mb-3" />
            <form:label class="form-label" path="rating"><h4>Rating (Out of 5)</h4></form:label>
            <form:errors path="rating" style="color:red"/>
            
            <form:input path="rating" type="number" min="1" max="5" class="form-control mb-3" />
            <form:label class="form-label" path="notes"><h4>Notes</h4></form:label>
            <form:errors path="notes" style="color:red"/>
            <form:textarea path="notes" type="text" rows="5" class="form-control mb-3" />
            <div class="d-flex justify-content-end">
              <button class="btn btn-primary m-3" type="submit">
                Submit
              </button>
            </div>
          </form:form>
        </div>
      </div>
    </div>
  </body>
</html>
