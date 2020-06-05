package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.AdvancedSearch;
import model.CafeTable;
import model.Login;
import model.Menu;
import model.MenuIn;
import model.Paid;
import model.Product;
import model.Role;
import model.Sifaris;
import model.Sifaris_Masa;
import model.TableStatus;

public class DaoImpl implements DaoInterface {

    @Override
    public List<CafeTable> getCafeTableList() throws Exception {
        List<CafeTable> cafeTableList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,CAFE_TABLE.ID,CAFE_TABLE.NAME,CAFE_TABLE.TABLE_PEOPLE,TS.ID table_status_id,TS.STATUS_NAME FROM CAFE_TABLE "
                + " INNER JOIN TABLE_STATUS TS ON CAFE_TABLE.TABLE_STATUS_ID = TS.ID "
                + " WHERE CAFE_TABLE.ACTIVE = 1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    CafeTable cafeTable = new CafeTable();
                    cafeTable.setRownum(rs.getLong("r"));
                    cafeTable.setId(rs.getLong("ID"));
                    cafeTable.setName(rs.getString("NAME"));
                    cafeTable.setTablePeople(rs.getString("TABLE_PEOPLE"));

                    TableStatus status = new TableStatus();
                    status.setId(rs.getLong("table_status_id"));
                    status.setStatusName(rs.getString("STATUS_NAME"));

                    cafeTable.setTableStatus(status);

                    cafeTableList.add(cafeTable);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return cafeTableList;
    }

    @Override
    public List<Menu> getMenuList() throws Exception {
        List<Menu> menuList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,ID,MENYU_NAME FROM MENU WHERE ACTIVE = 1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Menu menu = new Menu();

                    menu.setRownum(rs.getLong("r"));
                    menu.setId(rs.getLong("ID"));
                    menu.setName(rs.getString("MENYU_NAME"));

                    menuList.add(menu);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return menuList;
    }

    @Override
    public List<MenuIn> getMenuInList() throws Exception {
        List<MenuIn> menuInList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,MENU_IN.ID,MENU_IN.MENYU_IN_NAME,MENU_IN.PRICE,MENU.ID menyu_id,MENU.MENYU_NAME FROM MENU_IN "
                + " INNER JOIN MENU ON MENU_IN.MENYU_ID = MENU.ID "
                + " WHERE MENU_IN.ACTIVE = 1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    MenuIn menuIn = new MenuIn();
                    menuIn.setId(rs.getLong("ID"));
                    menuIn.setRownum(rs.getLong("r"));
                    menuIn.setMenyuInName(rs.getString("MENYU_IN_NAME"));
                    menuIn.setPrice(rs.getFloat("PRICE"));

                    Menu menu = new Menu();
                    menu.setId(rs.getLong("menyu_id"));
                    menu.setName(rs.getString("MENYU_NAME"));

                    menuIn.setMenu(menu);

                    menuInList.add(menuIn);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return menuInList;
    }

    @Override
    public List<TableStatus> getTableStatusList() throws Exception {
        List<TableStatus> tableStatusList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,ID,STATUS_NAME FROM TABLE_STATUS WHERE ACTIVE = 1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    TableStatus status = new TableStatus();
                    status.setId(rs.getLong("ID"));
                    status.setRownum(rs.getLong("r"));
                    status.setStatusName(rs.getString("STATUS_NAME"));

                    tableStatusList.add(status);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return tableStatusList;
    }

    @Override
    public List<MenuIn> getMenuInListById(Long id) throws Exception {
        List<MenuIn> menuInList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,MENU_IN.ID,MENU_IN.MENYU_IN_NAME,MENU_IN.PRICE,MENU.ID menyu_id,MENU.MENYU_NAME FROM MENU_IN "
                + " INNER JOIN MENU ON MENU_IN.MENYU_ID = MENU.ID "
                + " WHERE (MENU_IN.ACTIVE = 1) AND (menyu_id = ?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    MenuIn menuIn = new MenuIn();
                    menuIn.setId(rs.getLong("ID"));
                    menuIn.setRownum(rs.getLong("r"));
                    menuIn.setMenyuInName(rs.getString("MENYU_IN_NAME"));
                    menuIn.setPrice(rs.getFloat("PRICE"));

                    Menu menu = new Menu();
                    menu.setId(rs.getLong("menyu_id"));
                    menu.setName(rs.getString("MENYU_NAME"));

                    menuIn.setMenu(menu);

                    menuInList.add(menuIn);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return menuInList;
    }

