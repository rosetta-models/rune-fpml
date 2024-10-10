package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReturnLegValuation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReturnLegValuationTypeFormatValidator implements Validator<ReturnLegValuation> {

	private List<ComparisonResult> getComparisonResults(ReturnLegValuation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ReturnLegValuation> validate(RosettaPath path, ReturnLegValuation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReturnLegValuation", ValidationType.TYPE_FORMAT, "ReturnLegValuation", path, "", error);
		}
		return success("ReturnLegValuation", ValidationType.TYPE_FORMAT, "ReturnLegValuation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnLegValuation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnLegValuation", ValidationType.TYPE_FORMAT, "ReturnLegValuation", path, "", res.getError());
				}
				return success("ReturnLegValuation", ValidationType.TYPE_FORMAT, "ReturnLegValuation", path, "");
			})
			.collect(toList());
	}

}
