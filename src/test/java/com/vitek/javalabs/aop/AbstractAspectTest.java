package com.vitek.javalabs.aop;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AbstractAspectTest {
    // @Mock
    // private Logger logger;

    // @Mock
    // private JoinPoint joinPoint;

    // @Mock
    // private Signature signature;

    // @InjectMocks
    // private AbstractAspect abstractAspect;

    // @Captor
    // private ArgumentCaptor<String> messageCaptor;

    // @BeforeEach
    // void setUp() {
    // MockitoAnnotations.openMocks(this);

    // when(joinPoint.getSignature()).thenReturn(signature);
    // when(signature.getName()).thenReturn("testMethod");
    // }

    // @Test
    // void testBeforeAdvice() {
    // // Act
    // abstractAspect.beforeAdvice(joinPoint);

    // // Assert
    // verify(logger).info(messageCaptor.capture());
    // assertEquals("Entering method: testMethod", messageCaptor.getValue());
    // }

    // @Test
    // void testAfterReturningAdvice() {
    // // Arrange
    // Object result = "Test Result";

    // // Act
    // abstractAspect.afterReturningAdvice(joinPoint, result);

    // // Assert
    // verify(logger).info(messageCaptor.capture());
    // assertEquals("Exiting method: testMethod, with result: Test Result",
    // messageCaptor.getValue());
    // }

    // @Test
    // void testAfterAdvice() {
    // // Act
    // abstractAspect.afterAdvice(joinPoint);

    // // Assert
    // verify(logger).info(messageCaptor.capture());
    // assertEquals("Method: testMethod has completed", messageCaptor.getValue());
    // }

    // @Test
    // void testAfterThrowingAdvice() {
    // // Arrange
    // Throwable exception = new RuntimeException("Test Exception");

    // // Act
    // abstractAspect.afterThrowingAdvice(joinPoint, exception);

    // // Assert
    // verify(logger).error(messageCaptor.capture(),
    // eq(exception.getClass().getSimpleName()), eq(exception));
    // assertEquals("Exception thrown in method: testMethod - Error:
    // RuntimeException", messageCaptor.getValue());
    // }
}