set GAESDK=C:\eclipse\plugins\com.google.appengine.eclipse.sdkbundle_1.5.0.r36v201105092302\appengine-java-sdk-1.5.0
set JAVA_HOME=C:\Program Files (x86)\Java\jdk1.6.0_21
"%JAVA_HOME%\bin\java" -cp "%GAESDK%\lib\appengine-tools-api.jar" com.google.appengine.tools.admin.AppCfg update war
pause
