package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PayerModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PayerModelTypeFormatValidator implements Validator<PayerModel> {

	private List<ComparisonResult> getComparisonResults(PayerModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PayerModel> validate(RosettaPath path, PayerModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PayerModel", ValidationType.TYPE_FORMAT, "PayerModel", path, "", error);
		}
		return success("PayerModel", ValidationType.TYPE_FORMAT, "PayerModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PayerModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PayerModel", ValidationType.TYPE_FORMAT, "PayerModel", path, "", res.getError());
				}
				return success("PayerModel", ValidationType.TYPE_FORMAT, "PayerModel", path, "");
			})
			.collect(toList());
	}

}
