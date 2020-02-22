<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
	<html>
		<body>
			<h1>Authors</h1>
			<table border="1">
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Address</th>
					<th>Mobile</th>
				</tr>
				
				<xsl:for-each select="database/authors/author">
				<tr>
					<td><xsl:value-of select="id" /></td>
					<td><xsl:value-of select="firstname" /></td>
					<td><xsl:value-of select="lastname" /></td>
					<td><xsl:value-of select="address" /></td>
					<td><xsl:value-of select="mobile" /></td>
				</tr>
				</xsl:for-each>
			</table>
			
			<h1>Publications</h1>
			<table border="1">
				<tr>
					<th>ID</th>
					<th>Type</th>
					<th>Name</th>
					<th>Year</th>
					<th>ISBN</th>
					<th>URL</th>
					<th>Citations</th>
				</tr>
				
				<xsl:for-each select="database/publications/publication">
				<tr>
					<td><xsl:value-of select="id" /></td>
					<td><xsl:value-of select="type" /></td>
					<td><xsl:value-of select="name" /></td>
					<td><xsl:value-of select="year" /></td>
					<td><xsl:value-of select="ISBN" /></td>
					<td><xsl:value-of select="URL" /></td>
					<td><xsl:value-of select="citations" /></td>
				</tr>
				</xsl:for-each>
			</table>
			
			<h1>Departments</h1>
			<table border="1">
				<tr>
					<th>ID</th>
					<th>Name</th>
				</tr>
				
				<xsl:for-each select="database/departments/department">
				<tr>
					<td><xsl:value-of select="id" /></td>
					<td><xsl:value-of select="name" /></td>

				</tr>
				</xsl:for-each>
			</table>
		</body>
	</html>
	</xsl:template>

</xsl:stylesheet>