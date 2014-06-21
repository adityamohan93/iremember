
package edu.vuum.mocca.orm;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.Cursor;
import edu.vuum.mocca.provider.MoocSchema;

/**
 * StoryCreator is a helper class that does convenience functions for converting
 * between the Custom ORM objects, ContentValues, and Cursors.
 * 
 * @author Michael A. Walker
 * 
 */
public class StoryCreator {

	/**
	 * Create a ContentValues from a provided StoryData.
	 * 
	 * @param data
	 *            StoryData to be converted.
	 * @return ContentValues that is created from the StoryData object
	 */
	public static ContentValues getCVfromStory(final StoryData data) {
		ContentValues rValue = new ContentValues();
		rValue.put(MoocSchema.Story.Cols.LOGIN_ID, data.loginId);
		rValue.put(MoocSchema.Story.Cols.STORY_ID, data.storyId);
		rValue.put(MoocSchema.Story.Cols.TITLE, data.title);
		rValue.put(MoocSchema.Story.Cols.BODY, data.body);
		rValue.put(MoocSchema.Story.Cols.AUDIO_LINK, data.audioLink);
		rValue.put(MoocSchema.Story.Cols.VIDEO_LINK, data.videoLink);
		rValue.put(MoocSchema.Story.Cols.IMAGE_NAME, data.imageName);
		rValue.put(MoocSchema.Story.Cols.IMAGE_LINK, data.imageLink);
		rValue.put(MoocSchema.Story.Cols.TAGS, data.tags);
		rValue.put(MoocSchema.Story.Cols.CREATION_TIME, data.creationTime);
		rValue.put(MoocSchema.Story.Cols.STORY_TIME, data.storyTime);
		rValue.put(MoocSchema.Story.Cols.LATITUDE, data.latitude);
		rValue.put(MoocSchema.Story.Cols.LONGITUDE, data.longitude);
		return rValue;
	}

	/**
	 * Get all of the StoryData from the passed in cursor.
	 * 
	 * @param cursor
	 *            passed in cursor to get StoryData(s) of.
	 * @return ArrayList<StoryData\> The set of StoryData
	 */
	public static ArrayList<StoryData> getStoryDataArrayListFromCursor(
			Cursor cursor) {
		ArrayList<StoryData> rValue = new ArrayList<StoryData>();
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				do {
					rValue.add(getStoryDataFromCursor(cursor));
				} while (cursor.moveToNext() == true);
			}
		}
		return rValue;
	}

	/**
	 * Get the first StoryData from the passed in cursor.
	 * 
	 * @param cursor
	 *            passed in cursor
	 * @return StoryData object
	 */
	public static StoryData getStoryDataFromCursor(Cursor cursor) {

		long rowID = cursor.getLong(cursor
				.getColumnIndex(MoocSchema.Story.Cols.ID));
		long loginId = cursor.getLong(cursor
				.getColumnIndex(MoocSchema.Story.Cols.LOGIN_ID));
		long storyId = cursor.getLong(cursor
				.getColumnIndex(MoocSchema.Story.Cols.STORY_ID));
		String title = cursor.getString(cursor
				.getColumnIndex(MoocSchema.Story.Cols.TITLE));
		String body = cursor.getString(cursor
				.getColumnIndex(MoocSchema.Story.Cols.BODY));
		String audioLink = cursor.getString(cursor
				.getColumnIndex(MoocSchema.Story.Cols.AUDIO_LINK));
		String videoLink = cursor.getString(cursor
				.getColumnIndex(MoocSchema.Story.Cols.VIDEO_LINK));
		String imageName = cursor.getString(cursor
				.getColumnIndex(MoocSchema.Story.Cols.IMAGE_NAME));
		String imageMetaData = cursor.getString(cursor
				.getColumnIndex(MoocSchema.Story.Cols.IMAGE_LINK));
		String tags = cursor.getString(cursor
				.getColumnIndex(MoocSchema.Story.Cols.TAGS));
		long creationTime = cursor.getLong(cursor
				.getColumnIndex(MoocSchema.Story.Cols.CREATION_TIME));
		long storyTime = cursor.getLong(cursor
				.getColumnIndex(MoocSchema.Story.Cols.STORY_TIME));
		double latitude = cursor.getDouble(cursor
				.getColumnIndex(MoocSchema.Story.Cols.LATITUDE));
		double longitude = cursor.getDouble(cursor
				.getColumnIndex(MoocSchema.Story.Cols.LONGITUDE));

		// construct the returned object
		StoryData rValue = new StoryData(rowID, loginId, storyId, title, body,
				audioLink, videoLink, imageName, imageMetaData, tags,
				creationTime, storyTime, latitude, longitude);

		return rValue;
	}
}
