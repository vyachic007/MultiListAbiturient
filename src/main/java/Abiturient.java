import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Abiturient {
    private String lastName;
    private int[] examScore;
    private boolean hasHonorsDiploma;
    private String city;
    private boolean needsDormitory;

    @Override
    public String toString() {
        return String.format(
                "[%s | оценки: %s | аттестат: %s | город: %s | общежитие: %s]",
                lastName,
                Arrays.toString(examScore),
                hasHonorsDiploma ? "Да" : "Нет",
                city,
                needsDormitory ? "Да" : "Нет"
        );
    }

}
