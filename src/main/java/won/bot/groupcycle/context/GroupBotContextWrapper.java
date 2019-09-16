package won.bot.groupcycle.context;

import won.bot.framework.bot.context.BotContext;
import won.bot.framework.bot.context.BotContextWrapper;

import java.net.URI;
import java.util.List;

/**
 * Created by fsuda on 14.04.2017.
 */
public class GroupBotContextWrapper extends BotContextWrapper {
    private final String groupListName;
    private final String groupMembersListName;

    public GroupBotContextWrapper(BotContext botContext, String botName) {
        super(botContext, botName);
        this.groupListName = botName + ":groupList";
        this.groupMembersListName = botName + ":groupMembers";
    }

    @Override
    public String getAtomCreateListName() {
        throw new UnsupportedOperationException("This List is not available for this BotContextWrapper");
    }

    public String getGroupListName() {
        return groupListName;
    }

    public String getGroupMembersListName() {
        return groupMembersListName;
    }

    public List<URI> getGroupAtomUris() {
        return getBotContext().getNamedAtomUriList(getGroupListName());
    }

    public List<URI> getGroupMemberAtomUris() {
        return getBotContext().getNamedAtomUriList(getGroupMembersListName());
    }
}
