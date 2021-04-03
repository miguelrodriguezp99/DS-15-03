package e2;

import java.util.ArrayList;
import java.util.List;

public class Project {
    ProjectComponent allEquipos;

    public final String name;

    public Project(ProjectComponent allEquipos, String name){
        this.allEquipos = allEquipos;
        this.name = name;
        allEquipos.actualizar(this);
    }

    public String print(){ return allEquipos.print(0, this); }

    public String getName(){
        return this.name;
    }

    public List<ProjectComponent> coWorkers(){
        List<ProjectComponent> coWorkersList = new ArrayList<>();
        allEquipos.coWorkers(coWorkersList);
        return coWorkersList;
    }

    @Override
    public String toString() {
        return "Project: " + getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;

        Project project = (Project) o;

        if (!allEquipos.equals(project.allEquipos)) return false;
        return getName().equals(project.getName());
    }

    @Override
    public int hashCode() {
        int result = allEquipos.hashCode();
        result = 31 * result + getName().hashCode();
        return result;
    }
}
