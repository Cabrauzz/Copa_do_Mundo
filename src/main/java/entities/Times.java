package entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Times {

    public String homeTeam;
    public String visitingTeam;
    public Integer homeGoal;
    public Integer visitingGoal;
}
