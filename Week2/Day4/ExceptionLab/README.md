# Reflection Answers

1. `throw` starts a statement to throw an exception (`throw new IOException();`), `throws` is part of a method signature to indicate that a method throws a checked exception (`throws IOException`).
2. `AttendanceShortageException` is checked, but `InvalidMarksException` extends `RuntimeException` and is thus unchecked. The compiler only forces you to handle checked exceptions.
3. After the `try` and `catch`, regardless of if an error was thrown.
4. It allows more specific error handling, as `NullPointerException` can't be easily filtered on which object was null. In addition, exceptions have a runtime cost that checking in advance avoids.
5. `UnknownSubjectException` would be a good idea, instead of returning a non-subject from a method meant to return subjects. This would be a checked exception, because the caller should take the responsibility to handle the case when the subject number is invalid.