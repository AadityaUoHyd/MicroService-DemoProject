# MicroService-DemoProject
A Demo project of Microservices using to two microservice API - "department-service" API as Producer, and "user-service" API as Consumer. We will use Loadbalancer &amp; API Aateway, CircuitBreaker Fallback mechanism, HystrixDashboard for monitoring, Cloud-config for pushing config from GitHub, zipkin-sleuth, and bootstrap.yml.

DETAILS:-

# Go to spring initializer and import & develop six modules with required “pom.xml”.
1.	First create “department-service” API (a producer).
2.	Then create “user-service” API (will consume department-service using RestTemplate).
3.	Register both of above API, in Eureka (service-registry API).
4.	Now, Its time to create one API gateway (cloudGateway API).
5.	Also create Hystrix dashboard for fallback (hystrixDashboard API).
6.	Now finally create last API of our project for cloud-configure (cloudConfigServer). We are gonna push congit via “application.yml” file present in GitHub. Set serverPort & ApplicationName form inner “application.yml” of each API.

# Now first verify your Eureka, all instances are running fine or not.

# To test our API in Postman:
i)	First use post request for Department API with given link & data format (with Content-type as application/json):      http://localhost:9001/departments/
{
	"departmentName":"IT",
	"departmentAddress":"Axis bank chest, Sardar patel road",
	"departmentCode":"IT-07"  
}

ii)	Now use post request for User API with given link & data format:      http://localhost:9002/users/
{
  "firstName":"Aaditya",
  "lastName":"Raj",
  "email":"aadi@gmail.com",
  "departmentId":1 
}

iii)	Now you can hit Get request for Department API : http://localhost:9001/departments/1
iv)	Now you can hit Get request for User API : http://localhost:9002/users/1 

v)	You can also verify API Gateway working or not : http://localhost:9191/departments/1 
vi)	http://localhost:9191/users/1 

# Now check on HystrixDashbord by hitting url from Eureka registry. Also modify the url (remove actuator/info). your url should be: http://localhost:9295/hystrix (It’ll open your HystrixDashboard)

# To see your stream started or not : http://localhost:9191/actuator/hystrix.stream

# Now push the given above link to HystrixDashboard box with placeholder (https://hostname:port/turbine/turbine.stream) and click on ‘Monitor Sream’. Now verify monitoring thread pools & circuit graphs. Go to postman & use all services to notice changes in graphs.

# Also we have mentioned “bootstrap.yml” in USER & DEPARTMENT API for loading configuration properties from the external sources and for decrypting properties in the local external configuration files. Downlaod Zipkin executable jar from Google (zipkin.io), and then put that jar on same file where USER & DEPARTMENT API are available. Go to cmd and invoke that jar with command : Java  –jar  zipkin-server-2.23.2-exec

# Now hit  http://127.0.0.1:9411/zipkin/ to for traceid & spanId. Verify there filling blanks and clicking on query. Also on Boot Console one can see those activity(when you use POSTMAN get/post) with span & trace Ids.
