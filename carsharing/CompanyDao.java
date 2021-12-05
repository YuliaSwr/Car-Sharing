package carsharing;

import java.util.List;

public interface CompanyDao {

    /**
     * Returns list of all companies from database
     *
     * @return         full list of companies from database
     */
    List<Company> getAllCompanies();

    /**
     * Add to database a new company
     *
     * @param  company   new Company for adding to database
     */
    void addCompany(Company company);
}
