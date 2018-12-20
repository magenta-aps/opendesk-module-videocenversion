package dk.opendesk.videoconversion.video;

import org.alfresco.service.cmr.repository.NodeRef;

public interface VideoInputHandler {

    /**
     * Get the format of the file contained in the NodeRef
     * @param nodeRef The NodeRef containing the file
     * @return The format of the video or null if the file is not a video file
     */
    String getFormat(NodeRef nodeRef);

    /**
     * Get the absolute path to the file in the alf_data folder
     * @param nodeRef The NodeRef containing the file
     * @return The absolute path to the file
     */
    String getPath(NodeRef nodeRef);
}
