package com.vitek.javalabs.servise.impl;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MovieAdvServiceImplTest {
    // @Value("${apiKey}")
    // private String apiKey;
    // @Mock
    // private RestTemplate restTemplate;

    // @InjectMocks
    // private MovieAdvServiceImpl movieAdvService;

    // @Test
    // void testGetInfotm() {
    // String name = "The Matrix";
    // String url = "https://www.omdbapi.com/?apikey=ApiKey&t=The Matrix";
    // MovieAdv responseBody = new MovieAdv();
    // responseBody.setTitle("The Matrix");
    // responseBody.setYear("1999");
    // ResponseEntity<MovieAdv> responseEntity = new ResponseEntity<>(responseBody,
    // HttpStatus.OK);
    // HashMap<String, String> urlParams = new HashMap<>();
    // urlParams.put("name", name);
    // urlParams.put("apiKey", apiKey);

    // when(restTemplate.getForEntity(url, MovieAdv.class, urlParams))
    // .thenReturn(responseEntity);

    // // Act
    // MovieAdv result = movieAdvService.getInfotm(name);

    // // Assert
    // assertNotNull(result);
    // assertEquals(responseBody.getTitle(), result.getTitle());
    // assertEquals(responseBody.getYear(), result.getYear());
    // // Проверьте остальные поля в соответствии с вашими ожиданиями
    // }

    // @Test
    // public void testGetInfotm_ReturnsNull_WhenResponseBodyIsNull() {
    // // Arrange
    // String name = "Invalid Movie";
    // String url = "https://www.omdbapi.com/?apikey=testApiKey&t=Invalid Movie";
    // ResponseEntity<MovieAdv> responseEntity = new ResponseEntity<>(null,
    // HttpStatus.OK);
    // HashMap<String, String> urlParams = new HashMap<>();
    // urlParams.put("name", name);
    // urlParams.put("apiKey", "testApiKey");

    // when(restTemplate.getForEntity(url, MovieAdv.class, urlParams))
    // .thenReturn(responseEntity);

    // // Act
    // MovieAdv result = movieAdvService.getInfotm(name);

    // // Assert
    // assertNull(result);
    // }

    // @Test
    // public void testGetInfotm_ReturnsNull_WhenRestTemplateThrowsException() {
    // // Arrange
    // String name = "The Matrix";
    // String url = "https://www.omdbapi.com/?apikey=testApiKey&t=The Matrix";
    // HashMap<String, String> urlParams = new HashMap<>();
    // urlParams.put("name", name);
    // urlParams.put("apiKey", "testApiKey");

    // when(restTemplate.getForEntity(url, MovieAdv.class, urlParams))
    // .thenThrow(new RuntimeException("Error"));

    // // Act
    // MovieAdv result = movieAdvService.getInfotm(name);

    // // Assert
    // assertNull(result);
    // }

    // // Дополнительные тесты:

    // @Test
    // public void
    // testGetInfotm_ReturnsNull_WhenResponseEntityHasNonSuccessStatusCode() {
    // // Arrange
    // String name = "The Matrix";
    // String url = "https://www.omdbapi.com/?apikey=testApiKey&t=The Matrix";
    // ResponseEntity<MovieAdv> responseEntity = new
    // ResponseEntity<>(HttpStatus.BAD_REQUEST);
    // HashMap<String, String> urlParams = new HashMap<>();
    // urlParams.put("name", name);
    // urlParams.put("apiKey", "testApiKey");

    // when(restTemplate.getForEntity(url, MovieAdv.class, urlParams))
    // .thenReturn(responseEntity);

    // // Act
    // MovieAdv result = movieAdvService.getInfotm(name);

    // // Assert
    // assertNull(result);
    // }

    // @Test
    // public void testGetInfotm_ReturnsNull_WhenApiKeyIsNotSet() {
    // // Arrange
    // String name = "The Matrix";
    // ReflectionTestUtils.setField(movieAdvService, "apiKey", null);

    // // Act
    // MovieAdv result = movieAdvService.getInfotm(name);

    // // Assert
    // assertNull(result);
    // }
}
