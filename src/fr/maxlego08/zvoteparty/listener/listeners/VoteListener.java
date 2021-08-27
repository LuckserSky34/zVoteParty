package fr.maxlego08.zvoteparty.listener.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;

import fr.maxlego08.zvoteparty.ZVotePartyPlugin;
import fr.maxlego08.zvoteparty.api.VotePartyManager;
import fr.maxlego08.zvoteparty.listener.ListenerAdapter;

public class VoteListener extends ListenerAdapter {

	private final ZVotePartyPlugin plugin;

	/**
	 * @param plugin
	 */
	public VoteListener(ZVotePartyPlugin plugin) {
		super();
		this.plugin = plugin;
	}

	@Override
	public void onVote(VotifierEvent event, Vote vote, String username, String serviceName) {
		VotePartyManager manager = this.plugin.getManager();
		manager.vote(username, serviceName);
	}

	@Override
	protected void onConnect(PlayerJoinEvent event, Player player) {
		VotePartyManager manager = this.plugin.getManager();
		manager.giveVotes(player);
	}
	
}