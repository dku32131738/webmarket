//join
package connect;

import connect.Connect;
import connect.Base;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Join extends Base{
	private Connect con;
	private String id,name,email,pw,sex,confirm; //data
	private int age; //data
	private Gson gson;
	private JsonObject message; //request
	private boolean is_join; //is success
	
	public Join() {
		this.con=new Connect();
		this.gson=new Gson();
		this.con.setURL("http://ec2-54-180-20-247.ap-northeast-2.compute.amazonaws.com/account/signup"
				+ "?format=json"); //set url
	}
	
	public void input(String id,String name,String email,String pw,String age,String sex,String confirm) { //input data
		this.id=id;
		this.name=name;
		this.email=email;
		this.pw=pw;
		this.age=Integer.parseInt(age);
		this.sex=sex;
		this.confirm=confirm;
		this.message=new JsonObject();
		this.message.addProperty("Account_ID", this.id);
		this.message.addProperty("Account_name", this.name);
		this.message.addProperty("Account_email", this.email);
		this.message.addProperty("Account_password",this.pw);
		this.message.addProperty("Account_age", this.age);
		this.message.addProperty("Account_sex", this.sex);
		this.message.addProperty("confirm_password", this.confirm);
	}
	
	public boolean access() //send request and access server
	{	
		this.con.setmessage(gson.toJson(this.message));
		this.is_join=this.con.post(); //method post
		return this.is_join;
	}
	
	public boolean get_is_login() { //is login
		return this.is_join;
	}
	
}