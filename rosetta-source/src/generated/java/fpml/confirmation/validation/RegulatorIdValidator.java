package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RegulatorId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RegulatorIdValidator implements Validator<RegulatorId> {

	private List<ComparisonResult> getComparisonResults(RegulatorId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("regulatorIdScheme", (String) o.getRegulatorIdScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<RegulatorId> validate(RosettaPath path, RegulatorId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RegulatorId", ValidationType.CARDINALITY, "RegulatorId", path, "", error);
		}
		return success("RegulatorId", ValidationType.CARDINALITY, "RegulatorId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatorId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatorId", ValidationType.CARDINALITY, "RegulatorId", path, "", res.getError());
				}
				return success("RegulatorId", ValidationType.CARDINALITY, "RegulatorId", path, "");
			})
			.collect(toList());
	}

}
