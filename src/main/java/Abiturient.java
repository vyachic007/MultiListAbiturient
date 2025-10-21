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


    public void setExamScore(int[] examScore) {
        if (examScore.length != 3) {
            throw new IllegalArgumentException("Оценки должны быть массивом из 3 чисел");
        }
        this.examScore = examScore;
    }

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
