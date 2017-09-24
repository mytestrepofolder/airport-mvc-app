<%@include file="common/header.jspf" %>
	<div class="container">
	<h1>Search Page</h1>
	<form action="searchname" method="get">
		<h3>
		 Search Name:
		</h3>
	  <table class="table table-bordered table-condensed">
	  <tr>
	  	<td colspan="1">
	    	<input type="text" value="" name="searchNameText" /> 
	    </td>
	    <td colspan="2">
	    	<input type="submit" value="Name Search"  name="Submit" class="btn btn-info"/>
	    </td>
	   <tr>
	  </table>
	</form>

	<form action="searchcode" method="get">
	<h3>
		 Search Code :
	</h3>
	 <table class="table table-bordered table-condensed">
	  <tr>
	  	<td colspan="1">
	  	  <input type="text" value="" name="searchCodeText" />
	    </td>
	    <td colspan="2">
	    	<input type="submit" value="Code Search"  name="Submit" class="btn btn-info"/>
	    </td>
	   <tr>
	  </table>
	</form>
	</div>
<%@include file="common/footer.jspf" %>