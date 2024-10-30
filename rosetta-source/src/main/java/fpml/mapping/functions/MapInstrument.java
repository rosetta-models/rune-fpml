package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.Instrument.InstrumentBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapInstrument.MapInstrumentDefault.class)
public abstract class MapInstrument implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapListedDerivative mapListedDerivative;
	@Inject protected MapLoan mapLoan;
	@Inject protected MapSecurity mapSecurity;

	/**
	* @param fpmlDataDocument 
	* @return instrument 
	*/
	public Instrument evaluate(DataDocument fpmlDataDocument) {
		Instrument.InstrumentBuilder instrumentBuilder = doEvaluate(fpmlDataDocument);
		
		final Instrument instrument;
		if (instrumentBuilder == null) {
			instrument = null;
		} else {
			instrument = instrumentBuilder.build();
			objectValidator.validate(Instrument.class, instrument);
		}
		
		return instrument;
	}

	protected abstract Instrument.InstrumentBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapInstrumentDefault extends MapInstrument {
		@Override
		protected Instrument.InstrumentBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Instrument.InstrumentBuilder instrument = Instrument.builder();
			return assignOutput(instrument, fpmlDataDocument);
		}
		
		protected Instrument.InstrumentBuilder assignOutput(Instrument.InstrumentBuilder instrument, DataDocument fpmlDataDocument) {
			instrument = toBuilder(Instrument.builder()
				.setListedDerivative(mapListedDerivative.evaluate(fpmlDataDocument))
				.setLoan(mapLoan.evaluate(fpmlDataDocument))
				.setSecurity(mapSecurity.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(instrument)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
