package com.workshopkotlin.anggitprayogo.base

enum class StatusCode(val value: Int) {
    STATUS_OK(200),
    STATUS_CREATED(201),
    STATUS_ACCEPTED(202),
    STATUS_NO_CONTENT(204),
    STATUS_BAD_REQUEST(400),
    STATUS_UNAUTHORIZED(401),
    STATUS_FORBIDDEN(403),
    STATUS_NOT_FOUND(404),
    STATUS_METHOD_NOT_ALLOWED(405),
    STATUS_NOT_ACCEPTABLE(406),
    STATUS_REQUEST_TIMEOUT(408),
    STATUS_INVALID_INPUT(422),
    STATUS_TOO_MANY_REQUEST(429),
    STATUS_INTERNAL_SERVER_ERROR(500),
    STATUS_BAD_GATEWAY(502),
    STATUS_SERVICE_UNAVAILABLE(503),
    STATUS_GATEWAY_TIMEOUT(504),
}