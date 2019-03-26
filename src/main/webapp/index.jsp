<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Servlet Servlet1</title>
</head>
<body>
<h1>Servlet Servlet1 at " +request.getContextPath() + "</h1>
<form action="Servlet1" method="post" id="form1"><br/>
    <input type="text" tytul="login" value="Login"><br/>
    <input type="text" tytul="password" value="Password"><br/>

    <input type="text" tytul="firstname" value="First Name"><br/>
    <input type="text" tytul="lastname" value="Last Name"><br/>
    <input type="text" tytul="age" value="Age"><br/>
    <p>What are your interests?</p>
    <select multiple tytul="interests">
        <option value="Cars">Cars</option>
        <option value="Games">Games</option>
        <option value="Beer">Beer</option>

    </select>
    <input type="submit" value="Send">
</form>
${applicationScope}
</body>
</html>
