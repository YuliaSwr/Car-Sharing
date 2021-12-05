package carsharing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDaoImpl implements CompanyDao {

    List<Company> companies;

    Connection connection = H2Database.getConnection();

    public CompanyDaoImpl() {
        companies = new ArrayList<>();
    }

    /**
     * Returns list of all companies from database
     *
     * @return         full list of companies from database
     */
    @Override
    public List<Company> getAllCompanies() {
        return companies;
    }

    /*
    public Company getCompany(int id) {
        return companies.stream()
                .filter(x -> x.getId() == id)
                .collect(Collectors.toList())
                .get(0);
    }*/

    /**
     * Add to database a new company
     *
     * @param  company   new Company for adding to database
     */
    @Override
    public void addCompany(Company company) {
        try {
            H2Database.insertRecord(company.getId(), company.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        companies.add(company);
    }

    /**
     * Returns number of database elements
     *
     * @return         integer value
     */
    public int size() {
        return companies.size();
    }
}
