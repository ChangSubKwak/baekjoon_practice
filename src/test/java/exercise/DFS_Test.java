package exercise;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DFS_Test {
    @Test
    void test() {
        DFS dfs = new DFS();
        List<List<Integer>> node = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(0, 3, 4),
            Arrays.asList(0, 5, 6),
            Arrays.asList(1),
            Arrays.asList(1),
            Arrays.asList(2),
            Arrays.asList(2)
        );

        Assertions.assertThat(dfs.execute()).isEqualTo(Arrays.asList(0, 1, 3, 4, 2, 5, 6));
    }
}