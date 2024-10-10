package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AbstractFacility;
import fpml.confirmation.Currency;
import fpml.confirmation.Deal;
import fpml.confirmation.DealRolesModel;
import fpml.confirmation.DealRulesModel;
import fpml.confirmation.DealSummarySequence;
import fpml.confirmation.InstrumentId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DealValidator implements Validator<Deal> {

	private List<ComparisonResult> getComparisonResults(Deal o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("instrumentId", (List<? extends InstrumentId>) o.getInstrumentId() == null ? 0 : ((List<? extends InstrumentId>) o.getInstrumentId()).size(), 1, 0), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("dealRolesModel", (DealRolesModel) o.getDealRolesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("creditAgreementDate", (Date) o.getCreditAgreementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("dealSummarySequence", (DealSummarySequence) o.getDealSummarySequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("dealRulesModel", (DealRulesModel) o.getDealRulesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("facilityGroup", (List<? extends AbstractFacility>) o.getFacilityGroup() == null ? 0 : ((List<? extends AbstractFacility>) o.getFacilityGroup()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<Deal> validate(RosettaPath path, Deal o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Deal", ValidationType.CARDINALITY, "Deal", path, "", error);
		}
		return success("Deal", ValidationType.CARDINALITY, "Deal", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Deal o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Deal", ValidationType.CARDINALITY, "Deal", path, "", res.getError());
				}
				return success("Deal", ValidationType.CARDINALITY, "Deal", path, "");
			})
			.collect(toList());
	}

}
