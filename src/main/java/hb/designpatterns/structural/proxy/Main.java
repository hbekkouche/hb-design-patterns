package hb.designpatterns.structural.proxy;

import java.util.HashMap;
import java.util.Map;

// YouTube service interface
interface YouTubeService {
    String getVideo(String videoId);
}

// Real YouTube service implementing the YouTubeService interface
class RealYouTubeService implements YouTubeService {
    public RealYouTubeService() {
        // Simulating expensive initialization
        System.out.println("Initializing YouTube service...");
        // Initialization logic here
    }

    @Override
    public String getVideo(String videoId) {
        // Simulating fetching video from YouTube
        System.out.println("Fetching video from YouTube for video ID: " + videoId);
        return "Video data for video ID: " + videoId;
    }
}

// Proxy for lazy initialization and caching
class YouTubeServiceProxy implements YouTubeService {
    private YouTubeService realService;
    private Map<String, String> cache;

    public YouTubeServiceProxy() {
        this.cache = new HashMap<>();
    }

    @Override
    public String getVideo(String videoId) {
        // Lazy initialization
        if (realService == null) {
            realService = new RealYouTubeService();
        }

        // Check cache
        if (cache.containsKey(videoId)) {
            System.out.println("Fetching video from cache for video ID: " + videoId);
            return cache.get(videoId);
        }

        // Fetch from the real service
        String videoData = realService.getVideo(videoId);
        // Cache the result
        cache.put(videoId, videoData);
        return videoData;
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        // Using the proxy for YouTube service
        YouTubeService proxy = new YouTubeServiceProxy();

        // First request - initialization and fetching video
        System.out.println(proxy.getVideo("abc123"));

        // Second request - fetching video from cache
        System.out.println(proxy.getVideo("abc123"));
    }
}
