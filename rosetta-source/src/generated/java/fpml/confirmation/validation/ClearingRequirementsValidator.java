package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ClearingRequirements;
import fpml.confirmation.SupervisoryBody;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ClearingRequirementsValidator implements Validator<ClearingRequirements> {

	private List<ComparisonResult> getComparisonResults(ClearingRequirements o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("supervisoryBody", (SupervisoryBody) o.getSupervisoryBody() != null ? 1 : 0, 1, 1), 
				checkCardinality("mandatorilyClearable", (Boolean) o.getMandatorilyClearable() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<ClearingRequirements> validate(RosettaPath path, ClearingRequirements o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ClearingRequirements", ValidationType.CARDINALITY, "ClearingRequirements", path, "", error);
		}
		return success("ClearingRequirements", ValidationType.CARDINALITY, "ClearingRequirements", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingRequirements o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearingRequirements", ValidationType.CARDINALITY, "ClearingRequirements", path, "", res.getError());
				}
				return success("ClearingRequirements", ValidationType.CARDINALITY, "ClearingRequirements", path, "");
			})
			.collect(toList());
	}

}
