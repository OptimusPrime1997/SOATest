<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:tns="http://jw.nju.edu.cn/schema">
	<!-- <xsl:namespace-alias stylesheet-prefix="xsl" result-prefix="#default" 
		/> -->
	<xsl:output method="xml" indent="yes" xmlns:xslt="http://xml.apache.org/xslt"
		xslt:indent-amount="4"  />
	<xsl:template match="/">
		<xsl:element name="tns:CourseScoreList">
			<xsl:for-each select="//tns:CourseScoreList/tns:CourseScore">
			<xsl:sort select="@CourseNo"></xsl:sort>
			<xsl:sort select="@ScoreType"></xsl:sort>
			<xsl:sort select="tns:Score/tns:Real成绩"></xsl:sort>
			
				<xsl:element name="tns:CourseScore">
					<xsl:attribute name="CourseNo"> 
					<xsl:value-of select="./@CourseNo" /> </xsl:attribute>
					<xsl:attribute name="ScoreType">
					 <xsl:value-of select="./@ScoreType" /> 
						</xsl:attribute>
					<xsl:element name="tns:成绩">
						<xsl:for-each select="tns:成绩">
							

							<xsl:element name="tns:StudentNo">
								<xsl:value-of select="tns:StudentNo"></xsl:value-of>
							</xsl:element>
							<xsl:element name="tns:Real成绩">
								<xsl:value-of select="tns:Real成绩"></xsl:value-of>
							</xsl:element>

						</xsl:for-each>
					</xsl:element>
				</xsl:element>
			</xsl:for-each>

		</xsl:element>
	</xsl:template>
	<!-- <xsl:template match="/"> <xsl:element name="CourseScoreList" namespace="http://jw.nju.edu.cn/schema"> 
		<xsl:apply-templates select="//tns:CourseScore"> </xsl:apply-templates> </xsl:element> 
		</xsl:template> <xsl:template match="tns:CourseScore"> <xsl:element name="CourseScore"> 
		<xsl:attribute name="CourseNo"> <xsl:value-of select="@CourseNo" /> </xsl:attribute> 
		<xsl:attribute name="ScoreType"> <xsl:value-of select="@ScoreType" /> </xsl:attribute> 
		<xsl:for-each select="Score"> <xsl:sort select="tns:Real成绩"></xsl:sort> <xsl:element 
		name="Score"> <xsl:element name="StudentNo"> <xsl:value-of select="StudentNo"></xsl:value-of> 
		</xsl:element> <xsl:element name="tns:Real成绩"> <xsl:value-of select="RealScore"></xsl:value-of> 
		</xsl:element> </xsl:element> </xsl:for-each> </xsl:element> </xsl:template> -->

</xsl:stylesheet>

