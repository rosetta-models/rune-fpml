package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TransactionClassificationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TransactionClassificationModelTypeFormatValidator implements Validator<TransactionClassificationModel> {

	private List<ComparisonResult> getComparisonResults(TransactionClassificationModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TransactionClassificationModel> validate(RosettaPath path, TransactionClassificationModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TransactionClassificationModel", ValidationType.TYPE_FORMAT, "TransactionClassificationModel", path, "", error);
		}
		return success("TransactionClassificationModel", ValidationType.TYPE_FORMAT, "TransactionClassificationModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TransactionClassificationModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TransactionClassificationModel", ValidationType.TYPE_FORMAT, "TransactionClassificationModel", path, "", res.getError());
				}
				return success("TransactionClassificationModel", ValidationType.TYPE_FORMAT, "TransactionClassificationModel", path, "");
			})
			.collect(toList());
	}

}
