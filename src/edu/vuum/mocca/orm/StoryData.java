
package edu.vuum.mocca.orm;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Custom ORM container class, for Story Data.
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
public class StoryData implements Parcelable {

	public final long KEY_ID;
	public long loginId;
	public long storyId;
	public String title;
	public String body;
	public String audioLink;
	public String videoLink;
	public String imageName;
	public String imageLink;
	public String tags;
	public long creationTime;
	public long storyTime;
	public double latitude;
	public double longitude;

	/**
	 * Constructor WITHOUT _id, this creates a new object for insertion into the
	 * ContentProvider
	 * 
	 * @param loginId
	 * @param storyId
	 * @param title
	 * @param body
	 * @param audioLink
	 * @param videoLink
	 * @param imageName
	 * @param imageLink
	 * @param tags
	 * @param creationTime
	 * @param storyTime
	 * @param latitude
	 * @param longitude
	 */
	public StoryData(long loginId, long storyId, String title, String body,
			String audioLink, String videoLink, String imageName,
			String imageMetaData, String tags, long creationTime,
			long storyTime, double latitude, double longitude) {
		this.KEY_ID = -1;
		this.loginId = loginId;
		this.storyId = storyId;
		this.title = title;
		this.body = body;
		this.audioLink = audioLink;
		this.videoLink = videoLink;
		this.imageName = imageName;
		this.imageLink = imageMetaData;
		this.tags = tags;
		this.creationTime = creationTime;
		this.storyTime = storyTime;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * Constructor WITH _id, this creates a new object for use when pulling
	 * already existing object's information from the ContentProvider
	 * 
	 * @param KEY_ID
	 * @param loginId
	 * @param storyId
	 * @param title
	 * @param body
	 * @param audioLink
	 * @param videoLink
	 * @param imageName
	 * @param imageLink
	 * @param tags
	 * @param creationTime
	 * @param storyTime
	 * @param latitude
	 * @param longitude
	 */
	public StoryData(long KEY_ID, long loginId, long storyId, String title,
			String body, String audioLink, String videoLink, String imageName,
			String imageLink, String tags, long creationTime,
			long storyTime, double latitude, double longitude) {
		this.KEY_ID = KEY_ID;
		this.loginId = loginId;
		this.storyId = storyId;
		this.title = title;
		this.body = body;
		this.audioLink = audioLink;
		this.videoLink = videoLink;
		this.imageName = imageName;
		this.imageLink = imageLink;
		this.tags = tags;
		this.creationTime = creationTime;
		this.storyTime = storyTime;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * Override of the toString() method, for testing/logging
	 */
	@Override
	public String toString() {
		return " loginId: " + loginId + " storyId: " + storyId + " title: "
				+ title + " body: " + body + " audioLink: " + audioLink
				+ " videoLink: " + videoLink + " imageName: " + imageName
				+ " imageLink: " + imageLink + " tags: " + tags
				+ " creationTime: " + creationTime + " storyTime: " + storyTime
				+ " latitude: " + latitude + " longitude: " + longitude;
	}

	/**
	 * Helper Method that allows easy conversion of object's data into an
	 * appropriate ContentValues
	 * 
	 * @return contentValues A new ContentValues object
	 */
	public ContentValues getCV() {
		return StoryCreator.getCVfromStory(this);
	}

	/**
	 * Clone this object into a new StoryData
	 */
	public StoryData clone() {
		return new StoryData(loginId, storyId, title, body, audioLink,
				videoLink, imageName, imageLink, tags, creationTime,
				storyTime, latitude, longitude);
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
		dest.writeString(title);
		dest.writeString(body);
		dest.writeString(audioLink);
		dest.writeString(videoLink);
		dest.writeString(imageName);
		dest.writeString(imageLink);
		dest.writeString(tags);
		dest.writeLong(creationTime);
		dest.writeLong(storyTime);
		dest.writeDouble(latitude);
		dest.writeDouble(longitude);
	}

	/**
	 * Used for writing a copy of this object to a Parcel, do not manually call.
	 */
	public static final Parcelable.Creator<StoryData> CREATOR = new Parcelable.Creator<StoryData>() {
		public StoryData createFromParcel(Parcel in) {
			return new StoryData(in);
		}

		public StoryData[] newArray(int size) {
			return new StoryData[size];
		}
	};

	/**
	 * Used for writing a copy of this object to a Parcel, do not manually call.
	 */
	private StoryData(Parcel in) {
		KEY_ID = in.readLong();
		loginId = in.readLong();
		storyId = in.readLong();
		title = in.readString();
		body = in.readString();
		audioLink = in.readString();
		videoLink = in.readString();
		imageName = in.readString();
		imageLink = in.readString();
		tags = in.readString();
		creationTime = in.readLong();
		storyTime = in.readLong();
		latitude = in.readDouble();
		longitude = in.readDouble();
	}

}
