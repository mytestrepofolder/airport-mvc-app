<%@include file="common/header.jspf" %>
	<div>
		<h1>This is the Reports page : </h1> <br>
		
		<h3>Top 10 List of countries with Max Airports :</h3>
		<table class="table table-bodered table-striped table-condensed">
			<tr>
				<th>Country Name</th>
				<th>Number of Airports</th>		
			</tr>
			<c:forEach items="${tenCountriesWithMaxAirports}" var="var">
			<tr>
				<td>${var.key.name}</td>
				<td>${var.value}</td>
			</tr>
		</c:forEach>	
		</table>
		<br>
		<h3>Types of most used runways for these countries :</h3>
		<table class="table table-bodered table-striped table-condensed">
			<c:forEach items="${typeOfRunwaysPerCountry}" var="var">
			<tr>
				<td nowrap>${var.countryName}</td>
				<td>
					<table>
						<tr>
							<td> 
							<c:forEach items="${var.runwayTypes}" var="runway">						
								${runway}
							</c:forEach>
							</td>
						<tr>
					</table>
				<td>
			</tr>
		</c:forEach>	
		</table>		
		<br>
		<h3>Top 10 List of countries with Least Airports :</h3>
		<table class="table table-bodered table-striped table-condensed">
			<tr>
				<th>Country Name</th>
				<th>Number of Airports</th>		
			</tr>
			<c:forEach items="${tenCountriesWithLeastAirports}" var="var">
			<tr>
				<td>${var.key.name}</td>
				<td>${var.value}</td>
			</tr>
		</c:forEach>	
		</table>
		<br>	
	</div>
<%@include file="common/footer.jspf" %>