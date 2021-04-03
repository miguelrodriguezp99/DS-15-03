package e2;
import java.util.ArrayList;
import java.util.List;


public class Equipo extends ProjectComponent{
    private final List<ProjectComponent> projectComponents = new ArrayList<>();
    private final List<Project> projects = new ArrayList<>();

    private final String name;
    private boolean contains = false;

    public Equipo(String name){
        this.name = name;
    }

    public boolean contains(String name){
        for(ProjectComponent c : projectComponents)
            if(name.equals(c.getName())) contains = true;
        return contains;
    }

    @Override
    public void add(ProjectComponent projectComponent){
        if(!contains(projectComponent.getName())) projectComponents.add(projectComponent);
        else throw new UnsupportedOperationException();

        for(Project p: projects){
            projectComponent.actualizar(p);
        }
    }

    @Override
    public String getName() {return this.name;}

    public String getProjects(){ return projects.toString(); }

    public String getWorkers(){
        StringBuilder sb = new StringBuilder();
        for(ProjectComponent c : projectComponents){
            sb.append(c.getName()).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    @Override
    public float getSalary(Project p){
        int salary = 0;
        for(ProjectComponent c : projectComponents){
            salary += c.getSalary(p);
        }
        return salary;
    }

    @Override
    public float getHours(Project p){
        float hours = 0;
        for(ProjectComponent c : projectComponents){
            hours = hours + c.getHours(p);
        }
        return hours;
    }

    @Override
    public String print(int index, Project p){
        StringBuilder sb = new StringBuilder(" ".repeat(Math.max(0, index)) + getName() + ": " + getHours(p) + ", " + getSalary(p) + " €\n");

        for(ProjectComponent c : projectComponents){
            sb.append(c.print(index+2, p));
        }

        return sb.toString();
    }

    @Override
    public void actualizar(Project p) {
       if(!projects.contains(p)) projects.add(p);

        for(ProjectComponent c : projectComponents){
            c.actualizar(p);
        }
    }

    @Override
    protected void coWorkers(List<ProjectComponent> coWorkersList) {
        for(ProjectComponent c : projectComponents){
            c.coWorkers(coWorkersList);
        }
    }

    @Override
    public String toString() {
        return "Equipo " + getName();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipo)) return false;

        Equipo equipo = (Equipo) o;

        if (contains != equipo.contains) return false;
        if (!projectComponents.equals(equipo.projectComponents)) return false;
        if (!getProjects().equals(equipo.getProjects())) return false;
        return getName().equals(equipo.getName());
    }

    @Override
    public int hashCode() {
        // int result = projectComponents.toString().hashCode();
        int result = 0;
        result = 31 * result + getProjects().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + (contains ? 1 : 0);
        return result;
    }
}
