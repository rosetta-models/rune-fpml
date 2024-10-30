package fpml.mapping.functions;

import cdm.base.staticdata.party.TelephoneNumber;
import cdm.base.staticdata.party.TelephoneNumber.TelephoneNumberBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapTelephoneNumberList.MapTelephoneNumberListDefault.class)
public abstract class MapTelephoneNumberList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return telephoneNumberList 
	*/
	public List<? extends TelephoneNumber> evaluate(DataDocument fpmlDataDocument) {
		List<TelephoneNumber.TelephoneNumberBuilder> telephoneNumberListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends TelephoneNumber> telephoneNumberList;
		if (telephoneNumberListBuilder == null) {
			telephoneNumberList = null;
		} else {
			telephoneNumberList = telephoneNumberListBuilder.stream().map(TelephoneNumber::build).collect(Collectors.toList());
			objectValidator.validate(TelephoneNumber.class, telephoneNumberList);
		}
		
		return telephoneNumberList;
	}

	protected abstract List<TelephoneNumber.TelephoneNumberBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapTelephoneNumberListDefault extends MapTelephoneNumberList {
		@Override
		protected List<TelephoneNumber.TelephoneNumberBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<TelephoneNumber.TelephoneNumberBuilder> telephoneNumberList = new ArrayList<>();
			return assignOutput(telephoneNumberList, fpmlDataDocument);
		}
		
		protected List<TelephoneNumber.TelephoneNumberBuilder> assignOutput(List<TelephoneNumber.TelephoneNumberBuilder> telephoneNumberList, DataDocument fpmlDataDocument) {
			telephoneNumberList.addAll(toBuilder(MapperC.<TelephoneNumber>of(MapperS.of(TelephoneNumber.builder()
				.setTelephoneNumberType(null)
				.setNumber(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(telephoneNumberList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