    @Override
    public boolean add(MenuIn menuIn, Long id) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO MENU_IN(ID,MENYU_IN_NAME,MENYU_ID,PRICE) "
                + " VALUES(MENU_IN_SEQ.NEXTVAL,?,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, menuIn.getMenyuInName());
                ps.setLong(2, id);
                ps.setFloat(3, menuIn.getPrice());
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public MenuIn getMenuInById(Long menuInId, Long menuId) throws Exception {
        MenuIn menuIn = new MenuIn();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,MENU_IN.ID,MENU_IN.MENYU_IN_NAME,MENU_IN.PRICE,MENU.ID menyu_id,MENU.MENYU_NAME FROM MENU_IN "
                + " INNER JOIN MENU ON MENU_IN.MENYU_ID = MENU.ID "
                + " WHERE ((MENU_IN.ACTIVE = 1) AND (MENU_IN.ID = ? AND menyu_id = ?))";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, menuInId);
                ps.setLong(2, menuId);
                rs = ps.executeQuery();
                while (rs.next()) {

                    menuIn.setId(rs.getLong("ID"));
                    menuIn.setRownum(rs.getLong("r"));
                    menuIn.setMenyuInName(rs.getString("MENYU_IN_NAME"));
                    menuIn.setPrice(rs.getFloat("PRICE"));

                    Menu menu = new Menu();
                    menu.setId(rs.getLong("menyu_id"));
                    menu.setName(rs.getString("MENYU_NAME"));

                    menuIn.setMenu(menu);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return menuIn;
    }

    @Override
    public boolean add(Menu menu) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO MENU(ID,MENYU_NAME) "
                + " VALUES(MENU_SEQ.NEXTVAL,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, menu.getName());
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public Menu getMenuById(Long id) throws Exception {
        Menu menu = new Menu();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,ID,MENYU_NAME FROM MENU WHERE (ACTIVE = 1) AND ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    menu.setRownum(rs.getLong("r"));
                    menu.setId(rs.getLong("ID"));
                    menu.setName(rs.getString("MENYU_NAME"));
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return menu;
    }

    @Override
    public boolean update(MenuIn menuIn, Long menuInId, Long menuId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE MENU_IN SET MENYU_IN_NAME = ? , PRICE = ? WHERE (ID = ? AND MENYU_ID = ?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, menuIn.getMenyuInName());
                ps.setFloat(2, menuIn.getPrice());
                ps.setLong(3, menuInId);
                ps.setLong(4, menuId);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean update(Menu menu, Long id) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE MENU SET MENYU_NAME = ? WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, menu.getName());
                ps.setLong(2, id);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean deleteMenuIn(Long id, Long menuId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE MENU_IN SET ACTIVE = 0 WHERE ((ID = ?) AND (MENYU_ID = ?))";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                ps.setLong(2, menuId);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean deleteMenu(Long id) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE MENU SET ACTIVE = 0 WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public List<MenuIn> searchMenuIn(String keyword, Long menuId) throws Exception {
        List<MenuIn> menuInList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,MENU_IN.ID,MENU_IN.MENYU_IN_NAME,MENU_IN.PRICE,MENU.ID menyu_id,MENU.MENYU_NAME FROM MENU_IN "
                + " INNER JOIN MENU ON MENU_IN.MENYU_ID = MENU.ID "
                + " WHERE ((MENU_IN.ACTIVE = 1 AND menyu_id = ?) AND (LOWER(MENU_IN.MENYU_IN_NAME) LIKE LOWER(?) OR  LOWER(MENU_IN.PRICE) LIKE LOWER(?) OR  LOWER(MENU.MENYU_NAME) LIKE LOWER(?)))";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, menuId);
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                ps.setString(4, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    MenuIn menuIn = new MenuIn();
                    menuIn.setId(rs.getLong("ID"));
                    menuIn.setRownum(rs.getLong("r"));
                    menuIn.setMenyuInName(rs.getString("MENYU_IN_NAME"));
                    menuIn.setPrice(rs.getFloat("PRICE"));

                    Menu menu = new Menu();
                    menu.setId(rs.getLong("menyu_id"));
                    menu.setName(rs.getString("MENYU_NAME"));

                    menuIn.setMenu(menu);

                    menuInList.add(menuIn);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return menuInList;
    }

