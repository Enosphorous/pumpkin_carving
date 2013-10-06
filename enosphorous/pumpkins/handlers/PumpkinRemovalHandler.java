package enosphorous.pumpkins.handlers;

import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

public class PumpkinRemovalHandler {
	
	@ForgeSubscribe
	public void onDecorateBiome(DecorateBiomeEvent.Decorate event) {
	switch(event.type) {
	case PUMPKIN: event.setResult(Result.DENY);
	default: break;
	}
	}

}
