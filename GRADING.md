# Grading Procedure

This document outlines how your assignments are graded.

## Changes from Student Version

This repository is the same as the student version provided at the beginning of this assignment, with the following 
changes (which are relevant to you):

- The sample solution is provided under `app/src/main/java`
- The hidden test cases are included under `app/src/test/java`
- New Gradle configurations are provided to only run hidden test cases

## Running the Test Cases

Assuming your submission is located in `$SUBMISSION` and this repository is located in `$SOLUTION`.

1. Copy `$SOLUTION` into a temporary directory (`$TMP`).
2. Delete `$TMP/app/src/main`, and copy `$SUBMISSION/app/src/main` into `$TMP/app/src/main`
    - In effect, you should replace the sample solution with your submitted solution
3. Run one of the provided IntelliJ Run Configurations.
    - Sanity Tests: Runs all sanity tests, which your submission should pass all of
    - Provided Tests: Runs all provided tests, which has been provided to you
    - Hidden Tests: Runs all hidden test cases
    - Test All: Runs all test cases

## Grading

This section outlines the procedure used for grading your PA1 submission.

1. Download and extract the latest non-late submission from CASS or GitHub.
2. Blend the submission with all test cases ([see here](#running-the-test-cases)).
3. Clean the project by running `./gradlew clean` (or the `Clean` configuration in IntelliJ)
4. Run each of the following Gradle configurations:
    - `./gradlew testSanity`: Runs all sanity tests (Equivalent to `Sanity Test` in IntelliJ)
    - `./gradlew testProvided`: Runs all provided tests (Equivalent to `Provided Test` in IntelliJ)
    - `./gradlew testActual`: Runs all hidden tests (Equivalent to `Hidden Test` in IntelliJ)
    - `./gradlew checkstyleMain`: Runs CheckStyle (Equivalent to `CheckStyle` in IntelliJ)

You may refer to the [marking scheme](#grading-scheme) for the weighting of each section.

### Grading of Skipped Tests

If any skipped tests are encountered during the grading of provided or hidden tests, the following guidelines will be
used to grade the skipped tests.

1. All test classes without dependencies are first tested, and all failures are marked down.
2. For each dependent test class (`GameState`, `GameBoardController`, `GameController`):
    - Replace the class in the sample solution with the submitted class
    - Run the corresponding test class and note down all failures

The final score for each set of test cases will be the number of test cases subtracted by the sum of all failures.

## Grading Scheme

*This section is directly copied from the [README](README.md).*

|  | **Percentage** | **Notes** |
| --- | --- | --- |
| Keep your GitHub repository private | 5% | You must keep your repository **private** at all times. |
| Commit at least 3 times in different days | 5% | You should commit three times during different days in your repository. |
| Code Style | 10% | You get 10% by default, and every 5 warnings from CheckStyle deducts 1%. |
| Provided Tests | 15% | `(# of passing tests / # of provided tests) * 15%` |
| Hidden Tests | 65% | `(# of passing tests / # of hidden tests) * 65%` |

Note that sanity tests are not part of the marking scheme because they are to make sure the critical part of the 
skeleton code is working.
They will pass without you having to implement anything.
**You will get zero for the both the provided and hidden test part (counted for 80%) if you break any of the sanity 
tests, which means you will get at most 20% for this assignment.**

For your information, there are:

- 86 Sanity Tests
- 67 Provided Tests
- 72 Hidden Tests

## Appeal Guidelines

In general, you may appeal the grading for one of the following reasons:

- There is an issue with the grading.
- There are cases of "double jeopardy", where a single failure causes multiple unrelated test cases to fail.

You may also request for the grading details of your submission to understand the score distribution of your assignment.

When submitting an appeal, please attach the following information:

- Your name and SID
- The test case(s) you are trying to appeal
- Your justification of the appeal
- Any screenshots to demonstrate your justification

Please send your appeals to chmakac@connect.ust.hk, and CC to csta3021@cse.ust.hk.

**The deadline for appeal is 2021-11-01 23:59 HKT**.
