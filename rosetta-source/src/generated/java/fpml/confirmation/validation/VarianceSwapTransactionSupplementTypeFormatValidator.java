package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.VarianceSwapTransactionSupplement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VarianceSwapTransactionSupplementTypeFormatValidator implements Validator<VarianceSwapTransactionSupplement> {

	private List<ComparisonResult> getComparisonResults(VarianceSwapTransactionSupplement o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<VarianceSwapTransactionSupplement> validate(RosettaPath path, VarianceSwapTransactionSupplement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VarianceSwapTransactionSupplement", ValidationType.TYPE_FORMAT, "VarianceSwapTransactionSupplement", path, "", error);
		}
		return success("VarianceSwapTransactionSupplement", ValidationType.TYPE_FORMAT, "VarianceSwapTransactionSupplement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceSwapTransactionSupplement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VarianceSwapTransactionSupplement", ValidationType.TYPE_FORMAT, "VarianceSwapTransactionSupplement", path, "", res.getError());
				}
				return success("VarianceSwapTransactionSupplement", ValidationType.TYPE_FORMAT, "VarianceSwapTransactionSupplement", path, "");
			})
			.collect(toList());
	}

}
