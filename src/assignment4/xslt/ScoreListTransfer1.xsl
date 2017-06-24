<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:tns="http://jw.nju.edu.cn/schema">

	<xsl:output method="xml" indent="yes" xmlns:xslt="http://xml.apache.org/xslt"
		xslt:indent-amount="4" />


	<xsl:template match="/">
		<xsl:element name="tns:CourseScoreList">
			<xsl:for-each-group select="//tns:CourseScore" group-by="@CourseNo|@ScoreType">
				<xsl:sort select="@CourseNo" order="ascending" />
				<xsl:sort select="@ScoreType" order="ascending" />

				<xsl:element name="tns:CourseScore">
					<xsl:attribute name="CourseNo"> <xsl:value-of
						select="./@CourseNo" /> </xsl:attribute>
					<xsl:attribute name="ScoreType"> <xsl:value-of
						select="./@ScoreType" /> </xsl:attribute>

					<xsl:element name="tns:成绩">
						<xsl:for-each select="tns:成绩">
							<xsl:sort select="tns:Score/tns:Real成绩" />
							<xsl:element name="tns:StudentNo">
								<xsl:value-of select="tns:StudentNo"></xsl:value-of>
							</xsl:element>
							<xsl:element name="tns:Real成绩">
								<xsl:value-of select="tns:Real成绩"></xsl:value-of>
							</xsl:element>
						</xsl:for-each>
					</xsl:element>
				</xsl:element>
			</xsl:for-each-group>

		</xsl:element>
	</xsl:template>

</xsl:stylesheet>

<!-- <xsl:for-each select="//tns:CourseScoreList/tns:CourseScore"> <xsl:sort select="@CourseNo"></xsl:sort> 
	<xsl:sort select="@ScoreType"></xsl:sort> <xsl:sort select="tns:Score/tns:Real成绩"></xsl:sort> 
	<xsl:element name="tns:CourseScore"> <xsl:attribute name="CourseNo"> <xsl:value-of select="./@CourseNo" 
	/> </xsl:attribute> <xsl:attribute name="ScoreType"> <xsl:value-of select="./@ScoreType" 
	/> </xsl:attribute> <xsl:element name="tns:成绩"> <xsl:for-each select="tns:成绩"> 
	<xsl:element name="tns:StudentNo"> <xsl:value-of select="tns:StudentNo"></xsl:value-of> 
	</xsl:element> <xsl:element name="tns:Real成绩"> <xsl:value-of select="tns:Real成绩"></xsl:value-of> 
	</xsl:element> </xsl:for-each> </xsl:element> </xsl:element> </xsl:for-each> -->