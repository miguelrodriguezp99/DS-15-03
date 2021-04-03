package e2;

import java.util.Collections;
import java.util.List;

public abstract class ProjectComponent {
    public void add(ProjectComponent projectComponent){ throw new UnsupportedOperationException(); }

    public abstract float getHours(Project p);

    public abstract String getName();

    public abstract float getSalary(Project p);

    public abstract String print(int index, Project p);

    public abstract void actualizar(Project p);

    protected abstract void coWorkers(List<ProjectComponent> coWorkersList);

    public List<ProjectComponent> listCoWorkers(Project p) {return Collections.unmodifiableList(p.coWorkers());}
}
