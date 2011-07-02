<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:useActionBean id="bean" beanclass="com.wordpong.app.action.game.AnswerAddEditActionBean"/>
<fmt:message var="backLbl" key="back" />
<fmt:message var="enterAnswersLbl" key="answerAddEdit.enterAnswers" />

<div data-role="header"  data-nobackbtn="true" data-theme="b">
<form id="answerAddEditFormHead" action="/game/AnswerAddEdit.wp" method="post">
    <div>
        <!-- Back Button -->
        <span style="float:left;margin-left:10px">
            <div data-theme="a" class="ui-btn ui-btn-up-a ui-btn-icon-left ui-btn-corner-all ui-shadow">
	            <span class="ui-btn-inner ui-btn-corner-all">
	               <span class="ui-btn-text">${backLbl}</span>
    	           <span class="ui-icon ui-icon-arrow-l ui-icon-shadow"></span>
	            </span>
                <input name="back" value="${backLbl}" data-theme="a" class="process ui-btn-left  ui-btn-hidden" data-icon="arrow-l" type="submit">
            </div> 
        </span>
        
    </div>
</form>
<div style="clear:both"></div>

<div data-role="content" style="padding-top:0px;">
	<s:form id="answerAddEditForm" beanclass="com.wordpong.app.action.game.AnswerAddEditActionBean" method="post">
	    <ul data-role="listview" data-inset="true" data-theme="c" data-dividertheme="b"  style="margin-top:0px;">
	        <li data-role="list-divider" >${enterAnswersLbl}: ${actionBean.questionDescription}</li> 
        </ul>
        <tags:messages/> 
	        <small>            
	 	       <c:forEach items="${actionBean.questions}" var="i"  varStatus="s">
		          <div data-role="fieldcontain" style="padding:4px;">
		              <s:label for="answers[${s.index}]" class="ui-input-text">${i}</s:label>		              
		              <sdyn:text name="answers[${s.index}]" id="answers[${s.index}]" tabindex="1" maxlength="100" type="text" class="ui-input-text ui-body-null ui-corner-all ui-shadow-inset ui-body-a"/>
		          </div>
		       </c:forEach>
		       <input id="questionKeyString" name="questionKeyString" type="hidden" value="${actionBean.questionKeyString}"/>
		       <input id="questionDescription" name="questionDescription" type="hidden" value="${actionBean.questionDescription}"/>
		       
	        </small>         
        <div style="float:left">
           <input data-theme="a" class="process ui-btn-left " data-icon='arrow-l' name="back" value="${backLbl}" type="submit" /> 
        </div>
        <div style="float:right">
           <input data-theme="a" class="process ui-btn-left "  name="save" value="SAVE" type="submit" /> 
        </div>
	</s:form>	 
</div>
<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
<script>
wpFooterFile = "answerAddEdit"
</script>

