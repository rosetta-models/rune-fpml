package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OrderIdentifier;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OrderIdentifierTypeFormatValidator implements Validator<OrderIdentifier> {

	private List<ComparisonResult> getComparisonResults(OrderIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<OrderIdentifier> validate(RosettaPath path, OrderIdentifier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OrderIdentifier", ValidationType.TYPE_FORMAT, "OrderIdentifier", path, "", error);
		}
		return success("OrderIdentifier", ValidationType.TYPE_FORMAT, "OrderIdentifier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OrderIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OrderIdentifier", ValidationType.TYPE_FORMAT, "OrderIdentifier", path, "", res.getError());
				}
				return success("OrderIdentifier", ValidationType.TYPE_FORMAT, "OrderIdentifier", path, "");
			})
			.collect(toList());
	}

}
