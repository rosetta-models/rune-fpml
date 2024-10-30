package fpml.mapping.functions;

import cdm.base.staticdata.party.Address;
import cdm.base.staticdata.party.Address.AddressBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapAddressList.MapAddressListDefault.class)
public abstract class MapAddressList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCountryWithScheme mapCountryWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return addressList 
	*/
	public List<? extends Address> evaluate(DataDocument fpmlDataDocument) {
		List<Address.AddressBuilder> addressListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends Address> addressList;
		if (addressListBuilder == null) {
			addressList = null;
		} else {
			addressList = addressListBuilder.stream().map(Address::build).collect(Collectors.toList());
			objectValidator.validate(Address.class, addressList);
		}
		
		return addressList;
	}

	protected abstract List<Address.AddressBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAddressListDefault extends MapAddressList {
		@Override
		protected List<Address.AddressBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<Address.AddressBuilder> addressList = new ArrayList<>();
			return assignOutput(addressList, fpmlDataDocument);
		}
		
		protected List<Address.AddressBuilder> assignOutput(List<Address.AddressBuilder> addressList, DataDocument fpmlDataDocument) {
			addressList.addAll(toBuilder(MapperC.<Address>of(MapperS.of(Address.builder()
				.setStreet(Collections.<String>emptyList())
				.setCity(null)
				.setState(null)
				.setCountryValue(mapCountryWithScheme.evaluate(fpmlDataDocument))
				.setPostalCode(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(addressList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
