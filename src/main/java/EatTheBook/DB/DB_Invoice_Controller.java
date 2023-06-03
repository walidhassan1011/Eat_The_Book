package EatTheBook.DB;

import EatTheBook.Helpers.AlertHandlerError;
import EatTheBook.Models.Invoice;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

public class DB_Invoice_Controller {
    /**
     * @desc: this func will create a new invoice
     * @return: void
     * @params: Invoice invoice
     * @example: DB_Invoice_Controller.addInvoice(invoice);
    * */

        public static ObjectId addInvoice(Invoice invoice) {
        try {
            MongoCollection collection = DB_helpers.getCollection("Invoices");
            Document document = new Document();
            document.append("studentNo", invoice.getStudentNo());
            document.append("bookName", invoice.getBooksName());
            document.append("price", invoice.getPrice());
            document.append("_id", invoice.get_id());
            document.append("orderId", invoice.getOrderId());
            collection.insertOne(document);
            return invoice.get_id();
        } catch (Exception e) {
            AlertHandlerError.showAlert("Error", "Error while adding invoice", "Error while adding invoice");
            throw new RuntimeException(e.getMessage());
        }
    }



}
