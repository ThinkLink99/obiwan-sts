package obiwanmod.cards.uncommon;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.red.Inflame;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import obiwanmod.cards.BaseCard;
import obiwanmod.obiwan.ObiWan;
import obiwanmod.util.CardStats;

public class MeditateCard extends BaseCard {
    public static final String ID  = makeID(MeditateCard.class.getSimpleName());
    public static final CardStats info = new CardStats(
            ObiWan.Enums.CARD_COLOR,
            CardType.POWER,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            1
    );

    //These will be used in the constructor. Technically you can just use the values directly,
    //but constants at the top of the file are easy to adjust.
    private static final int STRENGTH = 2;
    private static final int UPG_STRENGTH = 2;

    public MeditateCard() {
        super(ID, info); //Pass the required information to the BaseCard constructor.

        setCustomVar("meditate", STRENGTH, UPG_STRENGTH);

        tags.add(CardTags.STARTER_STRIKE);
        tags.add(CardTags.STRIKE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        //addToBot(new ApplyPowerAction(p, p, new ));
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new MeditateCard();
    }
}
