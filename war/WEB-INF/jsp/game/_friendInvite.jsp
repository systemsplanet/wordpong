<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:useActionBean id="bean" beanclass="com.wordpong.app.action.game.FriendInviteActionBean"/>
<fmt:message var="submitLbl" key="submit" />
<fmt:message var="backLbl" key="back" />
<fmt:message var="emailLbl" key="email" />


<div data-role="header"  data-nobackbtn="true" data-theme="b">
    <!-- Back Button -->
    <div style="float:left;margin-left:10px">
        <div data-theme="a" class="ui-btn ui-btn-up-a ui-btn-icon-left ui-btn-corner-all ui-shadow">
            <span class="ui-btn-inner ui-btn-corner-all">
               <span class="ui-btn-text">${backLbl}</span>
               <span class="ui-icon ui-icon-arrow-l ui-icon-shadow"></span>
            </span>
			<s:form id="friendInviteForm" beanclass="com.wordpong.app.action.game.FriendInviteActionBean" method="post">
            	<input name="back" value="${backLbl}" data-theme="a" class="process ui-btn-left  ui-btn-hidden" data-icon="arrow-l" type="submit">
			</s:form>   
        </div> 
    </div>
</div>
<div style="clear:both"></div>
<div data-role="content" style="padding-top:0px; ">
	<ul data-role="listview" data-inset="true" data-theme="c" data-dividertheme="b" style="margin-top:0px;">
		<li data-role="list-divider" ><s:label for="friendInvite.title"/></li> 
	</ul>
	<tags:messages/> 
	<s:form id="friendInviteForm" beanclass="com.wordpong.app.action.game.FriendInviteActionBean" method="post">
		<div data-role="fieldcontain">
    		<label for="email">${emailLbl}</label>
    		<input type="text" name="email" id="email" value=""  tabindex="1" />
		</div>	
			
		<div style="float:right">
			<input name="invite" id="invite" data-theme="a" class="process" value="${submitLbl}" type="submit" />
		</div>	
	</s:form>   
</div>
<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
<script>
wpFooterFile = "friendInvite"
</script>
