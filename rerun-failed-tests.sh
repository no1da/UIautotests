#!/bin/bash
FAILED_TESTS_FILE="failed-tests.txt"

TEST_CLASSES=$(cat "$FAILED_TESTS_FILE" | tr "\n" "," | sed 's/,$//')

mvn test -Dtest="$TEST_CLASSES"
