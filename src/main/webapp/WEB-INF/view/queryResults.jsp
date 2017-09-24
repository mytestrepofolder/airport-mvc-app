<%@include file="common/header.jspf" %>
	<div  class="container">	
	<h1> Airports and Runway based on Country : </h1>
		
	 	<c:forEach items="${queryOutput}" var="var">
	 	 <h3>AIRPORT (${var.airport.name})</h3>
	 	 <br>	
	 	 <table class="table table-striped table-bordered" >
	 	 	 <tr>
				<th nowrap>ID</th>
				<th nowrap>IDENT</th>
				<th nowrap>TYPE</th>
				<th nowrap>NAME</th>
				<th nowrap>LATITUDE DEG</th>
				<th nowrap>LONGITUDE DEG</th>
				<th nowrap>ELEVATION</th>
				<th nowrap>CONTINENT</th>
				<th nowrap>ISO COUNTRY</th>
				<th nowrap>ISO REGION</th>
				<th nowrap>MUNICIPALITY</th>
				<th nowrap>SCHEDULED SERVICE</th>
				<th>GPS CODE</th>
				<th nowrap>IATA CODE</th>
				<th nowrap>LOCAL CODE</th>
				<th nowrap>HOME LINK</th>
				<th nowrap colspan="2">WIKI LINK</th>
				<th nowrap>KEYWORDS</th>
			 </tr>
	 	 	 <tr>
	 	 	 	<td>${var.airport.id}</td>
		 		<td>${var.airport.ident}</td>
		 		<td>${var.airport.type}</td>
		 		<td>${var.airport.name}</td>
		 		<td>${var.airport.latitute_deg}</td>
		 		<td>${var.airport.longitude_deg}</td>
		 		<td>${var.airport.elevation_ft}</td>
		 		<td>${var.airport.continent}</td>
		 		<td>${var.airport.iso_country}</td>
		 		<td>${var.airport.iso_region}</td>
		 		<td>${var.airport.municipality}</td>
		 		<td>${var.airport.scheduled_service}</td>
		 		<td>${var.airport.gps_code}</td>
		 		<td>${var.airport.iata_code}</td>
		 		<td>${var.airport.local_code}</td>
				<td>${var.airport.home_link}</td>
				<td>${var.airport.keywords}</td>
				<td colspan="2">${var.airport.wikipedia_link}</td>				
	 	 	 </tr>
	 	 	 
	 	 </table>
	 	 <h4>List of Runways for "${var.airport.name}" are :</h4>
	 	  <table class="table table-striped table-bordered" >
	 	  		<tr>
					<th nowrap>ID</th>
					<th nowrap>AIRPORT REF</th>
					<th nowrap>AIRPORT INDENT</th>
					<th nowrap>LENGTH</th>
					<th nowrap>WIDTH</th>
					<th nowrap>SURFACE</th>
					<th nowrap>LIGHTED</th>
					<th nowrap>CLOSED</th>
					<th nowrap>LE INDENT</th>
					<th nowrap>LE LATITUDE DEG</th>
					<th nowrap>LE LOGITUDE DEC</th>
					<th nowrap>LE ELEVATION FT</th>
					<th nowrap>LE HEADING FT</th>
					<th nowrap>LE DISPLACED THRESHOLD FT</th>
					<th nowrap>HE INDENT</th>
					<th nowrap>HE LATITUDE FT</th>
					<th nowrap>HE LONGITUDE FT</th>
					<th nowrap>HE ELEVATION</th>
					<th nowrap>HE HEADING</th>
					<th nowrap>HE DISPLACED TRESHOLD FT</th>
			 </tr>
			 <c:forEach items="${var.runways}" var="runway">
				 <tr>
					<td>${runway.id}</td>
					<td>${runway.airport_ref}</td>
					<td>${runway.airport_ident}</td>
					<td>${runway.length_ft}</td>
					<td>${runway.width_ft}</td>
					<td>${runway.surface}</td>
					<td>${runway.lighted}</td>
					<td>${runway.closed}</td>
					<td>${runway.le_ident}</td>
					<td>${runway.le_latitude_deg}</td>
					<td>${runway.le_longitude_deg}</td>
					<td>${runway.le_elevation_ft}</td>
					<td>${runway.le_heading_degT}</td>
					<td>${runway.le_displaced_threshold_ft}</td>
					<td>${runway.he_ident}</td>
					<td>${runway.he_latitude_deg}</td>
					<td>${runway.he_longitude_deg}</td>
					<td>${runway.he_elevation_ft}</td>
					<td>${runway.he_heading_degT}</td>
					<td>${runway.he_displaced_threshold_ft}</td>
				 </tr>	
		 	   </c:forEach>	
	 	  </table>
	 	 <br>	 	 
	 </c:forEach>
  </div>
<%@include file="common/footer.jspf" %>