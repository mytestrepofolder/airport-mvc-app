<%@include file="common/header.jspf" %>
	<div class="container">
	<h1>
		Airport Application:
	</h1>

	<form action="search" method="get">
	<h3>
	 Click below for Search:
	</h3>
	  <table class="table ">
	  <tr>
	  	<td>
	    	<input type="submit" value="Search"   name="Submit" class="btn btn-info" />
	    </td>
	   <tr>
	  </table>
	</form>
	<br>
	<form action="reports" method="get">
	<h3>
		 Click below for Reports:
	</h3>
	 <table class="table">
	  <tr>
	  	<td>
	  	  <input type="submit" value="Reports" name="Submit" class="btn btn-info"/>
	    </td>
	   <tr>
	  </table>
	</form>
	</div>
</body>
</html>
<%@include file="common/footer.jspf" %>