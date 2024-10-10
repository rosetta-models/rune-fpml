package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TransferFeeDefinition;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TransferFeeDefinitionTypeFormatValidator implements Validator<TransferFeeDefinition> {

	private List<ComparisonResult> getComparisonResults(TransferFeeDefinition o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TransferFeeDefinition> validate(RosettaPath path, TransferFeeDefinition o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TransferFeeDefinition", ValidationType.TYPE_FORMAT, "TransferFeeDefinition", path, "", error);
		}
		return success("TransferFeeDefinition", ValidationType.TYPE_FORMAT, "TransferFeeDefinition", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TransferFeeDefinition o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TransferFeeDefinition", ValidationType.TYPE_FORMAT, "TransferFeeDefinition", path, "", res.getError());
				}
				return success("TransferFeeDefinition", ValidationType.TYPE_FORMAT, "TransferFeeDefinition", path, "");
			})
			.collect(toList());
	}

}
