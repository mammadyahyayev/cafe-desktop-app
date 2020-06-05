package dao;

import java.util.List;
import model.AdvancedSearch;
import model.CafeTable;
import model.Login;

import model.Menu;
import model.MenuIn;
import model.Paid;
import model.Product;
import model.Sifaris;
import model.Sifaris_Masa;

import model.TableStatus;

public interface DaoInterface {

    List<CafeTable> getCafeTableList() throws Exception;

    List<Menu> getMenuList() throws Exception;

    List<MenuIn> getMenuInList() throws Exception;

    List<TableStatus> getTableStatusList() throws Exception;

    List<MenuIn> getMenuInListById(Long id) throws Exception;

    boolean add(MenuIn menuIn, Long id) throws Exception;

    MenuIn getMenuInById(Long menuInId, Long menuId) throws Exception;

    boolean add(Menu menu) throws Exception;

    Menu getMenuById(Long id) throws Exception;

    boolean update(MenuIn menuIn, Long menuInId, Long menuId) throws Exception;

    boolean update(Menu menu, Long id) throws Exception;

    boolean deleteMenuIn(Long id, Long menuId) throws Exception;

    boolean deleteMenu(Long id) throws Exception;

    List<MenuIn> searchMenuIn(String keyword, Long menuId) throws Exception;

    List<Menu> searchMenu(String keyword) throws Exception;

    List<MenuIn> getMenuInListByMenuId(Long id) throws Exception;

    boolean updateTableStatus(Long id) throws Exception;

    boolean updateTableStatusForK(Long id) throws Exception;

    boolean updateTableStatusForEmpty(Long id) throws Exception;

    boolean updateTableStatusForKForEmpty(Long id) throws Exception;

    List<Sifaris> getSifarisList() throws Exception;

    List<Sifaris_Masa> getSifarisMasaList() throws Exception;

    boolean add(Sifaris sifaris) throws Exception;

    boolean addSifarisMasa(Long sifarisId, Long masaId) throws Exception;

    Sifaris_Masa getSifarisMasaById(Long id) throws Exception;

    List<Sifaris_Masa> getSifarisMasaByMasaId(Long id) throws Exception;

    boolean update(Sifaris sifaris, Long id) throws Exception;

    boolean updateForMasaId(Long sifarisMasaId, Long masaId) throws Exception;

    boolean deleteSifaris(Long sifarisId) throws Exception;

    boolean deleteSifarisMasa(Long sifarisMasaId) throws Exception;

    boolean add(Paid paid) throws Exception;

    boolean deleteSifarisMasaForMasaId(Long masaId) throws Exception;

    List<Paid> getPaidList() throws Exception;

    List<Paid> advancedSearch(AdvancedSearch advancedSearch) throws Exception;

    boolean deleteSifarisByMasaId(Long id) throws Exception;

    List<Product> getProductList() throws Exception;

    boolean add(Product product) throws Exception;

    boolean update(Product product, Long id) throws Exception;

    List<Product> searcProducts(String keyword) throws Exception;

    boolean deleteProduct(Long id) throws Exception;

    Product getProductById(Long id) throws Exception;

    List<Product> advancedSearchProduct(AdvancedSearch advancedSearch) throws Exception;

    List<Login> getLoginList() throws Exception;

    Login checkLogin(String username, String password) throws Exception;

    Login checkLoginByUsername(String username) throws Exception;

    Login checkLoginByPassword(String password, Long id) throws Exception;

}
