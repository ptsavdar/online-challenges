package HiredInTech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TasksOptimization {
    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>(Arrays.asList(34, 22, 30, 10, 20));
        System.out.println(maximum_completed_tasks(5, 65, res));
    }
    public static int maximum_completed_tasks(int n, int t, List<Integer> task_difficulties) {
        Collections.sort(task_difficulties);
        if (t < task_difficulties.get(0)) return 0;
        int jobs = 1;
        t -= task_difficulties.get(0);
        while (t > 0 && jobs < n) {
            if (t > task_difficulties.get(jobs)) {
                t -= 2 * task_difficulties.get(jobs) - task_difficulties.get(jobs - 1);
                if (t >= 0) jobs++;
            } else {
                t = 0;
            }
        }

        return jobs;
    }
}
