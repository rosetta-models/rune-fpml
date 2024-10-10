package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EvergreenOption;
import fpml.confirmation.Period;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EvergreenOptionValidator implements Validator<EvergreenOption> {

	private List<ComparisonResult> getComparisonResults(EvergreenOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("nonRenewalNoticePeriod", (Period) o.getNonRenewalNoticePeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("extensionPeriod", (Period) o.getExtensionPeriod() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<EvergreenOption> validate(RosettaPath path, EvergreenOption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EvergreenOption", ValidationType.CARDINALITY, "EvergreenOption", path, "", error);
		}
		return success("EvergreenOption", ValidationType.CARDINALITY, "EvergreenOption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EvergreenOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EvergreenOption", ValidationType.CARDINALITY, "EvergreenOption", path, "", res.getError());
				}
				return success("EvergreenOption", ValidationType.CARDINALITY, "EvergreenOption", path, "");
			})
			.collect(toList());
	}

}
