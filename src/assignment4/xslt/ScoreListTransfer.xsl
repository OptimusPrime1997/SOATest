<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<xsl:element name="课程成绩列表" namespace="http://jw.nju.edu.cn/schema">
			<xsl:apply-templates select="//课程">
			</xsl:apply-templates>
		</xsl:element>
	</xsl:template>

	<xsl:template match="课程">
		<xsl:apply-templates select="课程成绩"></xsl:apply-templates>
	</xsl:template>

	<xsl:template match="课程成绩">
		<xsl:element name="课程成绩">
			<xsl:attribute name="课程编号">
				<xsl:value-of select="../@课程编号" />
			</xsl:attribute>
			<xsl:attribute name="成绩性质">
				<xsl:value-of select="./@成绩性质" />
			</xsl:attribute>

			<xsl:for-each select="成绩">
				<xsl:sort select="得分"></xsl:sort>
				<xsl:element name="成绩">
					<xsl:element name="学号">
						<xsl:value-of select="学号"></xsl:value-of>
					</xsl:element>
					<xsl:element name="得分">
						<xsl:value-of select="得分"></xsl:value-of>
					</xsl:element>
				</xsl:element>
			</xsl:for-each>
		</xsl:element>
	</xsl:template>


</xsl:stylesheet>

<!-- <html> <body> <h2>My CD Collection</h2> <table border="1"> <tr bgcolor="#9acd32"> 
	<th style="text-align:left">Title</th> <th style="text-align:left">Artist</th> 
	</tr> <xsl:for-each select="catalog/cd"> <tr> <td> <xsl:value-of select="title" 
	/> </td> <td> <xsl:value-of select="artist" /> </td> </tr> </xsl:for-each> 
	</table> </body> </html> --> 