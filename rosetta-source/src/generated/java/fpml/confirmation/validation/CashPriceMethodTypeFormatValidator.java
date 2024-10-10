package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CashPriceMethod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CashPriceMethodTypeFormatValidator implements Validator<CashPriceMethod> {

	private List<ComparisonResult> getComparisonResults(CashPriceMethod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CashPriceMethod> validate(RosettaPath path, CashPriceMethod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CashPriceMethod", ValidationType.TYPE_FORMAT, "CashPriceMethod", path, "", error);
		}
		return success("CashPriceMethod", ValidationType.TYPE_FORMAT, "CashPriceMethod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CashPriceMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CashPriceMethod", ValidationType.TYPE_FORMAT, "CashPriceMethod", path, "", res.getError());
				}
				return success("CashPriceMethod", ValidationType.TYPE_FORMAT, "CashPriceMethod", path, "");
			})
			.collect(toList());
	}

}
