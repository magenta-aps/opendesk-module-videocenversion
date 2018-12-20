package dk.opendesk.videoconversion.video;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

public class VideoInputHandlerImplTest {

    private VideoInputHandler videoInputHandler;

    @Before
    public void setUp() {
        videoInputHandler = new VideoInputHandlerImpl();
    }

    @Test
    public void formatIsMov() {
        assertEquals("mov", videoInputHandler.getFormat("video.mov"));
    }

    @Test
    public void convertsVideoFormatToLowerCase() {
        assertEquals("mov", videoInputHandler.getFormat("video.MOV"));
    }

    @Test
    public void handlesFilenameWithSeveralDots() {
        assertEquals("mov", videoInputHandler.getFormat("video.xyz.mov"));
    }

    @Test
    public void returnNullWhenNoExtension() {
        assertNull(videoInputHandler.getFormat("video"));
    }

    @Test
    public void returnNullWhenExtensionNotVideoExtension() {
        assertNull(videoInputHandler.getFormat("video.xyz"));
    }

    @Test
    public void pathIs2000_01_01_12_00_12345678_1234_1234_1234_012345678912_bin() {

    }

}
