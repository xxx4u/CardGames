/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.database;

public class SqlQuery {

    private StringBuilder query;

    public SqlQuery() {
        this.query = new StringBuilder();
    }

    public SqlQuery appendlastln(final String... segments) {
        for (String segment : segments) {
            this.query.append(segment);
        }
        this.query.append("\n");
        return this;
    }

    public SqlQuery appendln(final String... segments) {
        for (String segment : segments) {
            this.query.append(segment).append("\n");
        }
        return this;
    }

    @Override
    public String toString() {
        return this.query.toString();
    }
}
