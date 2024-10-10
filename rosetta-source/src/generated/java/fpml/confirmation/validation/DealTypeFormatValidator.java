package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Deal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DealTypeFormatValidator implements Validator<Deal> {

	private List<ComparisonResult> getComparisonResults(Deal o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("description", o.getDescription(), 0, of(255), empty())
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
			return failure("Deal", ValidationType.TYPE_FORMAT, "Deal", path, "", error);
		}
		return success("Deal", ValidationType.TYPE_FORMAT, "Deal", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Deal o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Deal", ValidationType.TYPE_FORMAT, "Deal", path, "", res.getError());
				}
				return success("Deal", ValidationType.TYPE_FORMAT, "Deal", path, "");
			})
			.collect(toList());
	}

}
