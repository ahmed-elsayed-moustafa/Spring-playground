package ume.pareva.springboot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@Table(name = "credentialservice")
@Entity(name = "credentialservice")
public class CredentialService {

	@Id
	@Column(name = "Credential_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Credential_ID;

	@Column(name = "subsId")
	private String subsId;

	@Column(name = "trans_id")
	private String trans_id;

	@Column(name = "securekey")
	private String securekey;

	public CredentialService() {
	}

	public CredentialService(String subsId, String trans_id, String securekey) {
		this.subsId = subsId;
		this.trans_id = trans_id;
		this.securekey = securekey;
	}

	public int getCredential_ID() {
		return Credential_ID;
	}

	public void setCredential_ID(int credential_ID) {
		Credential_ID = credential_ID;
	}

	public String getSubsId() {
		return subsId;
	}

	public void setSubsId(String subsId) {
		this.subsId = subsId;
	}

	public String getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(String trans_id) {
		this.trans_id = trans_id;
	}

	public String getSecurekey() {
		return securekey;
	}

	public void setSecurekey(String securekey) {
		this.securekey = securekey;
	}

	public JSONObject JSONResponse() {
		JSONObject obj = new JSONObject();
		obj.put("result", new Integer(1));
		obj.put("msg", "abc");
		obj.put("login", "user123");
		obj.put("password", "password123");
		return obj;
	}

	@Override
	public String toString() {
		return "CredentialService [Credential_ID=" + Credential_ID + ", subsId=" + subsId + ", trans_id=" + trans_id
				+ ", securekey=" + securekey + "]";
	}

}
