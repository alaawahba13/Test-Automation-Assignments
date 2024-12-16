package base;

import org.testng.annotations.DataProvider;

public class Data {
    @DataProvider(name = "login")
    public static Object[][] getCredentials() {
        return new Object[][]{
                {
                        "", "", "Please fill out this field.", "tooltip"
                },
                {
                        "alaawahbaa13@gmail.com", "123", "Your email or password is incorrect!", "error"
                },
                {
                        "alaawahbaa13@gmail", "1234567", "Your email or password is incorrect!", "error"
                },
                {
                        "alaawahbaa13gmail.com", "1234567", "Please include an '@' in the email address.", "tooltip"
                }
        };
    }

    @DataProvider(name = "signup")
    public static Object[][] signupData() {
        return new Object[][]{
                {
                        "", "", "Please fill out this field.", "tooltip"
                },
                {
                        "alaa", "alaawahbaa13@gmail.com", "Email Address already exist!", "error"
                }
        };
    }

    @DataProvider(name = "category")
    public Object[][] categoryData() {
        return new Object[][]{
                {
                      "Women", "Saree"
                },
                {
                        "Men","Jeans"
                },
                {
                    "Kids","Tops & Shirts"
                },
        };
    }
    @DataProvider(name = "brand")
    public Object[] brandData() {
        return new Object[]{
                "POLO","H&M","BABYHUG","KOOKIE KIDS"
        };
    }

    @DataProvider(name = "index")
    public Object[] getIndex() {
        return new Object[]{
                1,2,3
        };
    }

}
