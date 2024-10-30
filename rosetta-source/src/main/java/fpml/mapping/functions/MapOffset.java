package fpml.mapping.functions;

import cdm.base.datetime.Offset;
import cdm.base.datetime.Offset.OffsetBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapOffset.MapOffsetDefault.class)
public abstract class MapOffset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return offset 
	*/
	public Offset evaluate(DataDocument fpmlDataDocument) {
		Offset.OffsetBuilder offsetBuilder = doEvaluate(fpmlDataDocument);
		
		final Offset offset;
		if (offsetBuilder == null) {
			offset = null;
		} else {
			offset = offsetBuilder.build();
			objectValidator.validate(Offset.class, offset);
		}
		
		return offset;
	}

	protected abstract Offset.OffsetBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapOffsetDefault extends MapOffset {
		@Override
		protected Offset.OffsetBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Offset.OffsetBuilder offset = Offset.builder();
			return assignOutput(offset, fpmlDataDocument);
		}
		
		protected Offset.OffsetBuilder assignOutput(Offset.OffsetBuilder offset, DataDocument fpmlDataDocument) {
			offset = toBuilder(Offset.builder()
				.setPeriodMultiplier(null)
				.setPeriod(null)
				.setDayType(null)
				.build());
			
			return Optional.ofNullable(offset)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
