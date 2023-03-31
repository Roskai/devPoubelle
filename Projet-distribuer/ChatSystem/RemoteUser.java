package ChatSystem;

import java.net.InetAddress;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Cette classe représente un utilisateur distant du système de chat.
 */
public class RemoteUser {
    /**
     * Le surnom de l'utilisateur.
     */
    private final String nickname;

    /**
     * L'adresse IP de l'utilisateur.
     */
    private final InetAddress address;

    /**
     * Liste de tous les utilisateurs distants.
     */
    private static List<RemoteUser> remoteUsers = new CopyOnWriteArrayList<>();

    /**
     * Constructeur de la classe RemoteUser.
     *
     * @param nickname le surnom de l'utilisateur.
     * @param address l'adresse IP de l'utilisateur.
     */
    public RemoteUser(String nickname, InetAddress address) {
        this.nickname = nickname;
        this.address = address;
        remoteUsers.add(this);
    }

    /**
     * Obtient le surnom de l'utilisateur.
     *
     * @return Le surnom de l'utilisateur.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Obtient l'adresse IP de l'utilisateur.
     *
     * @return L'adresse IP de l'utilisateur.
     */
    public InetAddress getAddress() {
        return address;
    }

    /**
     * Supprime un utilisateur distant de la liste.
     *
     * @param remoteUser L'utilisateur à supprimer.
     */
    public static void removeRemoteUser(RemoteUser remoteUser) {
        remoteUsers.remove(remoteUser);
    }

    /**
     * Obtient la liste de tous les utilisateurs distants.
     *
     * @return La liste de tous les utilisateurs distants.
     */
    public static List<RemoteUser> getRemoteUsers() {
        return remoteUsers;
    }

    /**
     * Obtient une liste des utilisateurs distants qui ont le même surnom et la même adresse IP que l'utilisateur donné.
     * Cette méthode crée une copie de la liste pour éviter les conflits lors de la suppression d'un élément.
     *
     * @param remoteUser L'utilisateur à rechercher.
     * @return La liste des utilisateurs distants qui ont le même surnom et la même adresse IP que l'utilisateur donné.
     */
    public static List<RemoteUser> getListRemoteUsers(RemoteUser remoteUser) {
        List<RemoteUser> result = new CopyOnWriteArrayList<>();
        for (RemoteUser user : remoteUsers) {
            if (user.getNickname().equals(remoteUser.getNickname()) && user.getAddress().equals(remoteUser.getAddress())) {
                result.add(user);
            }
        }
        return result;
    }
}
