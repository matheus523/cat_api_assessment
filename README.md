# cat_api_assessment
Android code assessment

## Description of the problem and the solution:
The task at hand was to create an Android app using Kotlin that fetches a list of cat breeds from an API and presents them in a visually appealing list adhering to modern Android UI practices. The challenge was in handling the network request, processing the data, and presenting it in a user-friendly manne.

## Technical choices and considerations:

To tackle this task effectively, I made specific technological decisions:

Retrofit: I opted for Retrofit due to its simplicity in handling network requests and its robust support for RESTful APIs.
Paging Library: For efficient data loading and presentation, I utilized the Paging Library, which enabled smooth pagination of data as users scrolled through the list.
Gson: Gson was employed for parsing JSON responses into Kotlin objects.
Hilt (Dagger): Dependency injection was managed using Hilt, a tool built on Dagger.
Navigation Component: To streamline app navigation, I relied on the Navigation Component provided by Android Jetpack.
Coil: For image loading and display, I integrated Coil, a lightweight and powerful library known for its advanced features like automatic caching and optimized load times.

Additionally, I ensured the app was designed to accommodate future expansions, such as integrating other APIs like "Dog Api". 
Despite time constraints, I made efforts to support various screen sizes, including landscape mode.

## Improvements:

I encountered a warning during the build process regarding the use of deprecated APIs in Hilt, which I was unable to address within the given timeframe.
While there's room for UI enhancements, I prioritized functionality over aesthetics to ensure the app was robust and extensible.

## Features that I wanted to implement:

Search/filter option: Allowing users to search or filter the list of cat breeds based on specific criteria.
Detail view: Providing a detailed view where users can access additional information about each cat breed.


