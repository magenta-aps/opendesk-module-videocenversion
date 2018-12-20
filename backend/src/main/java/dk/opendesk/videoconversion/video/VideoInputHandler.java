package dk.opendesk.videoconversion.video;

import org.alfresco.service.cmr.repository.ContentData;

public interface VideoInputHandler {

    /**
     * Get the format of the file contained in the NodeRef
     * @param filename The filename of the uploaded file
     * @return The format of the video or null if the file is not a video file
     */
    String getFormat(String filename);

    /**
     * Get the absolute path to the file in the alf_data folder
     * @param contentData The content data of the NodeRef for the video file
     * @return The absolute path to the file
     */
    String getPath(ContentData contentData);
}