    @Override
    public List<Menu> searchMenu(String keyword) throws Exception {
        List<Menu> menuList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,ID,MENYU_NAME FROM MENU WHERE ACTIVE = 1 AND LOWER(MENYU_NAME) LIKE(?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Menu menu = new Menu();

                    menu.setRownum(rs.getLong("r"));
                    menu.setId(rs.getLong("ID"));
                    menu.setName(rs.getString("MENYU_NAME"));

                    menuList.add(menu);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return menuList;
    }

    @Override
    public boolean updateTableStatus(Long id) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE CAFE_TABLE SET TABLE_STATUS_ID = 2 WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean updateTableStatusForK(Long id) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE KABINET SET TABLE_STATUS_ID = 2 WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean updateTableStatusForEmpty(Long id) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE CAFE_TABLE SET TABLE_STATUS_ID = 1 WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean updateTableStatusForKForEmpty(Long id) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE KABINET SET TABLE_STATUS_ID = 1 WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public List<MenuIn> getMenuInListByMenuId(Long id) throws Exception {
        List<MenuIn> menuInList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r, MENU_IN.ID,MENU_IN.MENYU_IN_NAME,MENU_IN.PRICE,MENU.ID menu_id , MENU.MENYU_NAME FROM MENU_IN "
                + " INNER JOIN MENU ON MENU.ID = MENU_IN.MENYU_ID WHERE MENU_IN.ACTIVE = 1 AND MENU.ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {

                    MenuIn menuIn = new MenuIn();
                    menuIn.setId(rs.getLong("ID"));
                    menuIn.setMenyuInName(rs.getString("MENYU_IN_NAME"));
                    menuIn.setPrice(rs.getFloat("PRICE"));

                    Menu menu = new Menu();
                    menu.setId(rs.getLong("menu_id"));
                    menu.setName(rs.getString("MENYU_NAME"));
                    menuIn.setMenu(menu);

                    menuInList.add(menuIn);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return menuInList;
    }

    @Override
    public List<Sifaris> getSifarisList() throws Exception {
        List<Sifaris> sifarisList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,SIFARIS.ID,SIFARIS.RES_NAME,SIFARIS.SAY,SIFARIS.PRICE,SIFARIS.REQUEST,MENU_IN.ID menu_in_id, "
                + " MENU_IN.MENYU_IN_NAME,MENU_IN.PRICE menyu_price , MENU.ID menu_id,MENU.MENYU_NAME "
                + " FROM SIFARIS "
                + " INNER JOIN MENU_IN ON MENU_IN.ID = SIFARIS.MENU_IN_ID "
                + " INNER JOIN MENU ON MENU.ID = MENU_IN.MENYU_ID WHERE SIFARIS.ACTIVE = 1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Sifaris sifaris = new Sifaris();
                    sifaris.setRownum(rs.getLong("r"));
                    sifaris.setId(rs.getLong("ID"));
                    sifaris.setResName(rs.getString("RES_NAME"));
                    sifaris.setSay(rs.getInt("SAY"));
                    sifaris.setPrice(rs.getFloat("PRICE"));
                    sifaris.setSifaris(rs.getString("REQUEST"));

                    MenuIn menuIn = new MenuIn();
                    menuIn.setId(rs.getLong("menyu_price"));
                    menuIn.setMenyuInName(rs.getString("MENYU_IN_NAME"));
                    menuIn.setPrice(rs.getFloat("PRICE"));

                    Menu menu = new Menu();
                    menu.setId(rs.getLong("menu_id"));
                    menu.setName(rs.getString("MENYU_NAME"));
                    menuIn.setMenu(menu);

                    sifaris.setMenuIn(menuIn);
                    sifarisList.add(sifaris);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return sifarisList;
    }

    @Override
    public List<Sifaris_Masa> getSifarisMasaList() throws Exception {
        List<Sifaris_Masa> sifarisMasaList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r ,SM.ID,SM.ORDER_DATE,SIFARIS.ID sifaris_id ,SIFARIS.RES_NAME, SIFARIS.SAY, "
                + " SIFARIS.PRICE, SIFARIS.REQUEST, MENU_IN.ID menu_in_id, "
                + " MENU_IN.MENYU_IN_NAME,MENU_IN.PRICE menyu_price , MENU.ID menu_id,MENU.MENYU_NAME, CAFE_TABLE.ID masa_id, "
                + " CAFE_TABLE.TABLE_PEOPLE , CAFE_TABLE.NAME "
                + " FROM SIFARIS_MASA SM "
                + " INNER JOIN CAFE_TABLE ON SM.CAFE_TABLE_ID = CAFE_TABLE.ID  "
                + " INNER JOIN SIFARIS ON SIFARIS.ID = SM.SIFARIS_ID "
                + " INNER JOIN MENU_IN ON MENU_IN.ID = SIFARIS.MENU_IN_ID "
                + " INNER JOIN MENU ON MENU.ID = MENU_IN.MENYU_ID WHERE SM.ACTIVE = 1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Sifaris_Masa sifarisMasa = new Sifaris_Masa();
                    sifarisMasa.setRownum(rs.getLong("r"));
                    sifarisMasa.setId(rs.getLong("ID"));
                    sifarisMasa.setOrderDate(rs.getDate("ORDER_DATE"));

                    Sifaris sifaris = new Sifaris();
                    sifaris.setId(rs.getLong("sifaris_id"));
                    sifaris.setResName(rs.getString("RES_NAME"));
                    sifaris.setSay(rs.getInt("SAY"));
                    sifaris.setPrice(rs.getFloat("PRICE"));
                    sifaris.setSifaris(rs.getString("REQUEST"));

                    CafeTable cafeTable = new CafeTable();
                    cafeTable.setId(rs.getLong("masa_id"));
                    cafeTable.setTablePeople(rs.getString("TABLE_PEOPLE"));
                    cafeTable.setName(rs.getString("NAME"));

                    MenuIn menuIn = new MenuIn();
                    menuIn.setId(rs.getLong("menu_in_id"));
                    menuIn.setMenyuInName(rs.getString("MENYU_IN_NAME"));
                    menuIn.setPrice(rs.getFloat("menyu_price"));

                    Menu menu = new Menu();
                    menu.setId(rs.getLong("menu_id"));
                    menu.setName(rs.getString("MENYU_NAME"));

                    menuIn.setMenu(menu);
                    sifaris.setMenuIn(menuIn);
                    sifarisMasa.setSifaris(sifaris);
                    sifarisMasa.setCafeTable(cafeTable);

                    sifarisMasaList.add(sifarisMasa);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return sifarisMasaList;
    }

    @Override
    public boolean add(Sifaris sifaris) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO SIFARIS(ID,RES_NAME,SAY,PRICE,MENU_IN_ID,REQUEST) "
                + " VALUES(SIFARIS_SEQ.NEXTVAL,?,?,?,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                if (sifaris.getResName() == null) {
                    ps.setString(1, "");
                } else {
                    ps.setString(1, sifaris.getResName());
                }
                ps.setInt(2, sifaris.getSay());
                ps.setFloat(3, sifaris.getPrice());
                ps.setLong(4, sifaris.getMenuIn().getId());
                ps.setString(5, sifaris.getSifaris());
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean addSifarisMasa(Long sifarisId, Long masaId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO SIFARIS_MASA(ID,CAFE_TABLE_ID,SIFARIS_ID) "
                + " VALUES(SIFARIS_MASA_SEQ.NEXTVAL,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, masaId);
                ps.setLong(2, sifarisId);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public Sifaris_Masa getSifarisMasaById(Long id) throws Exception {
        Sifaris_Masa sifarisMasa = new Sifaris_Masa();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r ,SM.ID,SM.ORDER_DATE,SIFARIS.ID sifaris_id ,SIFARIS.RES_NAME, SIFARIS.SAY, "
                + " SIFARIS.PRICE, SIFARIS.REQUEST, MENU_IN.ID menu_in_id, "
                + " MENU_IN.MENYU_IN_NAME,MENU_IN.PRICE menyu_price , MENU.ID menu_id,MENU.MENYU_NAME, CAFE_TABLE.ID masa_id, "
                + " CAFE_TABLE.TABLE_PEOPLE , CAFE_TABLE.NAME "
                + " FROM SIFARIS_MASA SM "
                + " INNER JOIN CAFE_TABLE ON SM.CAFE_TABLE_ID = CAFE_TABLE.ID  "
                + " INNER JOIN SIFARIS ON SIFARIS.ID = SM.SIFARIS_ID "
                + " INNER JOIN MENU_IN ON MENU_IN.ID = SIFARIS.MENU_IN_ID "
                + " INNER JOIN MENU ON MENU.ID = MENU_IN.MENYU_ID WHERE ((SM.ACTIVE = 1) AND (SM.ID = ?))";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    sifarisMasa.setRownum(rs.getLong("r"));
                    sifarisMasa.setId(rs.getLong("ID"));
                    sifarisMasa.setOrderDate(rs.getDate("ORDER_DATE"));

                    Sifaris sifaris = new Sifaris();
                    sifaris.setId(rs.getLong("sifaris_id"));
                    sifaris.setResName(rs.getString("RES_NAME"));
                    sifaris.setSay(rs.getInt("SAY"));
                    sifaris.setPrice(rs.getFloat("PRICE"));
                    sifaris.setSifaris(rs.getString("REQUEST"));

                    CafeTable cafeTable = new CafeTable();
                    cafeTable.setId(rs.getLong("masa_id"));
                    cafeTable.setTablePeople(rs.getString("TABLE_PEOPLE"));
                    cafeTable.setName(rs.getString("NAME"));

                    MenuIn menuIn = new MenuIn();
                    menuIn.setId(rs.getLong("menu_in_id"));
                    menuIn.setMenyuInName(rs.getString("MENYU_IN_NAME"));
                    menuIn.setPrice(rs.getFloat("menyu_price"));

                    Menu menu = new Menu();
                    menu.setId(rs.getLong("menu_id"));
                    menu.setName(rs.getString("MENYU_NAME"));

                    menuIn.setMenu(menu);
                    sifaris.setMenuIn(menuIn);
                    sifarisMasa.setSifaris(sifaris);
                    sifarisMasa.setCafeTable(cafeTable);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return sifarisMasa;
    }

    @Override
    public List<Sifaris_Masa> getSifarisMasaByMasaId(Long id) throws Exception {
        List<Sifaris_Masa> sifarisMasaList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r ,SM.ID,SM.ORDER_DATE,SIFARIS.ID sifaris_id ,SIFARIS.RES_NAME, SIFARIS.SAY, "
                + " SIFARIS.PRICE, SIFARIS.REQUEST, MENU_IN.ID menu_in_id, "
                + " MENU_IN.MENYU_IN_NAME,MENU_IN.PRICE menyu_price , MENU.ID menu_id,MENU.MENYU_NAME, CAFE_TABLE.ID masa_id, "
                + " CAFE_TABLE.TABLE_PEOPLE , CAFE_TABLE.NAME "
                + " FROM SIFARIS_MASA SM "
                + " INNER JOIN CAFE_TABLE ON SM.CAFE_TABLE_ID = CAFE_TABLE.ID  "
                + " INNER JOIN SIFARIS ON SIFARIS.ID = SM.SIFARIS_ID "
                + " INNER JOIN MENU_IN ON MENU_IN.ID = SIFARIS.MENU_IN_ID "
                + " INNER JOIN MENU ON MENU.ID = MENU_IN.MENYU_ID WHERE SM.ACTIVE = 1 AND CAFE_TABLE.ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Sifaris_Masa sifarisMasa = new Sifaris_Masa();
                    sifarisMasa.setRownum(rs.getLong("r"));
                    sifarisMasa.setId(rs.getLong("ID"));
                    sifarisMasa.setOrderDate(rs.getDate("ORDER_DATE"));

                    Sifaris sifaris = new Sifaris();
                    sifaris.setId(rs.getLong("sifaris_id"));
                    sifaris.setResName(rs.getString("RES_NAME"));
                    sifaris.setSay(rs.getInt("SAY"));
                    sifaris.setPrice(rs.getFloat("PRICE"));
                    sifaris.setSifaris(rs.getString("REQUEST"));

                    CafeTable cafeTable = new CafeTable();
                    cafeTable.setId(rs.getLong("masa_id"));
                    cafeTable.setTablePeople(rs.getString("TABLE_PEOPLE"));
                    cafeTable.setName(rs.getString("NAME"));

                    MenuIn menuIn = new MenuIn();
                    menuIn.setId(rs.getLong("menu_in_id"));
                    menuIn.setMenyuInName(rs.getString("MENYU_IN_NAME"));
                    menuIn.setPrice(rs.getFloat("menyu_price"));

                    Menu menu = new Menu();
                    menu.setId(rs.getLong("menu_id"));
                    menu.setName(rs.getString("MENYU_NAME"));

                    menuIn.setMenu(menu);
                    sifaris.setMenuIn(menuIn);
                    sifarisMasa.setSifaris(sifaris);
                    sifarisMasa.setCafeTable(cafeTable);

                    sifarisMasaList.add(sifarisMasa);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return sifarisMasaList;
    }

    @Override
    public boolean update(Sifaris sifaris, Long id) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE SIFARIS SET RES_NAME = ? , SAY = ? , PRICE = ? , MENU_IN_ID = ?, REQUEST = ? WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, sifaris.getResName());
                ps.setInt(2, sifaris.getSay());
                ps.setFloat(3, sifaris.getPrice());
                ps.setLong(4, sifaris.getMenuIn().getId());
                ps.setString(5, sifaris.getSifaris());
                ps.setLong(6, id);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean updateForMasaId(Long sifarisMasaId, Long masaId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE SIFARIS_MASA SET CAFE_TABLE_ID = ? WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, masaId);
                ps.setLong(2, sifarisMasaId);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean deleteSifaris(Long sifarisId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE SIFARIS SET ACTIVE = 0 WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, sifarisId);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean deleteSifarisMasa(Long sifarisMasaId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE SIFARIS_MASA SET ACTIVE = 0 WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, sifarisMasaId);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean add(Paid paid) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO PAID(ID,sifaris_masa_ID,PRICE) VALUES (PAID_SEQ.NEXTVAL,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, paid.getSifarisMasa().getId());
                ps.setFloat(2, paid.getPrice());
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean deleteSifarisMasaForMasaId(Long masaId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE SIFARIS_MASA SET ACTIVE = 0 WHERE CAFE_TABLE_ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, masaId);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public List<Paid> getPaidList() throws Exception {
        List<Paid> paidList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,PAID.ID,PAID.PRICE,PAID.PAID_DATE,CAFE_TABLE.ID masa_id,CAFE_TABLE.NAME,CAFE_TABLE.TABLE_PEOPLE  FROM PAID "
                + " INNER JOIN SIFARIS_MASA ON SIFARIS_MASA.ID = PAID.SIFARIS_MASA_ID "
                + " INNER JOIN CAFE_TABLE ON SIFARIS_MASA.CAFE_TABLE_ID = CAFE_TABLE.ID WHERE PAID.ACTIVE = 1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Paid paid = new Paid();
                    CafeTable cafeTable = new CafeTable();
                    Sifaris_Masa sifarisMasa = new Sifaris_Masa();

                    paid.setId(rs.getLong("ID"));
                    paid.setRownum(rs.getLong("r"));
                    paid.setPrice(rs.getFloat("PRICE"));
                    paid.setPaidDate(rs.getDate("PAID_DATE"));

                    cafeTable.setId(rs.getLong("masa_id"));
                    cafeTable.setName(rs.getString("NAME"));
                    cafeTable.setTablePeople(rs.getString("TABLE_PEOPLE"));

                    sifarisMasa.setCafeTable(cafeTable);
                    paid.setSifarisMasa(sifarisMasa);

                    paidList.add(paid);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return paidList;
    }

