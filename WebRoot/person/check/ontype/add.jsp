<%@ page language="java" pageEncoding="gbk"%>
<%@ include file="/tool/common/taglib.jsp"%> 
<html:html lang="true">
<head>
	<html:base /> 
	<script src="../../../tool/js/pub.js"></script> 
	<link rel="stylesheet" type="text/css" href="../../../tool/styles/main.css">	
	
</head>		
	<body>		
		<html:form  action="/check" onsubmit="return check_form(this)">
		<html:hidden property="jobname" value="ontype"/>
		<nested:nest property="check">	
		<nested:hidden property="c_jobnm" value="add"></nested:hidden> 		 
		<nested:hidden property="c_no" value="1"></nested:hidden> 		
		<table width="100%" border="1" cellspacing="0">
			<tr>
				<td height="33" colspan="3" background="../../../tool/images/113.gif">
					<div align="left">
						<img src="../../../tool/images/112.gif" width="16" height="15" />
						考勤项目添加
					</div>
				</td>
			</tr> 				 
			<tr>
				<td width="48%"><div align="right">名称</div></td>
				<td width="52%" >
				<div align="left">
					<nested:text property="c_name" value="" styleId="req" title="名称不能为空 "></nested:text>
				</div>
				</td>
			</tr> 
			<tr>
				<td width="48%"><div align="right">代码</div></td>
				<td width="52%" >
				<div align="left">
					<nested:text property="c_code" value="" size="3" styleId="req" title="代码不能为空 " maxlength="1"></nested:text>
				</div>
				</td>
			</tr> 
			<tr>
				<td width="48%"><div align="right">标记</div></td>
				<td width="52%" >
				<div align="left">
					<nested:select property="c_state"  >
					<html:option value="0">正常状态</html:option>
					<html:option value="1">扣款状态</html:option>
					</nested:select>
				</div>
				</td>
			</tr> 			 
			</nested:nest>		
			<tr>
				<td width="48%" align="right"><html:submit value="确 定"/></td>
				<td width="52%" colspan="2">
					<html:reset  value="取 消" />
				</td> 
			</tr>		
		</table>	
	</html:form> 
	</body> 
</html:html>
