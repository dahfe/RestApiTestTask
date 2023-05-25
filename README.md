# Cities Run the application. 

To access the endpoints, you need to register and authorize. 

The application has two roles: 
  1. User (username, password) 
  2. Administrator (username, password) 
 
 After authorization, you will get token. Provide it with all your future requests. 
 
 Endpoints: 
  1. api/v1/registering - Registration. 
  2. api/v1/auth - Authorization. 
  3. api/v1/city/{cityName} - get the city by the specified name. 
  4. api/v1/city/editing - change the city. Must provide RequestBody (id, name, photo or list of photos). 
  5. api/v1/city/loading - load the city. Must provide a RequestBody (name, photo, or list of photos). 
  6. api/v1/getCities - Get the selected cities page.
