package e2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Empleado extends ProjectComponent{
    private final String name;
    private final float costperhour;
    Map<Project, Float> workerMap = new HashMap<>();

    public Empleado(String name, int costperhour){
        this.name = name;
        this.costperhour = costperhour;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public float getHours(Project p){
        return workerMap.get(p);
    }

    @Override
    public float getSalary(Project p){ return workerMap.get(p) * costperhour; }

    @Override
    public String print(int index, Project p){ return " ".repeat(Math.max(0, index)) + getName() + ": " + getHours(p) + ", " + getSalary(p) + " €\n"; }

    @Override
    public void actualizar(Project p) {
        if(!workerMap.containsKey(p)) workerMap.put(p, 0f);
    }

    public void sumarHoras(Project p, float hours){
        workerMap.put(p, hours);
    }

    @Override
    protected void coWorkers(List<ProjectComponent> list) {
        list.add(this);
    }

    @Override
    public String toString() {
        return "Trabajador: " +getName();
    }

    public String getProject(){
        StringBuilder sb = new StringBuilder();
        workerMap.forEach((key, value) -> sb.append(name).append(": ").append(key.getName()).append(" ").append(value).append(" "));
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empleado)) return false;

        Empleado empleado = (Empleado) o;

        if (Float.compare(empleado.costperhour, costperhour) != 0) return false;
        if (!getName().equals(empleado.getName())) return false;
        return workerMap.equals(empleado.workerMap);
    }

   @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + (costperhour != +0.0f ? Float.floatToIntBits(costperhour) : 0);
        result = 31 * result + workerMap.hashCode();
        return result;
    }
}