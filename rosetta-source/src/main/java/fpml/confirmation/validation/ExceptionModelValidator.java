package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdditionalData;
import fpml.confirmation.ExceptionModel;
import fpml.confirmation.Reason;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ExceptionModelValidator implements Validator<ExceptionModel> {

	private List<ComparisonResult> getComparisonResults(ExceptionModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reason", (List<? extends Reason>) o.getReason() == null ? 0 : ((List<? extends Reason>) o.getReason()).size(), 1, 0), 
				checkCardinality("additionalData", (AdditionalData) o.getAdditionalData() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ExceptionModel> validate(RosettaPath path, ExceptionModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ExceptionModel", ValidationType.CARDINALITY, "ExceptionModel", path, "", error);
		}
		return success("ExceptionModel", ValidationType.CARDINALITY, "ExceptionModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExceptionModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExceptionModel", ValidationType.CARDINALITY, "ExceptionModel", path, "", res.getError());
				}
				return success("ExceptionModel", ValidationType.CARDINALITY, "ExceptionModel", path, "");
			})
			.collect(toList());
	}

}
