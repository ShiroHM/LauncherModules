package pro.gravit.launchermodules.sashoksupport.socket;

import pro.gravit.launchserver.LaunchServer;
import pro.gravit.launchserver.components.Component;
import pro.gravit.utils.helper.CommonHelper;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class LegacyServerComponent extends Component {
    public String bindAddress;
    public int port;
    public ServerSocketHandler handler;
    public SocketAddress getSocketAddress() {
        return new InetSocketAddress(bindAddress, port);
    }
    @Override
    public void preInit(LaunchServer launchServer) {

    }

    @Override
    public void init(LaunchServer launchServer) {

    }

    @Override
    public void postInit(LaunchServer launchServer) {
        handler = new ServerSocketHandler(launchServer, this);
        CommonHelper.newThread("Legacy Sashok Server", true, handler);
    }
}