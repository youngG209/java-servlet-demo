# java-servlet-demo
Study Servlet

1. DispatcherServlet
    1) @ResponseBody : Converter를 사용하여 응답 본문을 만듬 (ex. Ajax)
       * HelloController.java / Line. 15
    2) View의 이름으로 인식
       * HandlerMapping: 핸들러를 찾아주는 인터페이스 (HelloController.java / Line. 21)
       * HandlerAdapter: 핸들러를 실행하는 인터페이스 (SimpleController.java / Line. 12)
    3) Custom ViewResolver (WebConfig.java)
       * initStrategies 메소드를 사용하여 처음 설정한다.
       * ViewResolver : InternalResourceViewResolver
       * InternalResourceViewResolver 
         1) Prefix : 앞
         2) Suffix : 뒤

