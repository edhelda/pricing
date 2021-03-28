package ru.tender.pricing.controller.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.zalando.problem.Problem;
import org.zalando.problem.ProblemBuilder;
import org.zalando.problem.spring.web.advice.ProblemHandling;
import org.zalando.problem.violations.ConstraintViolationProblem;

import javax.annotation.Nullable;

import static java.util.Objects.isNull;

@ControllerAdvice
public class ExceptionTranslator implements ProblemHandling {

    @Value("${spring.application.name}")
    private String appName;

    private static final String FIELD_ERRORS_KEY = "fieldErrors";
    private static final String APPLICATION_NAME = "applicationName";

    @Override
    public ResponseEntity<Problem> process(@Nullable ResponseEntity<Problem> entity) {
        if (isNull(entity) || isNull(entity.getBody())) {
            return entity;
        }
        Problem problem = entity.getBody();
        ProblemBuilder builder = getDefaultBuilder(problem);
        supplementBuilder(problem, builder);

        return new ResponseEntity<>(builder.build(), entity.getHeaders(), entity.getStatusCode());
    }

    private ProblemBuilder getDefaultBuilder(Problem problem) {
        return Problem.builder()
            .withStatus(problem.getStatus())
            .withTitle(problem.getTitle())
            .withDetail(problem.getDetail());
    }

    private void supplementBuilder(Problem problem, ProblemBuilder builder) {
        if (problem instanceof ConstraintViolationProblem) {
            builder.with(FIELD_ERRORS_KEY, ((ConstraintViolationProblem) problem).getViolations());
        }

        builder.with(APPLICATION_NAME, appName);
    }
}