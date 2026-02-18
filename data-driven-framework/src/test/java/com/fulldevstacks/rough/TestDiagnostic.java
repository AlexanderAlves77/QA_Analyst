package com.fulldevstacks.rough;

import java.io.File;
import java.util.Properties;
import com.fulldevstacks.base.TestBase;

public class TestDiagnostic 
{
    public static void main(String[] args) 
    {
        System.out.println("========== DIAGNÓSTICO DO FRAMEWORK ==========");
        
        // 1. Verificar diretório atual
        System.out.println("1. User directory: " + System.getProperty("user.dir"));
        
        // 2. Verificar arquivos de propriedades
        File configFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
        File orFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
        File excelFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
        
        System.out.println("2. Config.properties exists: " + configFile.exists());
        System.out.println("   OR.properties exists: " + orFile.exists());
        System.out.println("   testdata.xlsx exists: " + excelFile.exists());
        
        // 3. Tentar carregar properties
        try 
        {
            Properties config = new Properties();
            config.load(new java.io.FileInputStream(configFile));
            System.out.println("3. Config loaded successfully!");
            System.out.println("   browser = " + config.getProperty("browser"));
            System.out.println("   implicit.wait = " + config.getProperty("implicit.wait"));
            System.out.println("   testsiteurl = " + config.getProperty("testsiteurl"));
        } catch (Exception e) 
        {
            System.out.println("3. ERROR loading Config: " + e.getMessage());
        }
        
        // 4. Tentar carregar OR
        try 
        {
            Properties or = new Properties();
            or.load(new java.io.FileInputStream(orFile));
            System.out.println("4. OR loaded successfully!");
            System.out.println("   Total OR keys: " + or.size());
            System.out.println("   OR keys: " + or.keySet());
            System.out.println("   bmlBtn = '" + or.getProperty("bmlBtn") + "'");
            System.out.println("   addcustbtn = '" + or.getProperty("addcustbtn") + "'");
        } catch (Exception e) 
        {
            System.out.println("4. ERROR loading OR: " + e.getMessage());
        }
        
        // 5. Verificar Excel
        try 
        {
            com.fulldevstacks.utilities.ExcelReader excel = 
                new com.fulldevstacks.utilities.ExcelReader(excelFile.getAbsolutePath());
            System.out.println("5. Excel loaded successfully!");
            System.out.println("   AddCustomerTest sheet exists: " + excel.isSheetExist("AddCustomerTest"));
            System.out.println("   Rows in AddCustomerTest: " + excel.getRowCount("AddCustomerTest"));
            System.out.println("   Columns in AddCustomerTest: " + excel.getColumnCount("AddCustomerTest"));
        } catch (Exception e) 
        {
            System.out.println("5. ERROR loading Excel: " + e.getMessage());
        }
        
        System.out.println("========== FIM DO DIAGNÓSTICO ==========");
    }
}
