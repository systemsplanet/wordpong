<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:useActionBean id="bean" beanclass="com.wordpong.app.action.game.TheirTurnGameInviteActionBean"/>
<fmt:message var="submitLbl" key="submit" />
<fmt:message var="backLbl" key="back" />
<fmt:message var="cancelInviteLbl" key="theirTurnGameInvite.cancelInvite" />
<fmt:message var="gameInviteeLbl" key="theirTurnGameInvite.gameInvitee" />

<s:form id="friendInviteForm" beanclass="com.wordpong.app.action.game.TheirTurnGameInviteActionBean" method="post">
    <div data-role="header"  data-nobackbtn="true" data-theme="b">
        <!-- Back Button -->
        <div style="float:left;margin-left:10px">
            <div data-theme="a" class="ui-btn ui-btn-up-a ui-btn-icon-left ui-btn-corner-all ui-shadow">
                <span class="ui-btn-inner ui-btn-corner-all">
                   <span class="ui-btn-text">${backLbl}</span>
                   <span class="ui-icon ui-icon-arrow-l ui-icon-shadow"></span>
                </span>
                <input name="back" value="${backLbl}" data-theme="a" class="process ui-btn-left  ui-btn-hidden" data-icon="arrow-l" type="submit">
            </div> 
        </div>
    </div>
    <div style="clear:both"></div>
	<div data-role="content" style="padding-top:0px;">
		<tags:messages/> 
		<ul data-role="listview" data-inset="true" data-theme="c" data-dividertheme="b" style="margin-top:0px;">
			<li data-role="list-divider" ><s:label for="theirTurnGameInvite.title"/></li> 
			<li>
				<div data-role="fieldcontain" style="padding:4px;">
					${gameInviteeLbl}: ${actionBean.inviteGame.inviteeDetails}
				</div>
			</li>
		</ul>
		<div style="float:right">
			<input action="withdrawInvitation" name="withdrawInvitation" data-theme="a" class="process" value="${cancelInviteLbl}" type="submit" />
		</div>	
	</div>
	<s:hidden name="inviteGameKeyStringEncrypted" value="${inviteGame.keyStringEncrypted}" />			 
</s:form>   
<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
<script>
wpFooterFile = "theirTurnGameInvite"
</script>
