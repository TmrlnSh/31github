package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DatabaseUtils;
import io.cucumber.java.en.And;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseSteps {
    @And("verify new account details updated in database")
    public void verifyNewAccountDetailsUpdatedInDatabase() throws Exception {
        String accountNum = ConfigReader.getProperty("account.number");
        String query = "select * from account where account_number = '%s';";
        ResultSet rs = DatabaseUtils.executeQuery(String.format(query, accountNum));
        rs.next();

        double openingBalanceDB = rs.getDouble("opening_balance");
        double openingBalanceUI = Double.valueOf(ConfigReader.getProperty("transaction.amount"));
        System.out.println("Balance from DB " + openingBalanceDB);
        System.out.println("Balance from UI " + openingBalanceUI);
        Assert.assertTrue(openingBalanceDB == openingBalanceUI);

        String accountNameUI = ConfigReader.getProperty("account.name");
        String accountNameDB = rs.getString("name");
        System.out.println("Account name from DB " + accountNameDB);
        System.out.println("Account name from UI " + accountNameUI);
        Assert.assertTrue(accountNameDB.equals(accountNameUI));
    }


}
