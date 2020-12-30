# java-servlet-demo
Study Spring MVC (Servlet)

### 1부. 스프링 MVC 동작 원리
1. DispatcherServlet 동작 원리
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

2. 스프링 MVC 구성 요소
   1) MultipartResolver
    * 파일 업로드 요청 처리에 필요한 인터페이스
    * HttpServletRequest를 MultipartHttpServletRequest로 변환해주어 요청이 담고 있는 File을 꺼낼 수 있는 API 제공.
   2) LocaleResolver
    * 클라이언트의 위치(Locale) 정보를 파악하는 인터페이스
    * 기본 전략은 요청의 accept-language를 보고 판단.
   3) ThemeResolver
    * 애플리케이션에 설정된 테마를 파악하고 변경할 수 있는 인터페이스
    * 참고: https://memorynotfound.com/spring-mvc-theme-switcher-example/
   4) HandlerMapping
    * 요청을 처리할 핸들러를 찾는 인터페이스
   5) HandlerAdapter
    * HandlerMapping이 찾아낸 “핸들러”를 처리하는 인터페이스
    * 스프링 MVC 확장력의 핵심
   6) HandlerExceptionResolver
    * 요청 처리 중에 발생한 에러 처리하는 인터페이스
   7) RequestToViewNameTranslator
    * 핸들러에서 뷰 이름을 명시적으로 리턴하지 않은 경우, 요청을 기반으로 뷰 이름을 판단하는 인터페이스
   8) ViewResolver
    * 뷰 이름(string)에 해당하는 뷰를 찾아내는 인터페이스
   9) FlashMapManager
    * FlashMap 인스턴스를 가져오고 저장하는 인터페이스
    * FlashMap은 주로 리다이렉션을 사용할 때 요청 매개변수를 사용하지 않고 데이터를 전달하고 정리할 때 사용한다.
    * redirect:/events
   10) 등등

3. 스프링 MVC 동작 원리
    1) 일반 Spring Framwork
        1) 서블릿 컨테이너(ex. 톰켓)에 등록한 웹 어플리케이션(WAR)에 등록
           * web.xml에 서블릿 등록
           * WebApplicationInitializer에 자바로 서블릿 등록 
        2)세부 구성 요소는 빈 설정하기 나름임.
    2) Spring Boot 사용
        1) 자바 애플리케이션에 내장 톰캣을 만들고 그 안에 DispatcherServlet을
           등록한다.
           * 스프링 부트 자동 설정이 자동으로 해줌.
        2) 스프링 부트의 주관에 따라 여러 인터페이스 구현체를 빈으로 등록한다.
           
            
### 2부. 스프링 MVC 설정
1. 스프링 MVC 구성 요소 직접 빈으로 등록하기
    1) @Configuration을 사용한 자바 설정 파일에 직접 @Bean을 사용해서 등록하기 (WebConfig.java / Line. 12)

2. @EnableWebMvc
    1) 어노테이션 기반 스프링 MVC 사용할 때 편리한 웹 MVC 기본 설정 
       * DispatcherServlet이 스프링 컨테이너를 생성하기 위해선 입력으로 받는 설정 클래스에는 HandlerMapping 빈과 HandlerAdapter 빈이 등록되어있어야 한다. 하지만 설정 클래스에 @EnableWebMvc 애노테이션을 추가해주면 해당 빈을 자동으로 추가해준다.

3. WebMvcConfigurer 인터페이스
    1) @EnableWebMvc가 제공하는 빈을 커스터마이징할 수 있는 기능을 제공하는 인터페이스
    
