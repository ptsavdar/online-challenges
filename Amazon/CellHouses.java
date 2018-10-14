package Amazon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CellHouses {
    public List<Integer> cellCompete(int[] states, int days)
    {
        int[] nextStates = new int[states.length];

        for(int d =  0; d < days; d++) {
            nextStates[0] = states[1];
            nextStates[states.length - 1] = states[states.length - 2];
            for(int s = 1; s < states.length - 1; s++) {
                nextStates[s] = states[s - 1] == states[s + 1] ? 0 : 1;
            }
            updateStates(states, nextStates);
        }

        return Arrays.stream(states).boxed().collect(Collectors.toList());
    }

    private static void updateStates(int[] states, int nextStates[]) {
        for(int i = 0; i < states.length; i++) {
            states[i] = nextStates[i];
        }
    }
}
