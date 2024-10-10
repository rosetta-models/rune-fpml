package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EquitySwapTransactionSupplement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EquitySwapTransactionSupplementTypeFormatValidator implements Validator<EquitySwapTransactionSupplement> {

	private List<ComparisonResult> getComparisonResults(EquitySwapTransactionSupplement o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<EquitySwapTransactionSupplement> validate(RosettaPath path, EquitySwapTransactionSupplement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquitySwapTransactionSupplement", ValidationType.TYPE_FORMAT, "EquitySwapTransactionSupplement", path, "", error);
		}
		return success("EquitySwapTransactionSupplement", ValidationType.TYPE_FORMAT, "EquitySwapTransactionSupplement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquitySwapTransactionSupplement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquitySwapTransactionSupplement", ValidationType.TYPE_FORMAT, "EquitySwapTransactionSupplement", path, "", res.getError());
				}
				return success("EquitySwapTransactionSupplement", ValidationType.TYPE_FORMAT, "EquitySwapTransactionSupplement", path, "");
			})
			.collect(toList());
	}

}
