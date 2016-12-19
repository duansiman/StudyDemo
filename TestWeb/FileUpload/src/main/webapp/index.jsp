<%@ page contentType="text/html;charset=utf-8"%>
<html>
<body>
    <h2>Hello World!</h2>
    <form method="post" action="/upload" enctype="multipart/form-data">
        <input type="text" value="输入文件名" name="filename"/><input type="file" name="file"/><br/><br/>
        <input type="submit"/><br/>
    </form>
</body>
</html>
