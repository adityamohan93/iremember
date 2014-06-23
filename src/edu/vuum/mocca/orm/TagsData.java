
package edu.vuum.mocca.orm;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Custom ORM container class, for Tags Data.
 * <p>
 * This class is meant as a helper class for those working with the
 * ContentProvider. The use of this class is completely optional.
 * <p>
 * ORM = Object Relational Mapping
 * http://en.wikipedia.org/wiki/Object-relational_mapping
 * <p>
 * This class is a simple one-off POJO class with some simple ORM additions that
 * allow for conversion between the incompatible types of the POJO java classes,
 * the 'ContentValues', and the 'Cursor' classes from the use with
 * ContentProviders.
 * 
 * @author Michael A. Walker
 * 
 */

public class TagsData implements Parcelable {

	public final long KEY_ID;
	public long loginId;
	public long storyId;
	public String tag;

	/**
	 * Constructor WITHOUT _id, this creates a new object for insertion into the
	 * ContentProvider
	 * 
	 * @param loginId
	 * @param storyId
	 * @param tag
	 */
	public TagsData(long loginId, long storyId, String tag) {
		KEY_ID = -1;
		this.loginId = loginId;
		this.storyId = storyId;
		this.tag = tag;
	}

	/**
	 * Constructor WITH _id, this creates a new object for use when pulling
	 * already existing objects' information from the ContentProvider
	 * 
	 * @param KEY_ID
	 * @param loginId
	 * @param storyId
	 * @param tag
	 */
	public TagsData(long KEY_ID, long loginId, long storyId, String tag) {
		this.KEY_ID = KEY_ID;
		this.loginId = loginId;
		this.storyId = storyId;
		this.tag = tag;
	}

	@Override
	/**
	 * Override of the toString() method, for testing/logging
	 */
	public String toString() {
		return " loginId: " + loginId + " storyId: " + storyId + " tag: " + tag;
	}

	/**
	 * Helper Method that allows easy conversion of object's data into an
	 * appropriate ContentValues
	 * 
	 * @return contentValues A new ContentValues object
	 */
	public ContentValues getCV() {
		return TagsCreator.getCVfromTags(this);
	}

	/**
	 * Clone this object into a new TagsData
	 */
	public TagsData clone() {
		return new TagsData(loginId, storyId, tag);
	}

	// these are for parcelable interface
	@Override
	/**
	 * Used for writing a copy of this object to a Parcel, do not manually call.
	 */
	public int describeContents() {
		return 0;
	}

	@Override
	/**
	 * Used for writing a copy of this object to a Parcel, do not manually call.
	 */
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(KEY_ID);
		dest.writeLong(loginId);
		dest.writeLong(storyId);
		dest.writeString(tag);
	}

	/**
	 * Used for writing a copy of this object to a Parcel, do not manually call.
	 */
	public static final Parcelable.Creator<TagsData> CREATOR = new Parcelable.Creator<TagsData>() {
		public TagsData createFromParcel(Parcel in) {
			return new TagsData(in);
		}

		public TagsData[] newArray(int size) {
			return new TagsData[size];
		}
	};

	/**
	 * Used for writing a copy of this object to a Parcel, do not manually call.
	 */
	private TagsData(Parcel in) {
		KEY_ID = in.readLong();
		loginId = in.readLong();
		storyId = in.readLong();
		tag = in.readString();
	}

}
