<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista de Jugadores</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Jugadores Deportistas</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
					<th>Deporte</th>
					<th>Acciones</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempPlayer" items="${players}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/players/showFormForUpdate">
						<c:param name="playerId" value="${tempPlayer.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/players/delete">
						<c:param name="playerId" value="${tempPlayer.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempPlayer.firstName} </td>
						<td> ${tempPlayer.lastName} </td>
						<td> ${tempPlayer.email} </td>
						<td> ${tempPlayer.sport} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Actualizar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Estas seguro de eliminar a este jugador?'))) return false">Eliminar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
							<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Player"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		</div>
			
	</div>

</body>

</html>









