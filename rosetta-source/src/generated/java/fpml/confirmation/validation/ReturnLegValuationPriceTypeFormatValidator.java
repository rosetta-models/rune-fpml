package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReturnLegValuationPrice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReturnLegValuationPriceTypeFormatValidator implements Validator<ReturnLegValuationPrice> {

	private List<ComparisonResult> getComparisonResults(ReturnLegValuationPrice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ReturnLegValuationPrice> validate(RosettaPath path, ReturnLegValuationPrice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReturnLegValuationPrice", ValidationType.TYPE_FORMAT, "ReturnLegValuationPrice", path, "", error);
		}
		return success("ReturnLegValuationPrice", ValidationType.TYPE_FORMAT, "ReturnLegValuationPrice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnLegValuationPrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnLegValuationPrice", ValidationType.TYPE_FORMAT, "ReturnLegValuationPrice", path, "", res.getError());
				}
				return success("ReturnLegValuationPrice", ValidationType.TYPE_FORMAT, "ReturnLegValuationPrice", path, "");
			})
			.collect(toList());
	}

}
