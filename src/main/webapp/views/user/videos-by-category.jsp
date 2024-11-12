<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/12/2024
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/views/taglibs.jsp"%>
<h1>Videos by Category</h1>

<!-- Form chọn thể loại -->
<form action="${pageContext.request.contextPath}/videos" method="get">
    <label for="category">Choose a Category:</label>
    <select name="categoryId" id="category">
        <option value="">Select Category</option>
        <c:forEach var="category" items="${categories}">
            <option value="${category.categoryId}"
                    <c:if test="${category.categoryId == selectedCategoryId}">selected</c:if>>
                    ${category.categoryName}
            </option>
        </c:forEach>
    </select>
    <button type="submit">Submit</button>
</form>

<!-- Hiển thị video theo thể loại -->
<c:if test="${not empty videos}">
    <h2>Videos in Category:
        <c:forEach var="category" items="${categories}">
            <c:if test="${category.categoryId == selectedCategoryId}">
                ${category.categoryName}
            </c:if>
        </c:forEach>
    </h2>
    <ul>
        <c:forEach var="video" items="${videos}">
            <li>
                <h3>${video.title}</h3>
                <p>${video.description}</p>
                <img src="${video.poster}" alt="Poster for ${video.title}" />
                <p>Views: ${video.views}</p>
            </li>
        </c:forEach>
    </ul>
</c:if>
