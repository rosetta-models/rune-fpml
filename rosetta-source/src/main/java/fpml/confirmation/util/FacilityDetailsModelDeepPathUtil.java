package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.FacilityIdentifier;
import fpml.confirmation.FacilitySummary;
import fpml.confirmation.InstrumentId;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class FacilityDetailsModelDeepPathUtil {
	public List<InstrumentId> chooseInstrumentId(FacilityDetailsModel facilityDetailsModel) {
		final MapperS<FacilityIdentifier> facilityIdentifier = MapperS.of(facilityDetailsModel).<FacilityIdentifier>map("getFacilityIdentifier", _facilityDetailsModel -> _facilityDetailsModel.getFacilityIdentifier());
		if (exists(facilityIdentifier).getOrDefault(false)) {
			return facilityIdentifier.<InstrumentId>mapC("getInstrumentId", _facilityIdentifier -> _facilityIdentifier.getInstrumentId()).getMulti();
		}
		final MapperS<FacilitySummary> facilitySummary = MapperS.of(facilityDetailsModel).<FacilitySummary>map("getFacilitySummary", _facilityDetailsModel -> _facilityDetailsModel.getFacilitySummary());
		if (exists(facilitySummary).getOrDefault(false)) {
			return facilitySummary.<InstrumentId>mapC("getInstrumentId", _facilitySummary -> _facilitySummary.getInstrumentId()).getMulti();
		}
		return Collections.<InstrumentId>emptyList();
	}
	
	public String chooseDescription(FacilityDetailsModel facilityDetailsModel) {
		final MapperS<FacilityIdentifier> facilityIdentifier = MapperS.of(facilityDetailsModel).<FacilityIdentifier>map("getFacilityIdentifier", _facilityDetailsModel -> _facilityDetailsModel.getFacilityIdentifier());
		if (exists(facilityIdentifier).getOrDefault(false)) {
			return facilityIdentifier.<String>map("getDescription", _facilityIdentifier -> _facilityIdentifier.getDescription()).get();
		}
		final MapperS<FacilitySummary> facilitySummary = MapperS.of(facilityDetailsModel).<FacilitySummary>map("getFacilitySummary", _facilityDetailsModel -> _facilityDetailsModel.getFacilitySummary());
		if (exists(facilitySummary).getOrDefault(false)) {
			return facilitySummary.<String>map("getDescription", _facilitySummary -> _facilitySummary.getDescription()).get();
		}
		return null;
	}
	
	public String chooseId(FacilityDetailsModel facilityDetailsModel) {
		final MapperS<FacilityIdentifier> facilityIdentifier = MapperS.of(facilityDetailsModel).<FacilityIdentifier>map("getFacilityIdentifier", _facilityDetailsModel -> _facilityDetailsModel.getFacilityIdentifier());
		if (exists(facilityIdentifier).getOrDefault(false)) {
			return facilityIdentifier.<String>map("getId", _facilityIdentifier -> _facilityIdentifier.getId()).get();
		}
		final MapperS<FacilitySummary> facilitySummary = MapperS.of(facilityDetailsModel).<FacilitySummary>map("getFacilitySummary", _facilityDetailsModel -> _facilityDetailsModel.getFacilitySummary());
		if (exists(facilitySummary).getOrDefault(false)) {
			return facilitySummary.<String>map("getId", _facilitySummary -> _facilitySummary.getId()).get();
		}
		return null;
	}
	
}
