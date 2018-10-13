<%--
  Created by IntelliJ IDEA.
  User: U65483
  Date: 10/13/2018
  Time: 11:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Lucene Search Engine</title>
    <link rel="stylesheet" href="assets/css/style.css">
  </head>
  <body>
  <div class="w3-container w3-display-middle w3-light-grey" style="text-align: center;">
    <%--<h1>Searcher</h1>--%>
    <form action="Searcher" method="POST">
      <p>
        <br><br><br>
        <img src="lucene.png" alt=""> <br>
        <input style ="width: 550px;height: 30px;border: 1px solid #3492F7;margin:20px auto;
				display:block;"type="text" name="search">
        <br>
        <button class="button"><span> Search </span></button>
      <br>
      </p>
    </form>
  </div>
  </body>
</html>
