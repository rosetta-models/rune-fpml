package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.VarianceOptionTransactionSupplement;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VarianceOptionTransactionSupplementTypeFormatValidator implements Validator<VarianceOptionTransactionSupplement> {

	private List<ComparisonResult> getComparisonResults(VarianceOptionTransactionSupplement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("optionEntitlement", o.getOptionEntitlement(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkNumber("multiplier", o.getMultiplier(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<VarianceOptionTransactionSupplement> validate(RosettaPath path, VarianceOptionTransactionSupplement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VarianceOptionTransactionSupplement", ValidationType.TYPE_FORMAT, "VarianceOptionTransactionSupplement", path, "", error);
		}
		return success("VarianceOptionTransactionSupplement", ValidationType.TYPE_FORMAT, "VarianceOptionTransactionSupplement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceOptionTransactionSupplement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VarianceOptionTransactionSupplement", ValidationType.TYPE_FORMAT, "VarianceOptionTransactionSupplement", path, "", res.getError());
				}
				return success("VarianceOptionTransactionSupplement", ValidationType.TYPE_FORMAT, "VarianceOptionTransactionSupplement", path, "");
			})
			.collect(toList());
	}

}
