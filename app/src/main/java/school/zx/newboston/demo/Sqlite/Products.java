package school.zx.newboston.demo.Sqlite;

/**
 * Created by THink on 2018/3/24.
 */

public class Products {

    private int _id;
    private String _productname;

    //Set the _productname property equal to the product name that has been typed in
    public Products(String productname) {
        this._productname = productname;
    }

    //Give the opject the property
    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_productname(String _productname) {
        this._productname = _productname;
    }

    //Retrieve value;
    public int get_id() {
        return _id;
    }

    public String get_productname() {
        return _productname;
    }
}
