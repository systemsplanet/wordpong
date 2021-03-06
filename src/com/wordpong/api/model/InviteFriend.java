package com.wordpong.api.model;

import java.io.Serializable;
import java.util.Date;

import net.sourceforge.stripes.util.CryptoUtil;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slim3.datastore.Attribute;
import org.slim3.datastore.CreationDate;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModificationDate;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.wordpong.util.ImageUtil;
import com.wordpong.util.TimeUtil;

// Sent to a existing or non-members of wordpong to invite them to join
// updated once user registers with word pong
// deleted when invite is accepted or denied

@Model(schemaVersion = 1)
public class InviteFriend implements Serializable {

	private static final long serialVersionUID = 1L;

	@Attribute(primaryKey = true)
	private Key key;

	@Attribute(version = true)
	private Long version;

	@Attribute(listener = CreationDate.class)
	private Date createdAt;

	@Attribute(listener = ModificationDate.class)
	Date updatedAt;

	// FROM ENVITER

	@Attribute(unindexed = false)
	private Key inviterKey;

	// "FN LN (Email)"
    @Attribute(unindexed = true)
    private String inviterDetails;
    
    @Attribute(unindexed = true)
    private String inviterPictureUrl;

	
	// TO INVITEE

	@Attribute(unindexed = false)
	private Key inviteeKey;

	// "Email" or "FN LN (Email)"
	@Attribute(unindexed = false)
	private String inviteeDetails;

	// STATE
	@Attribute(unindexed = true)
	private boolean isIgnored = false;

	// GETTERS/SETTERS
	public Key getKey() {
		return key;
	}

	public String getKeyString() {
		String k = KeyFactory.keyToString(key);
		return k;
	}

	public String getKeyStringEncrypted() {
		String ks = getKeyString();
		String keyEncrypted = CryptoUtil.encrypt(ks);
		return keyEncrypted;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getCreatedAtString() {
		return TimeUtil.getElapsedTimeString(createdAt);
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAtString() {
		return TimeUtil.getElapsedTimeString(updatedAt);
	}

	public Key getInviterKey() {
		return inviterKey;
	}

	public void setInviterKey(Key inviterKey) {
		this.inviterKey = inviterKey;
	}

	public String getInviterDetails() {
		return inviterDetails;
	}

	public String getInviterPictureUrl() {
        return inviterPictureUrl;
    }

    public void setInviterPictureUrl(String inviterPictureUrl) {
        this.inviterPictureUrl = inviterPictureUrl;
    }

    public String getInviterEmail() {
		String result = inviterDetails;
		if (inviterDetails != null) {
			int s = inviterDetails.indexOf("(");
			int e = inviterDetails.indexOf(")");
			if (s != -1 && e != -1) {
				result = inviterDetails.substring(s + 1, e);
			}
		} else {
			result = "?";
		}
		return result;
	}

	public void setInviterDetails(String inviterDetails) {
		if (inviterDetails != null) {
			inviterDetails = inviterDetails.trim().toLowerCase();
		}
		this.inviterDetails = inviterDetails;
	}

	public Key getInviteeKey() {
		return inviteeKey;
	}

	public void setInviteeKey(Key inviteeKey) {
		this.inviteeKey = inviteeKey;
	}

	public String getInviteeDetails() {
		return inviteeDetails;
	}

	public String getInviteeEmail() {
		String result = inviteeDetails;
		if (inviteeDetails != null) {
			int s = inviteeDetails.indexOf("(");
			int e = inviteeDetails.indexOf(")");
			if (s != -1 && e != -1) {
				result = inviteeDetails.substring(s + 1, e);
			}
		} else {
			result = "?";
		}
		return result;
	}

	public void setInviteeDetails(String inviteeDetails) {
		if (inviteeDetails != null) {
			inviteeDetails = inviteeDetails.trim().toLowerCase();
		}
		this.inviteeDetails = inviteeDetails;
	}

	public String getInviteePictureUrl() {
        String url = ImageUtil.getPictureUrl(getInviteeEmail());
        return url;
    }

	public boolean isIgnored() {
		return isIgnored;
	}

	public void setIgnored(boolean isIgnored) {
		this.isIgnored = isIgnored;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		InviteFriend other = (InviteFriend) obj;
		if (key == null) {
			if (other.key != null) {
				return false;
			}
		} else if (!key.equals(other.key)) {
			return false;
		}
		return true;
	}

	public void setInvitee(User user) {
		if (user != null) {
			setInviteeKey(user.getKey());
			setInviteeDetails(user.getDetails());
			
		}
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
