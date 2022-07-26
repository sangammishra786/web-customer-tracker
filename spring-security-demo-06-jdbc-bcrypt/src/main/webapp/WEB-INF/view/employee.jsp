
<!Doctype html>
<html>

<head>
<title>Luv2code Leaders Home Page</title>

<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
	
	<script>
	function backToHome(){
		window.history.back();
	}
	
	</script>

</head>

<body>
	<h3>List of Employee in Company</h3>
	<hr>
	<br>

	<!-- Add the employee detail in table -->

	<table>
		<tr>
			<th>Company</th>
			<th>Contact</th>
			<th>Country</th>
		</tr>
		<tr>
			<td>Alfreds Futterkiste</td>
			<td>Maria Anders</td>
			<td>Germany</td>
		</tr>
		<tr>
			<td>Centro comercial Moctezuma</td>
			<td>Francisco Chang</td>
			<td>Mexico</td>
		</tr>
		<tr>
			<td>Ernst Handel</td>
			<td>Roland Mendel</td>
			<td>Austria</td>
		</tr>
		<tr>
			<td>Island Trading</td>
			<td>Helen Bennett</td>
			<td>UK</td>
		</tr>
		<tr>
			<td>Laughing Bacchus Winecellars</td>
			<td>Yoshi Tannamuri</td>
			<td>Canada</td>
		</tr>
		<tr>
			<td>Magazzini Alimentari Riuniti</td>
			<td>Giovanni Rovelli</td>
			<td>Italy</td>
		</tr>
	</table>

	<br>
	<br>
	<%-- <a href="${pageContext.request.contextPath}/">Back to Home Page</a> --%>
	<input type="submit" value="Back to Home" onclick="backToHome();" />
	
</body>
</html>