    @Override
    public List<Paid> advancedSearch(AdvancedSearch advancedSearch) throws Exception {
        List<Paid> paidList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,PAID.ID,PAID.PRICE,PAID.PAID_DATE,CAFE_TABLE.ID masa_id,CAFE_TABLE.NAME,CAFE_TABLE.TABLE_PEOPLE  FROM PAID "
                + " INNER JOIN SIFARIS_MASA ON SIFARIS_MASA.ID = PAID.SIFARIS_MASA_ID "
                + " INNER JOIN CAFE_TABLE ON SIFARIS_MASA.CAFE_TABLE_ID = CAFE_TABLE.ID WHERE PAID.ACTIVE = 1 ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                if (advancedSearch.getCafeTable().getId() != 0) {
                    sql += " AND CAFE_TABLE.ID = " + advancedSearch.getCafeTable().getId();
                }
                if (advancedSearch.getBeginDate() != null) {
                    sql += " AND PAID.PAID_DATE >= TO_DATE('" + new java.sql.Date(advancedSearch.getBeginDate().getTime()) + "' , 'YYYY-MM-DD')";
                }
                if (advancedSearch.getEndDate() != null) {
                    sql += " AND PAID.PAID_DATE <= TO_DATE('" + new java.sql.Date(advancedSearch.getEndDate().getTime()) + "' , 'YYYY-MM-DD')";
                }
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Paid paid = new Paid();
                    CafeTable cafeTable = new CafeTable();
                    Sifaris_Masa sifarisMasa = new Sifaris_Masa();

