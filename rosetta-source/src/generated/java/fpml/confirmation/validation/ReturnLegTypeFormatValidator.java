package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReturnLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReturnLegTypeFormatValidator implements Validator<ReturnLeg> {

	private List<ComparisonResult> getComparisonResults(ReturnLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ReturnLeg> validate(RosettaPath path, ReturnLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReturnLeg", ValidationType.TYPE_FORMAT, "ReturnLeg", path, "", error);
		}
		return success("ReturnLeg", ValidationType.TYPE_FORMAT, "ReturnLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnLeg", ValidationType.TYPE_FORMAT, "ReturnLeg", path, "", res.getError());
				}
				return success("ReturnLeg", ValidationType.TYPE_FORMAT, "ReturnLeg", path, "");
			})
			.collect(toList());
	}

}
