import java.time.LocalDate;
import java.time.LocalDateTime;

public interface SigningUp {
    boolean signUp(String firstName, String lastName, LocalDate dateOfBirth, String email,
                   String phoneNumber, String role, String user, String password, String verifiedPassword,
                   Integer salary, LocalDateTime createdOn);
}