                    paid.setId(rs.getLong("ID"));
                    paid.setRownum(rs.getLong("r"));
                    paid.setPrice(rs.getFloat("PRICE"));
                    paid.setPaidDate(rs.getDate("PAID_DATE"));

                    cafeTable.setId(rs.getLong("masa_id"));
                    cafeTable.setName(rs.getString("NAME"));
                    cafeTable.setTablePeople(rs.getString("TABLE_PEOPLE"));

                    sifarisMasa.setCafeTable(cafeTable);
                    paid.setSifarisMasa(sifarisMasa);

                    paidList.add(paid);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return paidList;
    }

    @Override
    public boolean deleteSifarisByMasaId(Long id) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE SIFARIS SET ACTIVE = 0 WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public List<Product> getProductList() throws Exception {
        List<Product> productList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,ID,PRODUCT_NAME,SAY,PRICE FROM PRODUCT WHERE ACTIVE = 1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getLong("ID"));
                    product.setRownum(rs.getLong("r"));
                    product.setProductName(rs.getString("PRODUCT_NAME"));
                    product.setSay(rs.getInt("SAY"));
                    product.setPrice(rs.getFloat("PRICE"));

                    productList.add(product);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return productList;
    }

    @Override
    public boolean add(Product product) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO product(ID,PRODUCT_NAME,SAY,PRICE) "
                + " VALUES(PRODUCT_SEQ.nextval,?,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, product.getProductName());
                ps.setInt(2, product.getSay());
                ps.setFloat(3, product.getPrice());
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean update(Product product, Long id) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE PRODUCT SET PRODUCT_NAME = ?,SAY = ?,PRICE = ? WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, product.getProductName());
                ps.setInt(2, product.getSay());
                ps.setFloat(3, product.getPrice());
                ps.setLong(4, id);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public List<Product> searcProducts(String keyword) throws Exception {
        List<Product> productList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,ID,PRODUCT_NAME,SAY,PRICE FROM PRODUCT WHERE (ACTIVE = 1) AND (LOWER(PRODUCT_NAME) LIKE LOWER(?) "
                + " OR LOWER(SAY) LIKE LOWER(?) OR LOWER(PRICE) LIKE LOWER(?))";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getLong("ID"));
                    product.setRownum(rs.getLong("r"));
                    product.setProductName(rs.getString("PRODUCT_NAME"));
                    product.setSay(rs.getInt("SAY"));
                    product.setPrice(rs.getFloat("PRICE"));

                    productList.add(product);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return productList;
    }

    @Override
    public boolean deleteProduct(Long id) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE PRODUCT SET ACTIVE = 0 WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public Product getProductById(Long id) throws Exception {
        Product product = new Product();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,ID,PRODUCT_NAME,SAY,PRICE FROM PRODUCT WHERE ACTIVE = 1 AND ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {

                    product.setId(rs.getLong("ID"));
                    product.setRownum(rs.getLong("r"));
                    product.setProductName(rs.getString("PRODUCT_NAME"));
                    product.setSay(rs.getInt("SAY"));
                    product.setPrice(rs.getFloat("PRICE"));

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return product;
    }

    @Override
    public List<Product> advancedSearchProduct(AdvancedSearch advancedSearch) throws Exception {
        List<Product> productList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,ID,PRODUCT_NAME,SAY,PRICE FROM PRODUCT WHERE ACTIVE = 1 ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                if (advancedSearch.getMinSay() != null && !advancedSearch.getMinSay().isEmpty()) {
                    sql += " AND SAY >= " + advancedSearch.getMinSay();
                }
                if (advancedSearch.getMaxSay() != null && !advancedSearch.getMaxSay().isEmpty()) {
                    sql += " AND SAY <= " + advancedSearch.getMaxSay();
                }
                if (advancedSearch.getBeginPrice() != null && !advancedSearch.getBeginPrice().isEmpty()) {
                    sql += " AND PRICE >= " + advancedSearch.getBeginPrice();
                }
                if (advancedSearch.getEndPrice() != null && !advancedSearch.getEndPrice().isEmpty()) {
                    sql += " AND PRICE <= " + advancedSearch.getEndPrice();
                }
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getLong("ID"));
                    product.setRownum(rs.getLong("r"));
                    product.setProductName(rs.getString("PRODUCT_NAME"));
                    product.setSay(rs.getInt("SAY"));
                    product.setPrice(rs.getFloat("PRICE"));

                    productList.add(product);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return productList;
    }

    @Override
    public List<Login> getLoginList() throws Exception {
        List<Login> loginList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT LOGIN.ID,LOGIN.USERNAME,LOGIN.PASSWORD,ROLE.ID role_id,ROLE.ROLE_NAME FROM LOGIN "
                + " INNER JOIN ROLE ON LOGIN.ROLE_ID = ROLE.ID WHERE LOGIN.ACTIVE = 1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Login login = new Login();
                    login.setId(rs.getLong("ID"));
                    login.setUsername(rs.getString("USERNAME"));
                    login.setPassword(rs.getString("PASSWORD"));

                    Role role = new Role();
                    role.setId(rs.getLong("role_id"));
                    role.setRoleName(rs.getString("ROLE_NAME"));

                    loginList.add(login);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return loginList;
    }

    @Override
    public Login checkLogin(String username, String password) throws Exception {
        Login login = new Login();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT LOGIN.ID,LOGIN.USERNAME,LOGIN.PASSWORD,ROLE.ID role_id,ROLE.ROLE_NAME FROM LOGIN "
                + " INNER JOIN ROLE ON LOGIN.ROLE_ID = ROLE.ID WHERE ((LOGIN.ACTIVE = 1) AND (LOGIN.USERNAME = ? AND LOGIN.PASSWORD = ?))";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    login.setId(rs.getLong("ID"));
                    login.setUsername(rs.getString("USERNAME"));
                    login.setPassword(rs.getString("PASSWORD"));

                    Role role = new Role();
                    role.setId(rs.getLong("role_id"));
                    role.setRoleName(rs.getString("ROLE_NAME"));
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return login;
    }

    @Override
    public Login checkLoginByUsername(String username) throws Exception {
        Login login = new Login();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT LOGIN.ID,LOGIN.USERNAME,LOGIN.PASSWORD,ROLE.ID role_id,ROLE.ROLE_NAME FROM LOGIN "
                + " INNER JOIN ROLE ON LOGIN.ROLE_ID = ROLE.ID WHERE ((LOGIN.ACTIVE = 1) AND (LOGIN.USERNAME = ?))";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, username);
                rs = ps.executeQuery();
                if (rs.next()) {
                    login.setId(rs.getLong("ID"));
                    login.setUsername(rs.getString("USERNAME"));
                    

                    Role role = new Role();
                    role.setId(rs.getLong("role_id"));
                    role.setRoleName(rs.getString("ROLE_NAME"));
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return login;
    }

    @Override
    public Login checkLoginByPassword(String password, Long id) throws Exception {
        Login login = new Login();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT LOGIN.ID,LOGIN.USERNAME,LOGIN.PASSWORD,ROLE.ID role_id,ROLE.ROLE_NAME FROM LOGIN "
                + " INNER JOIN ROLE ON LOGIN.ROLE_ID = ROLE.ID WHERE ((LOGIN.ACTIVE = 1) AND (LOGIN.PASSWORD = ? AND LOGIN.ID = ?))";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, password);
                ps.setLong(2, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    login.setId(rs.getLong("ID"));
                    login.setUsername(rs.getString("USERNAME"));
                    login.setPassword(rs.getString("PASSWORD"));

                    Role role = new Role();
                    role.setId(rs.getLong("role_id"));
                    role.setRoleName(rs.getString("ROLE_NAME"));
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return login;
    }

}
