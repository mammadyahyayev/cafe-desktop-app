package model;

public class CafeTable extends AbstractModel {

    private String name;
    private String tablePeople;
    private TableStatus tableStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTablePeople() {
        return tablePeople;
    }

    public void setTablePeople(String tablePeople) {
        this.tablePeople = tablePeople;
    }

    public TableStatus getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(TableStatus tableStatus) {
        this.tableStatus = tableStatus;
    }

}
