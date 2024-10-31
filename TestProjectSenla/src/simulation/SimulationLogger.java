// SimulationLogger.java
package simulation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SimulationLogger {
    private BufferedWriter writer;

    public SimulationLogger(String filename) throws IOException {
        this.writer = new BufferedWriter(new FileWriter("data/logs/" + filename, true));
    }

    public void logEvent(String event) throws IOException {
        writer.write(event + "\n");
    }

    public void close() throws IOException {
        if (writer != null) {
            writer.close();
        }
    }
}
