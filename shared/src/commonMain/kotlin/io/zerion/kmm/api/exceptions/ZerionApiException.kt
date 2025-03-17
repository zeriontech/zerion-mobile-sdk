package io.zerion.kmm.api.exceptions

sealed class ZerionApiException(message: String? = null, cause: Throwable? = null) : Exception(message, cause) {

    class MalformedParametersException(message: String? = null, cause: Throwable? = null) : 
        ZerionApiException("Parameters are malformed: $message", cause)

    class UnauthorizedException(message: String? = null, cause: Throwable? = null) : 
        ZerionApiException("Unauthorized request: $message", cause)

    class TooManyRequestsException(message: String? = null, cause: Throwable? = null) : 
        ZerionApiException("Too many requests: $message", cause)

    class GeneralException(message: String? = null, cause: Throwable? = null) : 
        ZerionApiException("General API error: $message", cause)
        
    class ZerionInitializationException(message: String? = null, cause: Throwable? = null) : 
        ZerionApiException("SDK initialization failed: $message", cause)
        
    class ZerionAuthorizationException(message: String? = null, cause: Throwable? = null) : 
        ZerionApiException("SDK authorization failed: $message", cause)

    companion object {
        fun fromHttpCode(code: Int, message: String? = null, cause: Throwable? = null): ZerionApiException {
            return when (code) {
                400 -> MalformedParametersException(message, cause)
                401 -> UnauthorizedException(message, cause)
                429 -> TooManyRequestsException(message, cause)
                else -> GeneralException(message, cause)
            }
        }
    }
} 