package frc.robot.vision;

import java.util.List;
import java.util.OptionalDouble;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

/**
 * Small helper that wraps PhotonVision camera and finds an AprilTag by ID,
 * returning the yaw offset (degrees) to the tag when present.
 */
public class PhotonTurretAimer {

    private final PhotonCamera camera;
    private final int apriltagId;

    public PhotonTurretAimer(String cameraName, int apriltagId) {
        this.camera = new PhotonCamera(cameraName);
        this.apriltagId = apriltagId;
    }

    /**
     * Returns OptionalDouble.empty() when the requested tag is not visible.
     * Otherwise returns the yaw (degrees) to the tracked target.
     */
    public OptionalDouble getYawOffsetDegrees() {
        try {
            PhotonPipelineResult result = camera.getLatestResult();
            if (result == null || !result.hasTargets()) {
                return OptionalDouble.empty();
            }
            List<PhotonTrackedTarget> targets = result.getTargets();
            for (PhotonTrackedTarget t : targets) {
                if (t.getFiducialId() == apriltagId) {
                    // getYaw gives horizontal offset in degrees
                    return OptionalDouble.of(t.getYaw());
                }
            }
            return OptionalDouble.empty();
        } catch (Throwable ex) {
            // If Photon isn't available or a method changed, treat as no target.
            return OptionalDouble.empty();
        }
    }
}
