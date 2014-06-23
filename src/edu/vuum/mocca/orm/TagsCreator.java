
package edu.vuum.mocca.orm;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.Cursor;
import edu.vuum.mocca.provider.MoocSchema;

/**
 * TagsCreator is a helper class that does convenience functions for converting
 * between the Custom ORM objects, ContentValues, and Cursors.
 * 
 * @author Michael A. Walker
 * 
 */
public class TagsCreator {

	/**
	 * Create a ContentValues from a provided TagsData.
	 * 
	 * @param data
	 *            StoryData to be converted.
	 * @return ContentValues that is created from the StoryData object
	 */
	public static ContentValues getCVfromTags(final TagsData data) {
		ContentValues rValue = new ContentValues();
		rValue.put(MoocSchema.Tags.Cols.LOGIN_ID, data.loginId);
		rValue.put(MoocSchema.Tags.Cols.STORY_ID, data.storyId);
		rValue.put(MoocSchema.Tags.Cols.TAG, data.tag);
		return rValue;
	}

	/**
	 * Get all of the TagsData from the passed in cursor.
	 * 
	 * @param cursor
	 *            passed in cursor
	 * @return ArrayList<TagsData\> The set of TagsData
	 */
	public static ArrayList<TagsData> getTagsDataArrayListFromCursor(
			Cursor cursor) {
		ArrayList<TagsData> rValue = new ArrayList<TagsData>();
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				do {
					rValue.add(getTagsDataFromCursor(cursor));
				} while (cursor.moveToNext() == true);
			}
		}
		return rValue;
	}

	/**
	 * Get the first TagsData from the passed in cursor.
	 * 
	 * @param cursor
	 *            passed in cursor
	 * @return TagsData object
	 */
	public static TagsData getTagsDataFromCursor(Cursor cursor) {

		long rowID = cursor.getLong(cursor
				.getColumnIndex(MoocSchema.Tags.Cols.ID));
		long loginId = cursor.getLong(cursor
				.getColumnIndex(MoocSchema.Tags.Cols.LOGIN_ID));
		long storyId = cursor.getLong(cursor
				.getColumnIndex(MoocSchema.Tags.Cols.STORY_ID));
		String tag = cursor.getString(cursor
				.getColumnIndex(MoocSchema.Tags.Cols.TAG));

		// construct the returned object
		TagsData rValue = new TagsData(rowID, loginId, storyId, tag);

		return rValue;
	}
}
