package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ExchangeIdentifierModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ExchangeIdentifierModelTypeFormatValidator implements Validator<ExchangeIdentifierModel> {

	private List<ComparisonResult> getComparisonResults(ExchangeIdentifierModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ExchangeIdentifierModel> validate(RosettaPath path, ExchangeIdentifierModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ExchangeIdentifierModel", ValidationType.TYPE_FORMAT, "ExchangeIdentifierModel", path, "", error);
		}
		return success("ExchangeIdentifierModel", ValidationType.TYPE_FORMAT, "ExchangeIdentifierModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExchangeIdentifierModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExchangeIdentifierModel", ValidationType.TYPE_FORMAT, "ExchangeIdentifierModel", path, "", res.getError());
				}
				return success("ExchangeIdentifierModel", ValidationType.TYPE_FORMAT, "ExchangeIdentifierModel", path, "");
			})
			.collect(toList());
	}

}
