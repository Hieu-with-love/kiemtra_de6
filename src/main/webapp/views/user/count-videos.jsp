<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/12/2024
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/views/taglibs.jsp"%>
<h1>Category Video Count</h1>

<!-- Hiển thị danh sách thể loại và số lượng video -->
<table border="1">
    <thead>
    <tr>
        <th>Category Name</th>
        <th>Video Count</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="category" items="${categories}">
        <tr>
            <td>${category.categoryName}</td>
            <td>${category.videoCount}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>