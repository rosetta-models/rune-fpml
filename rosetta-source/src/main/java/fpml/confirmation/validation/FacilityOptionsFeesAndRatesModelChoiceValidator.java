package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityOptionsFeesAndRatesModelChoice;
import fpml.confirmation.FixedRateOption;
import fpml.confirmation.FloatingRateOption;
import fpml.confirmation.LcOption;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityOptionsFeesAndRatesModelChoiceValidator implements Validator<FacilityOptionsFeesAndRatesModelChoice> {

	private List<ComparisonResult> getComparisonResults(FacilityOptionsFeesAndRatesModelChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fixedRateOption", (FixedRateOption) o.getFixedRateOption() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateOption", (FloatingRateOption) o.getFloatingRateOption() != null ? 1 : 0, 0, 1), 
				checkCardinality("lcOption", (LcOption) o.getLcOption() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FacilityOptionsFeesAndRatesModelChoice> validate(RosettaPath path, FacilityOptionsFeesAndRatesModelChoice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityOptionsFeesAndRatesModelChoice", ValidationType.CARDINALITY, "FacilityOptionsFeesAndRatesModelChoice", path, "", error);
		}
		return success("FacilityOptionsFeesAndRatesModelChoice", ValidationType.CARDINALITY, "FacilityOptionsFeesAndRatesModelChoice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityOptionsFeesAndRatesModelChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityOptionsFeesAndRatesModelChoice", ValidationType.CARDINALITY, "FacilityOptionsFeesAndRatesModelChoice", path, "", res.getError());
				}
				return success("FacilityOptionsFeesAndRatesModelChoice", ValidationType.CARDINALITY, "FacilityOptionsFeesAndRatesModelChoice", path, "");
			})
			.collect(toList());
	}

}
