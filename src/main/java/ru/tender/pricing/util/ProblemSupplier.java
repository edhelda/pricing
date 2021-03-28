package ru.tender.pricing.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.ThrowableProblem;

import java.text.MessageFormat;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProblemSupplier {

    public static ThrowableProblem badRequest(String message, Object... args) {
        return buildProblem(Status.BAD_REQUEST, "Ошибка запроса", message, args);
    }

    public static ThrowableProblem unauthorized(String message, Object... param) {
        return buildProblem(Status.UNAUTHORIZED, "Ошибка аутентификации", message, param);
    }

    public static ThrowableProblem forbidden(String message, Object... param) {
        return buildProblem(Status.FORBIDDEN, "Запрос запрещен", message, param);
    }

    public static ThrowableProblem notFound(String message, Object... args) {
        return buildProblem(Status.NOT_FOUND, "Не найдено", message, args);
    }

    public static ThrowableProblem serverError(String message, Object... param) {
        return buildProblem(Status.INTERNAL_SERVER_ERROR, "Ошибка сервиса", message, param);
    }

    public static ThrowableProblem buildProblem(Status status, String title, String message, Object... args) {
        log.error(message);
        return Problem.builder()
                .withStatus(status)
                .withTitle(title)
                .withDetail(message != null ? MessageFormat.format(message, args) : null)
                .build();
    }
}