package discountstrategy;

/**
 *
 * @author L117student
 */
public class PosRegister {
    
    private ReceiptDataAccessStrategy database;
    private ReceiptOutputStrategy receiptType;
    private ReceiptGeneratorService receiptGenerator;
    
    public PosRegister(ReceiptDataAccessStrategy prodDatabase, ReceiptOutputStrategy receiptType) {
        this.setDatabase(prodDatabase);
        this.setReceiptType(receiptType);
    }

    public final void startNewSale(String storeInfo, String customerID) {
        receiptGenerator = new ReceiptGeneratorService(storeInfo, receiptType, database, customerID);
    }
    
    public final void addItem(String productID, int qty) {
        receiptGenerator.addItem(productID, qty);
    }
    public final void endSale() {
        receiptGenerator.generateReceipt(receiptGenerator.getReceipt());
    }
    public final ReceiptDataAccessStrategy getDatabase() {
        return database;
    }

    public final void setDatabase(ReceiptDataAccessStrategy database) {
        if(database == null) {
            throw new IllegalArgumentException("There must be a database");
        }
        this.database = database;
    }

    public final ReceiptOutputStrategy getReceiptType() {
        return receiptType;
    }

    public final void setReceiptType(ReceiptOutputStrategy receiptType) {
        if(receiptType == null) {
            throw new IllegalArgumentException("There must be a receipt type");
        }
        this.receiptType = receiptType;
    }

    public final ReceiptGeneratorService getReceiptGenerator() {
        return receiptGenerator;
    }

    public final void setReceiptGenerator(ReceiptGeneratorService receiptGenerator) {
        if(receiptGenerator == null) {
            throw new IllegalArgumentException("There must be a receiptGenerator");
        }
        this.receiptGenerator = receiptGenerator;
    }
}
