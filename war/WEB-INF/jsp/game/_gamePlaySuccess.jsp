<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:useActionBean id="bean" beanclass="com.wordpong.app.action.game.GamePlaySuccessActionBean"/>
<fmt:message var="continueLbl" key="continue" />

<div data-role="header"  data-nobackbtn="true" data-theme="b">
</div>
<div data-role="content" style="padding-top:0px;">
	<s:form id="gamePlaySuccessForm" beanclass="com.wordpong.app.action.game.GamePlaySuccessActionBean" method="post">
        <tags:messages/> 
	    <ul data-role="listview" data-inset="true" data-theme="c" data-dividertheme="b"  style="margin-top:0px;">
            <li data-role="list-divider" >
            	<h3 style="white-space:normal">Congratulations! All Questions Answered Correctly.</h3> 
            </li>
        </ul>
        <ul  data-role="listview" data-inset="true" data-theme="c" data-dividertheme="b"  style="margin-top:0px;">
            <center>
	        	<img src="/i/a/adsense-adchoices-expanded.png">
        	</center>
		    <input id="gameKeyStringEncrypted" name="gameKeyStringEncrypted" type="hidden" value=""/>    
	    </ul>
        <div style="float:right">
           <input value="${continueLbl}" name="done" id="done" type="submit" data-theme="a"  class="process" /> 
        </div>
	</s:form>	 
</div>
<pre>






</pre>
<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
<script>
wpFooterFile = "gamePlaySuccess"
</script>